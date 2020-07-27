package com.backend.demo.services;

import com.backend.demo.exceptions.CompanyNotFoundException;
import com.backend.demo.models.Company;
import com.backend.demo.repos.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    @Autowired

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company addCompany(Company company){
        /*Company companyFromDb = companyRepository.findById(company.getId()).get();

        if (companyFromDb != null){
            return companyFromDb;
        } else {*/
            Company newCompany = new Company();
            newCompany.setName(company.getName());
            newCompany.setLocation(company.getLocation());
            companyRepository.save(newCompany);
            return newCompany;
        //}
    }

    public Company loadCompanyById(Long id) throws CompanyNotFoundException {
        return companyRepository.findById(id).orElse(new Company());
    }
}
