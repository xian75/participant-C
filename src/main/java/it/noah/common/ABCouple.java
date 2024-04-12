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
public class ABCouple implements Serializable {

    private static final long serialVersionUID = -5752934111019931526L;

    private ObjectA a;
    private List<ObjectB> bItems;

    public ABCouple() {
        bItems = new ArrayList<>();
    }

    public ABCouple(ObjectA a) {
        this.a = a;
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

}
