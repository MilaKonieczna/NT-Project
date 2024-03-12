package com.example.nt_l2.controller.dto.user;

public class CreateUserResponseDto {

    private long id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String Name;

    public CreateUserResponseDto(long id, String username, String password, String role, String email, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        Name = name;
    }

    public CreateUserResponseDto() {
    }

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
