package com.Lebook.MesferAlQahtani.Entity;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TICKETS")

public class TicketEntity {
    @Id
    @Column(name = "T_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketID;

    @Column(name = "Cancel")
    //@ColumnDefault("0")
    private boolean cancelTicket;


    private LocalDate tDate;
    @Column(name = "Attended")
    private boolean attended;

    private LocalTime tTime;



    //    @ManyToOne
//    @JoinColumn(name = "Ticket_Attender_Id", referencedColumnName = "user_number")
//    private UserEntity attenderId;
//
//    @ManyToOne
//    @JoinColumn(name = "Ticket_Event_Id", referencedColumnName = "E_id")
//    private EventEntity eventEntityId;
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn
    private EventEntity eventEntity;

    private String eventName;

    private int rate;

    private String comment;

    private boolean rated;


    public TicketEntity() {
    }

    public long getTicketID() {
        return ticketID;
    }

    public void setTicketID(long ticketID) {
        this.ticketID = ticketID;
    }

    public boolean isCancelTicket() {
        return cancelTicket;
    }

    public void setCancelTicket(boolean cancelTicket) {
        this.cancelTicket = cancelTicket;
    }

    public LocalDate gettDate() {
        return tDate;
    }

    public void settDate(LocalDate tDate) {
        this.tDate = tDate;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public LocalTime gettTime() {
        return tTime;
    }

    public void settTime(LocalTime tTime) {
        this.tTime = tTime;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }
}