/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.participantC.facade;

import io.smallrye.mutiny.Uni;
import it.noah.common.ObjectC;
import it.noah.participantC.dao.DaoC;
import it.noah.participantC.entity.EntityC;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NATCRI
 */
@ApplicationScoped
public class FacadeC {

    @Inject
    DaoC dao;

    public Uni<List<EntityC>> createC(String uuid, OffsetDateTime expire, Long entityAId) {
        EntityC c1 = new EntityC();
        c1.setEntityA(entityAId);
        c1.setTitle("#" + uuid.substring(0, 8) + " C.1");
        c1.setWeight(3);
        c1.setEnabled(true);
        c1.setCreatetime(OffsetDateTime.now());
        EntityC c2 = new EntityC();
        c2.setEntityA(entityAId);
        c2.setTitle("#" + uuid.substring(0, 8) + " C.2");
        c2.setWeight(4);
        c2.setEnabled(true);
        c2.setCreatetime(OffsetDateTime.now());
        List<EntityC> cItems = new ArrayList<>();
        cItems.add(c1);
        cItems.add(c2);
        return dao.createC(uuid, expire, cItems);
    }

    public Uni<List<EntityC>> deleteC(String uuid, OffsetDateTime expire, Long entityAId) {
        return dao.deleteC(uuid, expire, entityAId);
    }

    public Uni<List<EntityC>> updateC(String uuid, OffsetDateTime expire, Long entityAId, String titlePrefix) {
        return dao.updateC(uuid, expire, entityAId, titlePrefix);
    }

    public Uni<List<ObjectC>> getByAId(Long id) {
        return dao.getByAId(id);
    }
}
