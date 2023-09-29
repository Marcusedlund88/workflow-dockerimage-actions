package com.example.workflowdockerimageactions.SYSTEMTEST;

import com.example.workflowdockerimageactions.COMPONENT.Component;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
class SystemTest {

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
    void addNewTask() {
    }
}