/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.participantC.dao;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import it.noah.common.ObjectC;
import it.noah.sagacqrs.dao.DaoUtils;
import it.noah.participantC.entity.EntityC;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jboss.logging.Logger;

/**
 *
 * @author NATCRI
 */
@ApplicationScoped
public class DaoC {

    @Inject
    Logger log;

    @Inject
    PgPool client;

    @Inject
    DaoUtils daoUtils;

    public Uni<List<EntityC>> createC(String uuid, OffsetDateTime expire, List<EntityC> cItems) {
        return client.withTransaction(conn -> {
            return daoUtils.persist(log, conn, uuid, expire, cItems);
        });
    }

    public Uni<List<EntityC>> deleteC(String uuid, OffsetDateTime expire, Long entityAId) {
        return client.withTransaction(conn -> daoUtils.getResultList(log, conn, EntityC.FIND_ALL_BY_ENTITY_A,
                new Object[]{entityAId}, new EntityC())
                .chain(items -> daoUtils.remove(log, conn, uuid, expire, items))
        );
    }

    public Uni<List<EntityC>> logicallyDeleteC(String uuid, OffsetDateTime expire, Long entityAId) {
        return client.withTransaction(conn -> daoUtils.getResultList(log, conn, EntityC.FIND_ALL_BY_ENTITY_A,
                new Object[]{entityAId}, new EntityC())
                .chain(items -> daoUtils.logicallyRemove(log, conn, uuid, expire, items))
        );
    }

    public Uni<List<EntityC>> updateC(String uuid, OffsetDateTime expire, Long entityAId, String titlePrefix) {
        return client.withTransaction(conn -> daoUtils.getResultList(log, conn, EntityC.FIND_ALL_BY_ENTITY_A,
                new Object[]{entityAId}, new EntityC())
                .chain(olds -> {
                    Map<Long, EntityC> news = new HashMap<>();
                    for (EntityC oldC : olds) {
                        EntityC newC = oldC.clone();
                        newC.setTitle(titlePrefix + newC.getTitle());
                        newC.setCreatetime(OffsetDateTime.now());
                        news.put(oldC.getId(), newC);
                    }
                    return daoUtils.merge(log, conn, uuid, expire, olds, news);
                }));
    }

    public Uni<List<EntityC>> updateArchivingC(String uuid, OffsetDateTime expire, Long entityAId, String titlePrefix) {
        return client.withTransaction(conn -> daoUtils.getResultList(log, conn, EntityC.FIND_ALL_BY_ENTITY_A,
                new Object[]{entityAId}, new EntityC())
                .chain(olds -> {
                    Map<Long, EntityC> news = new HashMap<>();
                    for (EntityC oldC : olds) {
                        EntityC newC = oldC.clone();
                        newC.setTitle(titlePrefix + newC.getTitle());
                        newC.setCreatetime(OffsetDateTime.now());
                        news.put(oldC.getId(), newC);
                    }
                    return daoUtils.mergeArchiving(log, conn, uuid, expire, olds, news);
                }));
    }

    public Uni<List<ObjectC>> getByAId(Long id) {
        return client.withConnection(conn -> daoUtils.getResultList(log, conn, EntityC.FIND_ALL_BY_ENTITY_A,
                new Object[]{id}, new EntityC())
                .map(items -> items.stream().map(item -> item.toObjectC()).collect(Collectors.toList())));
    }

}
