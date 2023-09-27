package com.example.workflowdockerimageactions.CONTROLLER;

import com.example.workflowdockerimageactions.REPO.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepo taskRepo;

}
