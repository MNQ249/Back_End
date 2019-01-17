package com.Lebook.MesferAlQahtani.Entity;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "EventM")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "E_id")
    private long eventId;

    @NotNull(message = " event name is required ")
    @Column(name = "E_name")
    private String eventName;

    @Column(name = "E_Time")
    private Time eventTime;

    @NotNull(message = " event city name is required ")
    @Column(name = "E_City")
    private String eventCity;

    @NotNull(message = " event date name is required ")
    @Column(name = "E_Date")
    private LocalDate eventDate;

    @Max(value = 300, message = "max capacity must be 300 ")
    @Column(name = "E_max_capacity")
    private int eventMaxCapacity;


    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "Approve")
    private boolean approved;

   @Column(name = "count")
    private int counter;


    @ManyToOne
    @JoinColumn(name ="orginzer" )
//    @JsonIgnore
    private UserEntity orginzer;




    public EventEntity() {
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventMaxCapacity() {
        return eventMaxCapacity;
    }

    public void setEventMaxCapacity(int eventMaxCapacity) {
        this.eventMaxCapacity = eventMaxCapacity;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public UserEntity getOrginzer() {
        return orginzer;
    }

    public void setOrginzer(UserEntity orginzer) {
        this.orginzer = orginzer;
    }
}