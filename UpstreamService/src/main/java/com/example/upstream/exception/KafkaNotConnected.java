package com.example.upstream.exception;

public class KafkaNotConnected extends Exception {

    public KafkaNotConnected (String s){
        super(s);
    }

}
