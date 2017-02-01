package com.allstate.entities;

import com.allstate.enums.Type;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car {
    private int id;
    private int version;
    private String make;
    private String model;
    private int year;
    private String carno;
    private Type type;
    private int luxCharge;
    private Date created;
    private  Date modified;

    public  Car() {}
    public Car(String make, String model, int year, String carno, Type type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.carno = carno;
        this.type = type;
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
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @NotNull
    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('BASIC','LUX')")
    @NotNull
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @NotNull
    @Column(name = "lux_charge")
    public int getLuxCharge() {
        return luxCharge;
    }

    public void setLuxCharge(int luxCharge) {
        this.luxCharge = luxCharge;
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
