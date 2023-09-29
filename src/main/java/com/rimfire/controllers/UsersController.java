package com.rimfire.controllers;
import com.rimfire.entities.Users;
import com.rimfire.repositories.UsersRepository;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import jakarta.inject.Inject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api")
public class UsersController {

    @Inject
    private UsersRepository usersRepository;

    // @Inject
    // private UserRoleRepository userRoleRepository;

    // @Inject
    // private UserSystemRepository userSystemRepository;

    @Get("/users")
    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }
  
}
