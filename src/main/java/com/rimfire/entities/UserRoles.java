package com.rimfire.entities;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity("user_roles")
public class UserRoles {
    @Id
    @MappedProperty("USER_ROLE_ID")  // Change this to match the actual primary key
    private Long userRoleId; 

    @MappedProperty("ROLE_ID")
    private Long roleId;

    @MappedProperty("USERID")
    private Long userId; // Foreign key from USERS table

    // Getters and Setters
    public UserRoles() {
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}