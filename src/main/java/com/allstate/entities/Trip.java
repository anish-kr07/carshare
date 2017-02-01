package com.allstate.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "trips")
public class Trip {
    private int id;
    private int version;
    private double duration;
    private Time startTime;
    private Time stopTime;
    private boolean isDay;
    private double distance;
    private double cost;
    private double tip;
    private double totalCost;
    private Date created;
    private  Date modified;
    private Passenger passenger;

    public Trip(){}

    public Trip(Time startTime, Time endTime, boolean isDay, double distance, double tip) {
        this.startTime = startTime;
        this.stopTime = endTime;
        this.duration =(this.stopTime.getHours()*60+this.stopTime.getMinutes()) - (this.startTime.getHours()*60+this.startTime.getMinutes());
        this.isDay = isDay;
        this.distance = distance;
        this.tip = tip;
        this.cost = 0d;
        this.totalCost = 0d;

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
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @NotNull
    @Column(name="start_time")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    @NotNull
    @Column(name="stop_time")
    public Time getStopTime() {
        return stopTime;
    }

    public void setStopTime(Time endTime) {
        this.stopTime = endTime;
    }

    @NotNull
    @Column(name="is_day")
    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    @NotNull
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @NotNull
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @NotNull
    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    @NotNull
    @Column(name="total_cost")
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
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

    @ManyToOne
    @JoinColumn(name="passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
