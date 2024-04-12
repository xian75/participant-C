/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.participantC.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import it.noah.common.ObjectC;
import it.noah.sagacqrs.entity.EventAttributes;
import it.noah.sagacqrs.entity.interfaces.IEntity;
import it.noah.sagacqrs.entity.qualifiers.SagaAttribute;
import it.noah.sagacqrs.entity.qualifiers.SagaEntity;
import java.time.OffsetDateTime;

/**
 *
 * @author NATCRI
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SagaEntity(table = "participant_c.entity_c")
public class EntityC implements IEntity {

    private static final long serialVersionUID = -1277443260485021770L;

    public static final String FIND_ALL_BY_ENTITY_A = "SELECT * FROM participant_c.entity_c WHERE entity_a = $1";

    @SagaAttribute(name = "id")
    private Long id;
    @SagaAttribute(name = "entity_a")
    private Long entityA;
    @SagaAttribute(name = "title")
    private String title;
    @SagaAttribute(name = "enabled")
    private boolean enabled;
    @SagaAttribute(name = "weight")
    private Integer weight;
    @SagaAttribute(name = "createtime")
    private OffsetDateTime createtime;
    @SagaAttribute(name = "dbtime", insertable = false)
    private OffsetDateTime dbtime;

    private Long optlock;

    private EventAttributes event;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntityA() {
        return entityA;
    }

    public void setEntityA(Long entityA) {
        this.entityA = entityA;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public OffsetDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(OffsetDateTime createtime) {
        this.createtime = createtime;
    }

    public OffsetDateTime getDbtime() {
        return dbtime;
    }

    public void setDbtime(OffsetDateTime dbtime) {
        this.dbtime = dbtime;
    }

    @Override
    public Long getOptlock() {
        return optlock;
    }

    @Override
    public void setOptlock(Long optlock) {
        this.optlock = optlock;
    }

    @Override
    public EventAttributes getEvent() {
        return event;
    }

    @Override
    public void setEvent(EventAttributes event) {
        this.event = event;
    }

    @Override
    public EntityC clone() {
        EntityC e = new EntityC();
        e.setId(id);
        e.setEntityA(entityA);
        e.setTitle(title);
        e.setEnabled(enabled);
        e.setWeight(weight);
        e.setCreatetime(createtime);
        e.setDbtime(dbtime);
        return e;
    }

    public ObjectC toObjectC() {
        ObjectC o = new ObjectC();
        o.setId(id);
        o.setEntityA(entityA);
        o.setTitle(title);
        o.setEnabled(enabled);
        o.setWeight(weight);
        o.setCreatetime(createtime);
        o.setDbtime(dbtime);
        o.setOptlock(optlock);
        o.setState(getEventStateName());
        return o;
    }
}
