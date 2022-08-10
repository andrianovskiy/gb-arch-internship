package com.arch.intern.crm.backend.auth.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import javax.persistence.*;
import java.util.Set;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode
public class User extends AbstractEntity /*implements UserDetails*/ {

    private String userName;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private boolean active;

    private String password;

    private String activationCode;


    @OneToMany
    private Set<Role> roles;

//    @OneToMany
//    private Set<Notification> notifications;

    public boolean isAdmin() {
        return true;
    }

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
*/

}
