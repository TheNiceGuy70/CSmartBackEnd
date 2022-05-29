package com.csmartbackend.service.raw;

import com.csmartbackend.dto.CompanyDto;
import com.csmartbackend.mapper.CompanyMapper;
import com.csmartbackend.model.Company;
import com.csmartbackend.model.Employee;
import com.csmartbackend.repository.CompanyRepository;
import com.exception.general.TargetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService
{
    private final CompanyRepository companyRepository;

    public List<Company> findAll()
    {
        List<Company> companyList = companyRepository.findAll();
        if(companyList.isEmpty())
            throw new TargetNotFoundException("The list of companies is empty.");

        return new ArrayList<>(companyList);
    }

    public Company save(Company company) { return companyRepository.save(company); }

    public void deleteAll() throws TargetNotFoundException { companyRepository.deleteAll(); }

    public void deleteSingle(Company company) throws TargetNotFoundException { companyRepository.delete(company); }

    public void deleteById(UUID id) throws TargetNotFoundException { companyRepository.deleteById(id); }
}
