package com.stackroute.DownstreamService.controller;


import com.stackroute.DownstreamService.domain.Employee;

import com.stackroute.DownstreamService.exceptions.EmployeeNotFoundException;
import com.stackroute.DownstreamService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchmaker/v1")
/*@PropertySource("classpath:/application.properties")*/
public class EmployeeController {

    private Environment environment;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,Environment environment) {
        this.employeeService = employeeService;
        this.environment=environment;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployees(@PathVariable("id") String employeeId){
        ResponseEntity responseEntity;
        try{
           return responseEntity=new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);
        }catch(EmployeeNotFoundException exception){
            return  responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees(){
        ResponseEntity responseEntity;
        try{
            return responseEntity=new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
        }catch(EmployeeNotFoundException exception){
            return  responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
