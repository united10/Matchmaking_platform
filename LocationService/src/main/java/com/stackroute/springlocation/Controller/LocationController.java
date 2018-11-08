package com.stackroute.springlocation.Controller;


import com.stackroute.springlocation.Service.LocationService;
import com.stackroute.springlocation.domain.CommonOutput;
import com.stackroute.springlocation.domain.Section;
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
    public ResponseEntity<?> processData(@RequestBody Section section){
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
    public ResponseEntity<?> viewData(@RequestBody Section section){
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
    @PutMapping("/location")
    public ResponseEntity<?> updateData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = locationService.processLocationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/location")
    public ResponseEntity<?> deleteData(@RequestBody Section section){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = locationService.processLocationDetails(section);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
