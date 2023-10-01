package com.example.workflowdockerimageactions.SERVICE;

import com.example.workflowdockerimageactions.DATA.Task;
import com.example.workflowdockerimageactions.MODEL.TaskInstance;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

    @BeforeAll
    public static void setVars(){
        System.setProperty("SS_USER","dummyUser");
        System.setProperty("SS_PASSWORD","dummyUser");
    }

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private TaskService taskService;

    private TaskInstance taskInstance;
    private Task task;

    @Test
    void createNewTaskIfTaskExistsExpectTrue() {

        task = new Task();
        task.setName("Clean");
        taskRepo.save(task);

        taskInstance = taskService.createNewTask("Clean", 2);
        assertEquals("Clean", taskInstance.getTask().getName());
        assertEquals(2, taskInstance.getTimeInHours());
    }
    @Test
    void createNewTaskIfTaskNotExistsExpectTrue() {

        taskInstance = taskService.createNewTask("Wash", 1);
        assertEquals("Wash", taskInstance.getTask().getName());
        assertEquals(1, taskInstance.getTimeInHours());
    }

    @Test
    void getAllTasksExpectNotNull() {
        taskInstance = taskService.createNewTask("Walk the dog", 0.5);
        List<Task> tasks = taskRepo.findAll();
        assertNotNull(tasks);

    }

    @Test
    void deleteTaskExpectNull() {
        taskInstance = taskService.createNewTask("Groceries", 1);
        long id = taskRepo.findTasksByName("Groceries").getId();
        taskService.deleteTask(id);

        assertNull(taskRepo.findTasksById(id));


    }
}