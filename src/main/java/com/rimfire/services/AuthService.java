package com.rimfire.services;

import io.micronaut.security.token.generator.TokenGenerator;
import jakarta.inject.Singleton;

import com.rimfire.repositories.UserRolesRepository;
import com.rimfire.repositories.UserSystemsRepository;
import com.rimfire.repositories.UsersRepository;
import com.rimfire.entities.Users;

import jakarta.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class AuthService {

    @Inject
    private UsersRepository usersRepository;

    @Inject
    private UserRolesRepository userRolesRepository;

    @Inject
    private UserSystemsRepository userSystemsRepository;

    @Inject
    private TokenGenerator tokenGenerator;

    public Users authenticateUser(String username, String firstName) {
        Optional<Users> optionalUser = usersRepository.findByUsernameAndFirstName(username, firstName);
        return optionalUser.orElse(null);  // Returns the user if present, otherwise returns null
    }

    public Optional<String> generateTokenForUser(String userIdString) {
        Long userId = Long.parseLong(userIdString);
        Optional<Users> userOptional = usersRepository.findById(userId);
        Optional<String> tokenOptional = Optional.empty();
    
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            Optional<Long> roleIdOptional = userRolesRepository.findRoleIdByUserId(user.getUserId());
            Long roleId = roleIdOptional.orElse(null); // or handle error
    
            Optional<Long> systemIdOptional = userSystemsRepository.findSystemIdByUserId(user.getUserId());
            Long systemId = systemIdOptional.orElse(null); // or handle error
    
            Map<String, Object> claims = new HashMap<>();
            claims.put("firstName", user.getFirstName());
            claims.put("lastName", user.getLastName());
            claims.put("phoneNumber", user.getPhoneNbr());
            claims.put("userId", user.getUserId());
            claims.put("username", user.getUsername());
            claims.put("roleId", roleId);
            claims.put("systemId", systemId);
            claims.put("timestamp", System.currentTimeMillis());
    
            tokenOptional = tokenGenerator.generateToken(claims);
        }
    
        return tokenOptional;
    }
    
    // handleLogout() and other methods...
}