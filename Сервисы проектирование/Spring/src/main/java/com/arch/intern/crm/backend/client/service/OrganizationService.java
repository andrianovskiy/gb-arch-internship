package com.arch.intern.crm.backend.client.service;


import com.arch.intern.crm.backend.client.model.contractor.Organization;
import com.arch.intern.crm.backend.client.repository.OrganizationRepository;
import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.client.model.contractor.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class OrganizationService implements CrudService<Organization> {

    private final OrganizationRepository contractorRepository;

    @Autowired

    public OrganizationService(OrganizationRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public JpaRepository<Organization, Long> getRepository() {
        return contractorRepository;
    }
}
