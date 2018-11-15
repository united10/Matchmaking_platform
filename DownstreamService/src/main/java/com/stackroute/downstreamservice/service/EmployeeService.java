package com.stackroute.downstreamservice.service;

import com.stackroute.downstreamservice.domain.*;
import com.stackroute.downstreamservice.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.downstreamservice.exceptions.EmployeeNotFoundException;

import com.stackroute.downstreamservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:config.properties")
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    private Environment environment;

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
            throw new EmployeeNotFoundException(environment.getProperty("errors.emptyDatabase"));
        }
    }

    public List<Employee> getAllEmployee() throws EmployeeNotFoundException{
        List<Employee> employees=employeeRepository.findAll();
        if(!employees.isEmpty()){

            return employees;
        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.emptyDatabase"));
        }
    }

    public void saveEmployee(Employee employee)throws EmployeeAlreadyExistsException {
        if(!employeeRepository.existsById(employee.getUserId())){
            employeeRepository.save(employee);
        }else{
            throw new EmployeeAlreadyExistsException(environment.getProperty("errors.employeeAlreadyExist"));
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
                throw new EmployeeNotFoundException(environment.getProperty("errors.employeeNotFound"));
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
            throw new EmployeeNotFoundException(environment.getProperty("errors.employeeNotFound"));
        }

    }

    public void addLocationData(Location locations, String userId) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(userId)){
            Employee employee = employeeRepository.findById(userId).get();
            Location fetchLocation= employee.getLocation();
            if(fetchLocation==null){
                fetchLocation=Location.builder().build();
            }
            List<PastLocation> pastLocations=fetchLocation.getPastLocation();
            if(pastLocations==null){
                pastLocations=new ArrayList<>();
            }

            if(locations.getCurrentLocation()!=fetchLocation.getCurrentLocation()){
                fetchLocation.setCurrentLocation(locations.getCurrentLocation());
            }

            for(PastLocation pastLocation:locations.getPastLocation()) {
                pastLocations.add(pastLocation);
            }
            fetchLocation.setPastLocation(pastLocations);
            employee.setLocation(fetchLocation);
            employeeRepository.save(employee);

        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.employeeNotFound"));
        }

    }

}
