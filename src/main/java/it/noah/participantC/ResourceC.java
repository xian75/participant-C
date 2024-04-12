/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.participantC;

import io.quarkus.runtime.Startup;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import it.noah.common.ABCEventDetails;
import it.noah.common.SingleABCEventDetails;
import it.noah.sagacqrs.json.Jsoner;
import it.noah.sagacqrs.participant.ParticipantConfigurator;
import it.noah.sagacqrs.participant.interfaces.IParticipantServer;
import it.noah.participantC.entity.EntityC;
import it.noah.participantC.facade.FacadeC;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.time.OffsetDateTime;
import org.jboss.logging.Logger;

/**
 *
 * @author NATCRI
 */
@Path("/c")
@Startup
@ApplicationScoped
public class ResourceC implements IParticipantServer {

    @Inject
    ParticipantConfigurator configurator;

    @Inject
    Logger log;

    @Inject
    PgPool dbPool;

    @Inject
    Jsoner jsoner;

    @Inject
    FacadeC facade;

    @PostConstruct
    void init() throws Throwable {
        configurator.init(log, dbPool, EntityC.class);
    }

    @Override
    public ParticipantConfigurator getConfigurator() {
        return configurator;
    }

    @Override
    public Uni<Object> execute(@QueryParam(value = "uuid") String uuid, @QueryParam(value = "expire") OffsetDateTime expire,
            @QueryParam(value = "operation") String operation, Object data) {
        switch (operation) {
            case "CREATE_ABC":
                ABCEventDetails details = jsoner.getObject(data, ABCEventDetails.class);
                return facade.createC(uuid, expire, details.getEntityAId()).replaceWith(details);
            case "DELETE_ABC":
                ABCEventDetails details2 = jsoner.getObject(data, ABCEventDetails.class);
                return facade.deleteC(uuid, expire, details2.getEntityAId()).replaceWith(details2);
            case "UPDATE_ABC":
                ABCEventDetails details3 = jsoner.getObject(data, ABCEventDetails.class);
                return facade.updateC(uuid, expire, details3.getEntityAId(), details3.getTitlePrefix()).replaceWith(details3);
            case "READ_ONE_ABC":
                SingleABCEventDetails details4 = jsoner.getObject(data, SingleABCEventDetails.class);
                return facade.getByAId(details4.getEntityAId()).map(objects -> {
                    details4.setCItems(objects);
                    return details4;
                });
            default:
                return throwNoOperationFound(operation);
        }
    }
}
