package com.arch.intern.crm.backend.task.repository;

import com.arch.intern.crm.backend.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
public interface TaskRepo extends JpaRepository<Task, Long> {

}
