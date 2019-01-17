package com.Lebook.MesferAlQahtani.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENTS")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long commentsid;

    @Column(name = "CommentsEntity")
    private String comments;

    @Column(name = "Comments_Time")
    private LocalDateTime commentstime;

    @Column(name = "Deleted")
    private boolean delete;

    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private EventEntity eventEntity;

    public CommentsEntity() {
    }


    public long getCommentsid() {
        return commentsid;
    }

    public void setCommentsid(long commentsid) {
        this.commentsid = commentsid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getCommentstime() {
        return commentstime;
    }

    public void setCommentstime(LocalDateTime commentstime) {
        this.commentstime = commentstime;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
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
}
