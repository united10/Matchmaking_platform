package com.stackroute.cacheservice.RedisRepository;

import com.stackroute.cacheservice.RedisDomain.RedisEducation;
import com.stackroute.cacheservice.domain.education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducRepository extends CrudRepository<RedisEducation, Long> {

}
