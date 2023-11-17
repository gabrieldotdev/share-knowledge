package com.all.projpj07_fs.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "firstName", nullable = false, length = 45)
    private String FirstName;
    @Column(name = "lastName", nullable = false, length = 45)
    private String LastName;
    @Column(name = "username", nullable = false, length = 45, unique = true)
    private String Username;
    @Column(name = "password", nullable = false, length = 45)
    private String Password;
    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String Email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId", referencedColumnName = "id", insertable = false, updatable = false, columnDefinition = "INT DEFAULT 2")

    private Role role;
    @Column(name = "dateJoin", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp DateJoin;

    @PrePersist
    protected void onCreate() {
        DateJoin = new Timestamp(System.currentTimeMillis());
    }

    // Getters and setters
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getDateJoin() {
        return DateJoin;
    }

    public void setDateJoin(Timestamp dateJoin) {
        DateJoin = dateJoin;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", role=" + role +
                ", DateJoin=" + DateJoin +
                '}';
    }

    public User orElse(Object o) {
        return null;
    }
}
