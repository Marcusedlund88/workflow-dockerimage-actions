package com.example.workflowdockerimageactions.COMPONENT;

import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Component
public class Component {

    @Value("${SS_USER}")
    private String username;

    @Value("${SS_PASSWORD}")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
