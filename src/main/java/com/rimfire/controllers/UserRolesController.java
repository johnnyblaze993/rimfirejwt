package com.rimfire.controllers;

import java.util.List;

import com.rimfire.entities.UserRoles;
import com.rimfire.repositories.UserRolesRepository;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api")
public class UserRolesController {

  @Inject
  private UserRolesRepository userRolesRepository;

  @Get("/userRoles")
  public Iterable<UserRoles> getUserRoles() {
    return userRolesRepository.findAll();
  }

    @Get("/userRoles/byUserId/{userId}")
  public List<UserRoles> getUserRolesByUserId(Long userId) {
    return userRolesRepository.findByUserId(userId);
  }
}
