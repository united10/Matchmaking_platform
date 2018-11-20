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

    //    Method for getting an employee from the Employees Document of MongoDB
    public Employee getEmployee(String employeeId) throws EmployeeNotFoundException{
        Employee employee;
        if(employeeRepository.existsById(employeeId)){
            employee=employeeRepository.findById(employeeId).get();
            return employee;
        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.emptyDatabase"));
        }
    }
    //    Method for getting all employees from the Employees Document of MongoDB
    public List<Employee> getAllEmployee() throws EmployeeNotFoundException{
        List<Employee> employees=employeeRepository.findAll();
        if(!employees.isEmpty()){

            return employees;
        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.emptyDatabase"));
        }
    }
    //    Method for adding an employee into the Employees Document of MongoDB
    public void saveEmployee(Employee employee)throws EmployeeAlreadyExistsException {
        if(!employeeRepository.existsById(employee.getUserId())){
            employeeRepository.save(employee);
        }else{
            throw new EmployeeAlreadyExistsException(environment.getProperty("errors.employeeAlreadyExist"));
        }
    }

    //    Method for adding education data to list of education of a particular employee into the Employees Document of MongoDB
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

    //    Method for adding skill to skills of a particular employee into the Employees Document of MongoDB
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

    //    Method for adding location to locations of a particular employee into the Employees Document of MongoDB
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
    //    Method for adding experience to experiences of a particular employee into the Employees Document of MongoDB
    public void addExperienceData(List<Experience> experiences, String userId) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(userId)){
            Employee employee = employeeRepository.findById(userId).get();
            List<Experience> fetchExperiences = employee.getExperiences();
            if(fetchExperiences==null){
                fetchExperiences=new ArrayList<>();
            }
            for(Experience experience:experiences) {
                fetchExperiences.add(experience);
            }
            employee.setExperiences(fetchExperiences);
            employeeRepository.save(employee);

        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.employeeNotFound"));
        }

    }

    //    Method for adding project to projects of a particular employee into the Employees Document of MongoDB
    public void addProjectData(List<ProjectDetails> projects, String userId) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(userId)){
            Employee employee = employeeRepository.findById(userId).get();
            List<ProjectDetails> fetchProjects = employee.getProjects();
            if(fetchProjects==null){
                fetchProjects=new ArrayList<>();
            }
            for(ProjectDetails project:projects) {
                fetchProjects.add(project);
            }
            employee.setProjects(fetchProjects);
            employeeRepository.save(employee);

        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.employeeNotFound"));
        }

    }



//    Method for adding certificate data of a particular employee into the Employees Document of MongoDB
    public void addCertificateData(List<Certificate> certificates, String userId) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(userId)){
            Employee employee = employeeRepository.findById(userId).get();
            List<Certificate> fetchCertificates = employee.getCertificates();
            if(fetchCertificates==null){
                fetchCertificates=new ArrayList<>();
            }
            for(Certificate certificate:certificates) {
                fetchCertificates.add(certificate);
            }
            employee.setCertificates(fetchCertificates);
            employeeRepository.save(employee);

        }else{
            throw new EmployeeNotFoundException(environment.getProperty("errors.employeeNotFound"));
        }

    }



}
