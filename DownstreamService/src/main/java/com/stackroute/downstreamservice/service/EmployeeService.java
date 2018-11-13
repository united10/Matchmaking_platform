package com.stackroute.downstreamservice.service;

import com.stackroute.downstreamservice.domain.Education;
import com.stackroute.downstreamservice.domain.Employee;
import com.stackroute.downstreamservice.domain.Skills;
import com.stackroute.downstreamservice.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.downstreamservice.exceptions.EmployeeNotFoundException;

import com.stackroute.downstreamservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(String employeeId) throws EmployeeNotFoundException{
        Employee employee;
        if(employeeRepository.existsById(employeeId)){
            employee=employeeRepository.findById(employeeId).get();
            return employee;
        }else{
            throw new EmployeeNotFoundException("Empty database");
        }
    }

    public List<Employee> getAllEmployee() throws EmployeeNotFoundException{
        List<Employee> employees=employeeRepository.findAll();
        if(!employees.isEmpty()){

            return employees;
        }else{
            throw new EmployeeNotFoundException("Empty database");
        }
    }

    public void saveEmployee(Employee employee)throws EmployeeAlreadyExistsException {
        if(!employeeRepository.existsById(employee.getUserId())){
            employeeRepository.save(employee);
        }else{
            throw new EmployeeAlreadyExistsException("User Already Exists");
        }
    }

    public void addEducationData(List<Education> educations,String userId) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(userId)){
                Employee employee = employeeRepository.findById(userId).get();
                List<Education> fetchEducations = employee.getEducations();
                if(fetchEducations==null){
                    fetchEducations=new ArrayList<>();
                }
                for(Education education:educations) {
                    fetchEducations.add(education);
                }
                employee.setEducations(fetchEducations);
                employeeRepository.save(employee);

        }else{
                throw new EmployeeNotFoundException("Not found");
        }

    }


    public void addSkillsData(List<Skills> skills, String userId) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(userId)){
            Employee employee = employeeRepository.findById(userId).get();
            List<Skills> fetchSkills = employee.getSkills();
            if(fetchSkills==null){
                fetchSkills=new ArrayList<>();
            }
            for(Skills skills1:skills) {
                fetchSkills.add(skills1);
            }
            employee.setSkills(fetchSkills);
            employeeRepository.save(employee);

        }else{
            throw new EmployeeNotFoundException("Not found");
        }

    }

}
