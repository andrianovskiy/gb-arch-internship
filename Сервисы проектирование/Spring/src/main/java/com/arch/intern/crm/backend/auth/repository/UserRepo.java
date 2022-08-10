package com.arch.intern.crm.backend.auth.repository;

import com.arch.intern.crm.backend.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String username);
    User findByActivationCode(String code);
}
