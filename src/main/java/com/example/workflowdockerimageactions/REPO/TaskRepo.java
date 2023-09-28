package com.example.workflowdockerimageactions.REPO;

import com.example.workflowdockerimageactions.DATA.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    Task findTasksByName(String task);
    Task findTasksById(long id);
}
