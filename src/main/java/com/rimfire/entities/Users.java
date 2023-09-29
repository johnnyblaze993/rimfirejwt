package com.rimfire.entities;


import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("users")
public class Users {
    @Id
    @NonNull
    @MappedProperty("USERID")
    private Long userId;
    @MappedProperty("FIRST_NAME")
    private String firstName;
    
    @MappedProperty("LAST_NAME")
    private String lastName;
    
    @MappedProperty("PHONE_NBR")
    private String phoneNbr;
    
    @MappedProperty("USERNAME")
    private String username;
    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public Users() {
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}