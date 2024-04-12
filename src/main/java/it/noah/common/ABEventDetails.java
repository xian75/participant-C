/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NATCRI
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ABEventDetails implements Serializable {

    private static final long serialVersionUID = -4401149110949891520L;

    private List<ABCouple> items;

    public List<ABCouple> getItems() {
        return items;
    }

    public void setItems(List<ABCouple> items) {
        this.items = items;
    }

}
