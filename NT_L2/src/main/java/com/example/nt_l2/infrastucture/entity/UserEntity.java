package com.example.nt_l2.infrastucture.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users", schema="library")
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private long id;

    @Basic
    @Column(name="username", unique = true)
    private String username;

    @Basic
    @Column(name="password", unique = true)
    private String password;

    @Basic
    @Column(name="role", unique = true)
    private String role;

    @Basic
    @Column(name="email", unique = true)
    private String email;

    @Basic
    @Column(name="Name", unique = true)
    private String Name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
