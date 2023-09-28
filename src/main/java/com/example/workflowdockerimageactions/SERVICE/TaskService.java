package com.example.workflowdockerimageactions.SERVICE;

import com.example.workflowdockerimageactions.DATA.Task;
import com.example.workflowdockerimageactions.MODEL.TaskInstance;
import com.example.workflowdockerimageactions.REPO.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;
    private Task newTask;
    private TaskInstance taskInstance;

    public TaskInstance createNewTask(String task, double timeInHours){

        if(taskRepo.findTasksByName(task) != null){
            taskInstance = new TaskInstance(taskRepo.findTasksByName(task),timeInHours);
        }
        else{
            newTask = new Task();
            newTask.setName(task);
            taskRepo.save(newTask);
            taskInstance = new TaskInstance(newTask,timeInHours);
        }
        return taskInstance;
    }

}
