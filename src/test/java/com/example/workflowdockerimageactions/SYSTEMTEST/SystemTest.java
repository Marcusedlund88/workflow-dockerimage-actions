package com.example.workflowdockerimageactions.SYSTEMTEST;


import com.example.workflowdockerimageactions.COMPONENT.Component;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import io.restassured.RestAssured;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SystemTest {

    @Autowired
    private Component component;

    @Autowired
    private TaskRepo taskRepo;

    private static final Logger logger = LoggerFactory.getLogger(SystemTest.class);

    @Test
    void getAllTasks(){

        String username = System.getenv("SS_USER");
        String password = System.getenv("SS_PASSWORD");

        RestAssured.baseURI = "http://localhost:8080";

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

        RestAssured.baseURI = "http://localhost:8080";

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

        RestAssured.baseURI = "http://localhost:8080";

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