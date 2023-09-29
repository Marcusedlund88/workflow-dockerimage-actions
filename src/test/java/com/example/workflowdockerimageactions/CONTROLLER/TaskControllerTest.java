package com.example.workflowdockerimageactions.CONTROLLER;


import io.restassured.RestAssured;
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

    @Test
    void getAllTasks(){
        int i = 2;
        assertEquals(i,1);
    }

    @Test
    void deleteTask() {
    }

    @Test
    void addNewTask() {
    }
}