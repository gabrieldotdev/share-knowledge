package com.all.projpj07_fs.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name", nullable = false, length = 50)
    private String Name;

    @Column(name = "description", nullable = false, length = 255)
    private String Description;

    @Column(name = "file", nullable = false, length = 255)
    private String File;

    @Column(name = "fileType", nullable = false, length = 50)
    private String FileType;

    @Column(name = "countDownload", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer CountDownload;

    @Column(name = "publishedOn", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp PublishedOn;

    @Column(name = "updatedOn", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp UpdatedOn;

    @Column(name = "userId", nullable = false)
    private Integer UserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        PublishedOn = new Timestamp(System.currentTimeMillis());
        UpdatedOn = new Timestamp(System.currentTimeMillis());
        CountDownload = 0;
    }

    @PreUpdate
    protected void onUpdate() {
        UpdatedOn = new Timestamp(System.currentTimeMillis());
    }

//     Getter and Setter
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public Integer getCountDownload() {
        return CountDownload;
    }

    public void setCountDownload(Integer countDownload) {
        CountDownload = countDownload;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Document{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", File='" + File + '\'' +
                ", FileType='" + FileType + '\'' +
                ", CountDownload=" + CountDownload +
                ", PublishedOn=" + PublishedOn +
                ", UpdatedOn=" + UpdatedOn +
                ", UserId=" + UserId +
                ", user=" + user +
                '}';
    }
}
