package com.example.workflowdockerimageactions.CONTROLLER;


import com.example.workflowdockerimageactions.COMPONENT.Component;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskControllerTest {

    @Autowired
    private Component component;

    private static final Logger logger = LoggerFactory.getLogger(TaskControllerTest.class);

    @Test
    void getAllTasks(){

        String username = System.getenv("SS_USER");
        String password = System.getenv("SS_PASSWORD");

        assertEquals(username, "user");


        RestAssured.baseURI = "http://localhost:8080";

        given()
                .auth()
                .basic(username,password)
                .when()
                .get("/all")
                .then()
                .statusCode(200)
                .body("$", hasSize(2))
                .body("[0].name", equalTo("task 1"))
                .body("[1].name", equalTo("task 2"));

    }

    @Test
    void deleteTask() {

        String username = System.getenv("SS_USER");
        String password = System.getenv("SS_PASSWORD");

        RestAssured.baseURI = "http://localhost:8080";

        given()
                .auth()
                .basic(username,password)
                .when()
                .delete("1")
                .then()
                .statusCode(401);


    }

    @Test
    void addNewTask() {
    }
}