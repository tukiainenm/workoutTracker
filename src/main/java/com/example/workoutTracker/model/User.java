package com.example.workoutTracker.model;


import javax.persistence.*;

@Entity
@Table(name="usertable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false, updatable = false)
    private Long userId;

    @Column(name = "userName", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    private String role;

    public User() {
    }

    public User(String userName) {
        super();
        this.userName = userName;
    }

    public User(String userName, String passwordHash, String role) {
        super();
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
