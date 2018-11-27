package com.stackroute.cacheservice.RedisService;

import com.stackroute.cacheservice.RedisDomain.RedisExperience;

import java.util.List;


public interface ExpService {

    public RedisExperience saveExperience(RedisExperience experience);
    public List<RedisExperience> getAllRedisExperience();
}
