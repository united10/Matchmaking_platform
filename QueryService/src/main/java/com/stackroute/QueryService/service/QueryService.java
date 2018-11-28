package com.stackroute.QueryService.service;

import com.stackroute.QueryService.domain.QueryData;
import com.stackroute.QueryService.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    private QueryRepository queryRepository;


    @Autowired
    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    //    Method for adding query into the query document of MongoDB
    public void addQueryData(QueryData queryData) {
        queryRepository.save(queryData);
    }
}


