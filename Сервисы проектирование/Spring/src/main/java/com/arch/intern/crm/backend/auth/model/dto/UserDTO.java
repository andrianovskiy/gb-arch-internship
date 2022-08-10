package com.arch.intern.crm.backend.auth.model.dto;

import com.arch.intern.crm.backend.auth.model.Role;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class UserDTO extends AbstractDTO{

    private String userName;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private boolean active;

    private String password;

    private String activationCode;

    private Set<Role> roles;

}
