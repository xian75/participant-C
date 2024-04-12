/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NATCRI
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleABCEventDetails implements Serializable {

    private static final long serialVersionUID = -2819876397179674187L;

    private Long entityAId;
    private ObjectA a;
    private List<ObjectB> bItems;
    private List<ObjectC> cItems;

    public SingleABCEventDetails() {
        bItems = new ArrayList<>();
        cItems = new ArrayList<>();
    }

    public SingleABCEventDetails(Long entityAId) {
        this();
        this.entityAId = entityAId;
    }

    public Long getEntityAId() {
        return entityAId;
    }

    public void setEntityAId(Long entityAId) {
        this.entityAId = entityAId;
    }

    public ObjectA getA() {
        return a;
    }

    public void setA(ObjectA a) {
        this.a = a;
    }

    public List<ObjectB> getBItems() {
        return bItems;
    }

    public void setBItems(List<ObjectB> bItems) {
        this.bItems = bItems;
    }

    public List<ObjectC> getCItems() {
        return cItems;
    }

    public void setCItems(List<ObjectC> cItems) {
        this.cItems = cItems;
    }

}
