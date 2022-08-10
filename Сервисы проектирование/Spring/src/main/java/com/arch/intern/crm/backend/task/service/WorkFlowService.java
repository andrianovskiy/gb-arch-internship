package com.arch.intern.crm.backend.task.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.task.model.WorkFlow;
import com.arch.intern.crm.backend.task.repository.WorkFlowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class WorkFlowService implements CrudService<WorkFlow> {

    private final WorkFlowRepo workFlow;

    @Autowired
    public WorkFlowService( WorkFlowRepo  workFlow) {
        this.workFlow = workFlow;
    }


    @Override
    public JpaRepository<WorkFlow, Long> getRepository() {
        return workFlow;
    }


}
