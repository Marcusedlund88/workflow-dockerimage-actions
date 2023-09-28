package com.example.workflowdockerimageactions.DATA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TaskTest {

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
