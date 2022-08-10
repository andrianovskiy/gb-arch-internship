package com.arch.intern.crm.backend.requests.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.requests.model.Request;
import com.arch.intern.crm.backend.requests.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class RequestService implements CrudService<Request> {

    private final RequestRepo requestRepo;
    @Autowired
    public RequestService(RequestRepo requestRepo) {
        this.requestRepo =requestRepo;
    }

    @Override
    public JpaRepository<Request, Long> getRepository() {
        return requestRepo;
    }


}
