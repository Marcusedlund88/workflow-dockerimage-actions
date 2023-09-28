package com.example.workflowdockerimageactions.SERVICE;

import com.example.workflowdockerimageactions.DATA.Task;
import com.example.workflowdockerimageactions.MODEL.TaskInstance;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TaskServiceTest {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private TaskService taskService;

    private TaskInstance taskInstance;
    private Task task;

    @BeforeEach
    public void makeTaskBefore(){
        task = new Task();
        task.setName("Clean");
        taskRepo.save(task);
    }


    @Test
    void createNewTaskIfTaskExistsExpectTrue() {

        taskInstance = taskService.createNewTask("Clean", 2);
        assertEquals("Clean", taskInstance.getTask().getName());
        assertEquals(2, taskInstance.getTimeInHours());
        assertEquals(1, taskInstance.getTask().getId());
    }
    @Test
    void createNewTaskIfTaskNotExistsExpectTrue() {

        taskInstance = taskService.createNewTask("Wash", 1);
        assertEquals("Wash", taskInstance.getTask().getName());
        assertEquals(1, taskInstance.getTimeInHours());
        assertEquals(2, taskInstance.getTask().getId());
    }
}