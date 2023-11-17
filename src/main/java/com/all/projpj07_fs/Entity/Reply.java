package com.all.projpj07_fs.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String Content;

    @Column(name = "publishedOn", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp PublishedOn;

    @Column(name = "updatedOn", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp UpdatedOn;

    @Column(name = "userId", nullable = false)
    private Integer UserId;

    @Column(name = "commentId", nullable = false)
    private Integer CommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentId", referencedColumnName = "id", insertable = false, updatable = false)
    private Comment comment;

    // PrePersist and PreUpdate
    @PrePersist
    protected void onCreate() {
        PublishedOn = new Timestamp(System.currentTimeMillis());
        UpdatedOn = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        UpdatedOn = new Timestamp(System.currentTimeMillis());
    }

    // Getters and setters

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Timestamp getPublishedOn() {
        return PublishedOn;
    }

    public void setPublishedOn(Timestamp publishedOn) {
        PublishedOn = publishedOn;
    }

    public Timestamp getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        UpdatedOn = updatedOn;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getCommentId() {
        return CommentId;
    }

    public void setCommentId(Integer commentId) {
        CommentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "Id=" + Id +
                ", Content='" + Content + '\'' +
                ", PublishedOn=" + PublishedOn +
                ", UpdatedOn=" + UpdatedOn +
                ", UserId=" + UserId +
                ", CommentId=" + CommentId +
                ", user=" + user +
                ", comment=" + comment +
                '}';
    }
}
