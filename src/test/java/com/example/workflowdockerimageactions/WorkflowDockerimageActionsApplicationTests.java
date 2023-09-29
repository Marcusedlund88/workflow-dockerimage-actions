package com.example.workflowdockerimageactions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class WorkflowDockerimageActionsApplicationTests {

    @BeforeAll
    public static void setVars(){
        System.setProperty("SS_USER","dummyUser");
        System.setProperty("SS_PASSWORD","dummyUser");
    }

    @Test
    void contextLoads() {
    }

}
//src/test/java/com/example/workflowdockerimageactions