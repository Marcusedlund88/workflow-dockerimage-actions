package com.example.workflowdockerimageactions.CONFIG;

import com.example.workflowdockerimageactions.DATA.Task;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(TaskRepo taskRepo){
        return args -> {

            Task task1 = new Task("task 1");

            Task task2 = new Task("task 2");

            taskRepo.saveAll(List.of(task1,task2));

        };
    }
}
