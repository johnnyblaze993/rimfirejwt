package com.rimfire.controllers;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@MicronautTest
public class UsersControllerTest {

    @Test
    public void testGetUsersEndpoint() {
        // Setup Rest Assured
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 5555;

        // Test /users endpoint
        given()
            .when()
                .get("/api/users")
            .then()
                .statusCode(200);
    }

    @Test
    public void testFindByUserId() {
        // Setup Rest Assured
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 5555;

        // Test /users/{userId} endpoint
        given()
            .pathParam("userId", 1199)
            .when()
                .get("/api/users/{userId}")
            .then()
                .statusCode(200)
                .body("userId", equalTo(1199))
                .body("firstName", equalTo("02"))
                .body("lastName", equalTo("TRAINING"))
                .body("phoneNbr", equalTo("2565551212"))
                .body("username", equalTo("TRAINING02"));
    }
}
