package com.example.workflowdockerimageactions.CONTROLLER;

import com.example.workflowdockerimageactions.DATA.Task;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import com.example.workflowdockerimageactions.SERVICE.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
//@RequiredArgsConstructor
public class TaskController {

    //private final TaskRepo taskRepo;

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

    @PostMapping("/add")
    public void addNewTask(@RequestBody String newTask, double timeInHours){
        taskService.createNewTask(newTask, timeInHours);
    }

}