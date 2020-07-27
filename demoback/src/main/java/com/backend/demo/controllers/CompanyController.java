package com.backend.demo.controllers;

import com.backend.demo.models.Company;
import com.backend.demo.repos.CompanyRepository;
import com.backend.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private CompanyRepository companyRepository;
    private CompanyService companyService;

    @Autowired

    public CompanyController(CompanyRepository companyRepository, CompanyService companyService) {
        this.companyRepository = companyRepository;
        this.companyService = companyService;
    }

    @PostMapping(value = "/company/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> addNewCompany(@RequestBody Company company){
        /*Company companyDetails = companyService.loadCompanyById(company.getId());

        if (companyDetails != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {*/
            companyService.addCompany(company);
            return ResponseEntity.ok(company);
        //}
    }

    @DeleteMapping(value = "/company/delete/{id}")
    public Company deleteDeviceById(@PathVariable Long id) {
        companyRepository.deleteById(id);
        return null;
    }

    @GetMapping(value = "/company")
    public List<Company> findAllDevices(){
        return (List<Company>) companyRepository.findAll();
    }

    @GetMapping(value = "/company/{id}")
    public Company findDeviceById(@PathVariable Long id) {
        return companyRepository.findById(id).get();
    }
}
