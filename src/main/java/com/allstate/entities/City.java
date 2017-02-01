package com.allstate.entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cities")

public class City {
    private int id;
    private int version;
    private String name;
    private String state;
    private int dayrate;
    private int nightrate;
    private Date created;
    private  Date modified;

    public City(){}

    public City(String name, String state, int dayrate, int nightrate) {
        this.name = name;
        this.state = state;
        this.dayrate = dayrate;
        this.nightrate = nightrate;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @NotNull
    public int getDayrate() {
        return dayrate;
    }

    public void setDayrate(int dayrate) {
        this.dayrate = dayrate;
    }
    @NotNull
    public int getNightrate() {
        return nightrate;
    }

    public void setNightrate(int nightrate) {
        this.nightrate = nightrate;
    }
    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
