package com.example.workflowdockerimageactions.DATA;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class TaskTest {

    @BeforeAll
    public static void setVars(){
        System.setProperty("SS_USER","dummyUser");
        System.setProperty("SS_PASSWORD","dummyUser");
    }

    private Task testTask;

    @BeforeEach
    public void createTestTask() {
        testTask = new Task("Task 1");
    }


    @Test
    void getName_returnName(){
        String expectedName = "Task 1";
        String actualName = testTask.getName();
        assertEquals(expectedName, actualName);
    }


    @Test
    void setName_returnSetName(){
        String newName = "Task 2";
        testTask.setName(newName);
        String actualName = testTask.getName();
        assertEquals(newName, actualName);
    }

}
