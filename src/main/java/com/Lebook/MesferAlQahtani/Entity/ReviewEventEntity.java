package com.Lebook.MesferAlQahtani.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = ("REVIEWEVENT"))
public class ReviewEventEntity {
    
    @Id
    @Column(name = "R_idd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewEventid;

    @Max(5)
    @Min(1)
    @Column(name = "Rating")
    @NotNull
    private int rate;

    @NotNull
    private String comments;

    @Column(name = "Deleted")
    private boolean delete;


    @ManyToOne
    private TicketEntity reviewTicket;

    public ReviewEventEntity() {
    }

    public long getReviewEventid() {
        return reviewEventid;
    }

    public void setReviewEventid(long reviewEventid) {
        this.reviewEventid = reviewEventid;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public TicketEntity getReviewTicket() {
        return reviewTicket;
    }

    public void setReviewTicket(TicketEntity reviewTicket) {
        this.reviewTicket = reviewTicket;
    }
}
