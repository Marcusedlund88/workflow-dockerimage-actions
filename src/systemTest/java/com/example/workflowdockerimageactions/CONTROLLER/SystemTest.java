package com.example.workflowdockerimageactions.CONTROLLER;

import io.restassured.RestAssured;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;


@SpringBootTest()
@ContextConfiguration(classes = SystemTest.class)
class SystemTest {

    @Test
    void getAllTasks(){

        String username = System.getenv("SS_USER");
        String password = System.getenv("SS_PASSWORD");

        RestAssured.baseURI = "http://localhost:8080/tasks";

        given()
                .auth()
                .basic(username,password)
                .when()
                .get("/all")
                .then()
                .statusCode(200);
    }

    @Test
    void deleteTask() {

        String username = System.getenv("SS_USER");
        String password = System.getenv("SS_PASSWORD");

        RestAssured.baseURI = "http://localhost:8080/tasks";

        given()
                .auth()
                .basic(username,password)
                .when()
                .delete("1")
                .then()
                .statusCode(200);

    }

    @Test
    void addNewTask() throws JSONException {

        String username = System.getenv("SS_USER");
        String password = System.getenv("SS_PASSWORD");

        RestAssured.baseURI = "http://localhost:8080/tasks";

        JSONObject json = new JSONObject();
        json.put("name","wash");
        json.put("time","1");

        given()
                .auth()
                .basic(username, password)
                .contentType("application/json")
                .when()
                .body(json.toString())
                .post("/add")
                .then()
                .statusCode(200);
    }
}