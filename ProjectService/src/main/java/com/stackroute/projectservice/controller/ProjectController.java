package com.stackroute.projectservice.controller;


import com.stackroute.projectservice.service.ProjectService;
import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping("project")
    public ResponseEntity<String> processData(@RequestBody Section project){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = projectService.processProjectDetails(project);
            responseEntity = new ResponseEntity<String>(commonOutput.toString() , HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        System.out.println(responseEntity.toString());
        return responseEntity;
    }

    @GetMapping("/project")
    public ResponseEntity<String> viewData(@RequestBody Section project){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = projectService.processProjectDetails(project);
            responseEntity = new ResponseEntity<String>(commonOutput.toString() , HttpStatus.OK);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("/project")
    public ResponseEntity<String> updateData(@RequestBody Section project){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = projectService.processProjectDetails(project);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/project")
    public ResponseEntity<String> deleteData(@RequestBody Section project){
        ResponseEntity responseEntity;
        try{
            CommonOutput commonOutput = projectService.processProjectDetails(project);
            responseEntity = new ResponseEntity<String>(commonOutput.toString(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
