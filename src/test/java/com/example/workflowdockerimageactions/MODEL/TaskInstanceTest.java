package com.example.workflowdockerimageactions.MODEL;

import com.example.workflowdockerimageactions.DATA.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskInstanceTest {

    @BeforeAll
    public static void setVars(){
        System.setProperty("SS_USER","dummyUser");
        System.setProperty("SS_PASSWORD","dummyUser");
    }

    private TaskInstance taskInstance;
    private Task task;

    @BeforeEach
    public void makeTaskInstance(){
        task = new Task(1, "clean");
        taskInstance = new TaskInstance(task, 2);
    }

    @Test
    void getTask() {
        Task testTask = taskInstance.getTask();
        assertEquals(task, testTask);
    }

    @Test
    void setTask() {
        Task testTask = new Task(1,"wash");
        taskInstance.setTask(testTask);

        assertNotEquals(taskInstance.getTask(), task);
    }

    @Test
    void getTimeInHours() {
        assertEquals(taskInstance.getTimeInHours(), 2);
    }

    @Test
    void setTimeInHours() {
        taskInstance.setTimeInHours(3);
        assertNotEquals(taskInstance.getTimeInHours(),2);
    }
}