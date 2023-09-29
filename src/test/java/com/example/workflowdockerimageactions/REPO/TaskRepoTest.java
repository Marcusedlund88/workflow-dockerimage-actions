package com.example.workflowdockerimageactions.REPO;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskRepoTest {

    @BeforeAll
    public static void setVars(){
        System.setProperty("SS_USER","dummyUser");
        System.setProperty("SS_PASSWORD","dummyUser");
    }

}