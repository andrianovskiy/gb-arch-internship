package com.arch.intern.crm.backend.client.model.contractor;

import com.arch.intern.crm.backend.client.model.Passport;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("PERSON")
public class Person extends Contractor {

    private String firstName;

    private String lastName;

    private String middleName;

    @OneToMany
    private List<Passport> passport;

}
