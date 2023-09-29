package com.rimfire.controllers;

import com.rimfire.entities.UserSystems;
import com.rimfire.repositories.UserSystemsRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api")
public class UserSystemsController {

    @Inject
    private UserSystemsRepository userSystemsRepository;

    @Get("/userSystems")
    public Iterable<UserSystems> getUserSystems() {
        return userSystemsRepository.findAll();
    }
}