package com.all.projpj07_fs.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Comments")
public class Comment {
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

    @Column(name = "documentId", nullable = false)
    private Integer DocumentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentId", referencedColumnName = "id", insertable = false, updatable = false)
    private Document document;

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

    public Integer getDocumentId() {
        return DocumentId;
    }

    public void setDocumentId(Integer documentId) {
        DocumentId = documentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", Content='" + Content + '\'' +
                ", PublishedOn=" + PublishedOn +
                ", UpdatedOn=" + UpdatedOn +
                ", UserId=" + UserId +
                ", DocumentId=" + DocumentId +
                ", user=" + user +
                ", document=" + document +
                '}';
    }
}
