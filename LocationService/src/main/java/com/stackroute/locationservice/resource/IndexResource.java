package com.stackroute.locationservice.resource;

import com.stackroute.locationservice.domain.CommonOutput;

public interface IndexResource {

//    @Autowired
//        private KafkaTemplate<String , CommonOutput> kafkaTemplate;
//        private static final String TOPIC= "indexer";
        public void postData(CommonOutput commonOutput);


}
