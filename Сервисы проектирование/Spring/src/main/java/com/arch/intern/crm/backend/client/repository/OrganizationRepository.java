package com.arch.intern.crm.backend.client.repository;


/**
 * @author Marchenko_DS in 25/04/2022
 */
import com.arch.intern.crm.backend.client.model.contractor.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
