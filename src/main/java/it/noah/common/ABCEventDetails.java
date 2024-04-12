/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.noah.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
 *
 * @author NATCRI
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ABCEventDetails implements Serializable {

    private static final long serialVersionUID = 509342425667904510L;

    private Long entityAId;
    private Long optlock;
    private String titlePrefix;

    public ABCEventDetails() {
    }

    public ABCEventDetails(Long entityAId, Long optlock) {
        this.entityAId = entityAId;
        this.optlock = optlock;
    }

    public ABCEventDetails(Long entityAId, Long optlock, String titlePrefix) {
        this.entityAId = entityAId;
        this.optlock = optlock;
        this.titlePrefix = titlePrefix;
    }

    public Long getEntityAId() {
        return entityAId;
    }

    public void setEntityAId(Long entityAId) {
        this.entityAId = entityAId;
    }

    public Long getOptlock() {
        return optlock;
    }

    public void setOptlock(Long optlock) {
        this.optlock = optlock;
    }

    public String getTitlePrefix() {
        return titlePrefix;
    }

    public void setTitlePrefix(String titlePrefix) {
        this.titlePrefix = titlePrefix;
    }

}
