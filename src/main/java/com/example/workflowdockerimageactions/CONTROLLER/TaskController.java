package com.example.workflowdockerimageactions.CONTROLLER;

import com.example.workflowdockerimageactions.BODY.Request;
import com.example.workflowdockerimageactions.DATA.Task;
import com.example.workflowdockerimageactions.MODEL.TaskInstance;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import com.example.workflowdockerimageactions.SERVICE.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
//@RequiredArgsConstructor
public class TaskController {

    //private final TaskRepo taskRepo;

    private final TaskService taskService;
    private Request request;

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
    public String addNewTask(@RequestBody Request request){

        try{
            double time = request.getTime();
            String task = request.getName();;
            taskService.createNewTask(task, time);
            return "Post Successful";
        }
        catch (Exception e){
            return "Post failed, wrong format";
        }
    }

}