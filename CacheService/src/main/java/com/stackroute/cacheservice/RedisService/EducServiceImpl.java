package com.stackroute.cacheservice.RedisService;

import com.stackroute.cacheservice.RedisDomain.RedisEducation;
import com.stackroute.cacheservice.RedisRepository.EducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EducServiceImpl implements EducService {

    EducRepository educRepository;


    @Autowired
    public EducServiceImpl(EducRepository educRepository){
        this.educRepository = educRepository;
    }

    @Override
    public RedisEducation saveEducation(RedisEducation education){
       RedisEducation education1 =  educRepository.save(education);
       return education1;
    }

    @Override
    public List<RedisEducation> getALlRedisEducation() {
       return (List<RedisEducation>) educRepository.findAll();
    }

    @Override
    public List<RedisEducation> searchCollege(String term){
        return (List<RedisEducation>) educRepository.findAll();
    }
}