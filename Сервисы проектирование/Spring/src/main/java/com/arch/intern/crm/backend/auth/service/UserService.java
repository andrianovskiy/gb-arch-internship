package com.arch.intern.crm.backend.auth.service;

import com.arch.intern.crm.backend.auth.repository.UserRepo;
import com.arch.intern.crm.backend.auth.model.User;
import com.arch.intern.crm.backend.common.interfeses.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class UserService implements CrudService<User> {

    private final UserRepo userRepo;
    private final MailSender mailSender;

    @Autowired
    public UserService(UserRepo userRepo, MailSender mailSender) {
        this.userRepo = userRepo;
        this.mailSender = mailSender;
    }


    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepo;
    }


}
