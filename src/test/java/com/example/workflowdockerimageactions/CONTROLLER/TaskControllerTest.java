package com.example.workflowdockerimageactions.CONTROLLER;


import com.example.workflowdockerimageactions.COMPONENT.Component;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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


  /*  @BeforeAll
    public static void setVars(){
        System.setProperty("SS_USER","user");
        System.setProperty("SS_PASSWORD","password");
    }*/

    @Autowired
    private Component component;

    @Test
    void getAllTasks(){

        RestAssured.baseURI = "http://localhost:8080";
        System.out.println(component.getPassword());
        given()
                .auth()
                .basic(component.getUsername(),component.getPassword())
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
    }

    @Test
    void addNewTask() {
    }
}