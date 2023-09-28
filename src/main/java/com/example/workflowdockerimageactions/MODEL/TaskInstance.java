package com.example.workflowdockerimageactions.MODEL;

import com.example.workflowdockerimageactions.DATA.Task;

public class TaskInstance {

    private Task task;
    private double timeInHours;

    public TaskInstance(Task task, double timeInHours){
        this.task = task;
        this.timeInHours = timeInHours;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public double getTimeInHours() {
        return timeInHours;
    }

    public void setTimeInHours(double timeInHours) {
        this.timeInHours = timeInHours;
    }
}
