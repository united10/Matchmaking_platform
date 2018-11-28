package com.stackroute.cacheservice.RedisRepository;

import com.stackroute.cacheservice.RedisDomain.RedisExperience;
import com.stackroute.cacheservice.domain.Node;
import com.stackroute.cacheservice.domain.education;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpRepository extends CrudRepository<RedisExperience, Long> {

}
