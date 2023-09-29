package com.rimfire.entities;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("user_systems")
public class UserSystems {
    @Id
    @MappedProperty("ID")
    private Long id;

    @MappedProperty("SYSTEM_ID")
    private Long systemId;

    @MappedProperty("USER_ID")
    private Long userId;  // Foreign key from USERS table

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserSystems() {
    }
    
    // Getters and Setters
    // ...
}