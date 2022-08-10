package com.arch.intern.crm.backend.task.service;

import com.arch.intern.crm.backend.task.model.Task;
import com.arch.intern.crm.backend.task.repository.TaskRepo;
import com.arch.intern.crm.backend.common.interfeses.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class TaskService implements CrudService<Task> {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }


    @Override
    public JpaRepository<Task, Long> getRepository() {
        return taskRepo;
    }


}
