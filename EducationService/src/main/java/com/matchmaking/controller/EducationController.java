package com.matchmaking.controller;

import com.matchmaking.domain.CommonOutput;
import com.matchmaking.domain.Section;
import com.matchmaking.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping("/education")
    public ResponseEntity<?> processData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = educationService.processEducationDetails(section);
            responseEntity = new ResponseEntity<CommonOutput>(commonOutput, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/education")
    public ResponseEntity<?> updateData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = educationService.processEducationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/education")
    public ResponseEntity<?> deleteData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = educationService.processEducationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
