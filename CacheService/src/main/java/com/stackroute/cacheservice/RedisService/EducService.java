package com.stackroute.cacheservice.RedisService;

import com.stackroute.cacheservice.RedisDomain.RedisEducation;
import com.stackroute.cacheservice.RedisDomain.RedisQualification;
import com.stackroute.cacheservice.domain.Node;
import com.stackroute.cacheservice.domain.education;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EducService {

    public RedisEducation saveEducation(RedisEducation education);
    public List<RedisEducation> getALlRedisEducation();
    public List<RedisEducation> searchCollege(String term);

}
