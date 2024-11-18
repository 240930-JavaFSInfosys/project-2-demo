package com.revature.models.DTOs;

import java.util.UUID;

//Here's another common DTO use case - send users to the front end without password
//Probably only use this DTO in get all users for the sake of time
public class OutgoingUserDTO {

    private UUID userId;
    private String username;
    private String role;

    //boilerplate-----------------


    public OutgoingUserDTO() {
    }

    public OutgoingUserDTO(UUID userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "OutgoingUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
