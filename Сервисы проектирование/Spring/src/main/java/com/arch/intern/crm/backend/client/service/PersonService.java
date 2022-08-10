package com.arch.intern.crm.backend.client.service;


import com.arch.intern.crm.backend.client.model.contractor.Person;
import com.arch.intern.crm.backend.client.repository.OrganizationRepository;
import com.arch.intern.crm.backend.client.repository.PersonRepository;
import com.arch.intern.crm.backend.common.interfeses.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class PersonService implements CrudService<Person> {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }
}
