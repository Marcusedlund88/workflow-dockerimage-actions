package com.example.workflowdockerimageactions.XINTEGRATIONTEST;

import com.example.workflowdockerimageactions.COMPONENT.Component;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Test
    public void testGetAllEndpointExpectOK() throws Exception {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        mockMvc.perform(get("/tasks/all"))
                .andExpect(status().isOk());

    }
    @Test
    public void testDeleteByIdEndpointExpectOK() throws Exception {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        mockMvc.perform(delete("/tasks/1"))
                .andExpect(status().isOk());

    }

    @Test
    public void testPostAddEndpointExpectOK() throws Exception {

        JSONObject json = new JSONObject();
        json.put("name", "work");
        json.put("time", "2");


        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        mockMvc.perform(post("/tasks/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.toString()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Post Successful"));

    }

}
