package com.arch.intern.crm.backend.client.repository;


/**
 * @author Marchenko_DS in 25/04/2022
 */
import com.arch.intern.crm.backend.client.model.contractor.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
