package com.Lebook.MesferAlQahtani.DTO.EntityDTO;

import com.Lebook.MesferAlQahtani.Entity.UserEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;

public class EventDTO {

    private long eventId;


    @NotNull(message = " event name is required ")
    private String eventName;

    private Time eventTime;

    @NotNull(message = " event city name is required  ")
    private String eventCity;

    @NotNull(message = " event date name is required ")
    private LocalDate eventDate;

    @Max(value = 300, message = "max capacity must be 300 ")
    private int eventMaxCapacity;
    private boolean approved;

    private UserDTO orginzer;
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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

    public UserDTO getOrginzer() {
        return orginzer;
    }

    public void setOrginzer(UserDTO orginzer) {
        this.orginzer = orginzer;
    }
}
