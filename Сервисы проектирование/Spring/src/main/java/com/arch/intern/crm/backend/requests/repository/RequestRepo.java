package com.arch.intern.crm.backend.requests.repository;

import com.arch.intern.crm.backend.requests.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
public interface RequestRepo extends JpaRepository<Request, Long> {

}
