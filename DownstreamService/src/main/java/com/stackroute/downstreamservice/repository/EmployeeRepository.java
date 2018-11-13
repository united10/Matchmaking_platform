package com.stackroute.downstreamservice.repository;

import com.stackroute.downstreamservice.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
