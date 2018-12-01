package com.stackroute.downstreamservice.controller;


import com.stackroute.downstreamservice.domain.Employee;

import com.stackroute.downstreamservice.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.downstreamservice.exceptions.EmployeeNotFoundException;
import com.stackroute.downstreamservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*This is the rest controller class to handle rest api calls from the frontend
and other dependent services if any
 */
@CrossOrigin("*")
@RestController
@RequestMapping("${controller.base}")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }
    //Handles get request to /matchmaker/v1/employees/id to fetch a particular employee
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
    //Handles get request to /matchmaker/v1/employees to fetch  all employees
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

    //Handles post request to /matchmaker/v1/employees to register  an employee
    @PostMapping("${controller.employees}")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        ResponseEntity responseEntity;
        try{
            employeeService.saveEmployee(employee);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.OK);
        }catch(EmployeeAlreadyExistsException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }catch(Exception exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

}
