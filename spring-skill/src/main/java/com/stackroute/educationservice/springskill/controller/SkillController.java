package com.stackroute.educationservice.springskill.controller;

import com.stackroute.educationservice.springskill.domain.CommonOutput;
import com.stackroute.educationservice.springskill.service.SkillService;
import com.stackroute.educationservice.springskill.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class SkillController {



    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;

    }

    @PostMapping("/skill")
    public ResponseEntity<?> processData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = skillService.processSameOutput(section);
            responseEntity = new ResponseEntity<CommonOutput>(commonOutput, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/skill")
    public ResponseEntity<?> updateData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = skillService.processSameOutput(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/skill")
    public ResponseEntity<?> deleteData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = skillService.processSameOutput(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


}

