package com.stackroute.projectservice.Controller;


import com.stackroute.projectservice.Service.ProjectService;
import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Project;
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
    public ResponseEntity<?> processData(@RequestBody Project project){
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
    public ResponseEntity<?> viewData(@RequestBody Project project){
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
    public ResponseEntity<?> updateData(@RequestBody  Project project){
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
    public ResponseEntity<?> deleteData(@RequestBody Project project){
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
