package com.stackroute.locationservice.controller;


import com.stackroute.locationservice.service.LocationService;
import com.stackroute.locationservice.domain.CommonOutput;
import com.stackroute.locationservice.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping("/location")
    public ResponseEntity<String> processData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = locationService.processLocationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString() , HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/location")
    public ResponseEntity<String> view(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = locationService.processLocationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString() , HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
        return responseEntity;
    }
    @PutMapping("/location")
    public ResponseEntity<String> update(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = locationService.processLocationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
