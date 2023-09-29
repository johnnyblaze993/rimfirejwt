package com.rimfire.controllers;

import com.rimfire.dto.LoginWithUsernameAndFirstname;
import com.rimfire.entities.Users;
import com.rimfire.services.AuthService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/auth")
public class AuthController {
 private static final Logger LOG = LoggerFactory.getLogger(AuthService.class);
    @Inject
    private AuthService authService;

    @Post("/login")
    public HttpResponse<?> login(@Body LoginWithUsernameAndFirstname request) {
        
        Users user = authService.authenticateUser(
                request.getUsername(),
                request.getFirstName()
        );

        if (user != null) {
            Optional<String> tokenOptional = authService.generateTokenForUser(
                    String.valueOf(user.getUserId())
            );
            if (tokenOptional.isPresent()) {
                LOG.info("Generated token: {}", tokenOptional.get());
                return HttpResponse
                        .ok()
                        .header("Authorization", "Bearer " + tokenOptional.get())
                        .body("Login successful");
            } else {
                return HttpResponse.serverError();
            }
        } else {
            return HttpResponse.notFound().body("User not found");
        }
    }
}