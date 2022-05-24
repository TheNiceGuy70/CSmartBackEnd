package com.csmartbackend.controller;

import com.csmartbackend.service.raw.EmployeeService;
import com.csmartbackend.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController
{
    private final EmployeeService employeeService;

    @GetMapping("find/all")
    public ResponseEntity<List<Employee>> findAll()
    {
        List<Employee> listEmployeeDto = employeeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listEmployeeDto);
    }

    @GetMapping("findbyid/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable("employeeId") UUID employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("findbycnp/{cnp}")
    public ResponseEntity<Employee> findByCNP(@PathVariable("cnp") String Cnp)
    {
        Employee employee = employeeService.findByCnp(Cnp);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@RequestBody @Valid Employee employee)
    {
        Employee returnedEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.OK).body(returnedEmployee);
    }

    @PutMapping("update/{employeeId}")
    public ResponseEntity<Employee> update(@PathVariable("employeeId") UUID employeeId, @RequestBody @Valid Employee employee)
    {
        Employee returnedEmployee = employeeService.update(employeeId, employee);
        return ResponseEntity.status(HttpStatus.OK).body(returnedEmployee);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() { employeeService.deleteAll(); }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) { employeeService.deleteById(id); }

    @DeleteMapping("delete/single")
    public void deleteSingle(@RequestBody @Valid Employee employee) { employeeService.deleteSingle(employee); }
}
