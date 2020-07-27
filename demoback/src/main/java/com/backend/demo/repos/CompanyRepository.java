package com.backend.demo.repos;

import com.backend.demo.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
