package com.stackroute.downstreamservice.controller;


import com.stackroute.downstreamservice.domain.Employee;

import com.stackroute.downstreamservice.exceptions.EmployeeNotFoundException;
import com.stackroute.downstreamservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${controller.base}")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping("${controller.employee}")
    public ResponseEntity<?> getEmployees(@PathVariable("id") String employeeId){
        ResponseEntity responseEntity;
        try{
           responseEntity=new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);

        }catch(EmployeeNotFoundException exception){
              responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);

        }
        return responseEntity;
    }

    @GetMapping("${controller.employees}")
    public ResponseEntity<?> getAllEmployees(){
        ResponseEntity responseEntity;
        try{
            responseEntity=new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
        }catch(EmployeeNotFoundException exception){
             responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
