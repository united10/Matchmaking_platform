package com.example.upstream.controller;

import com.example.upstream.domain.certificate.Certificate;
import com.example.upstream.domain.education.Education;
import com.example.upstream.domain.experience.Experience;
import com.example.upstream.domain.location.Location;
import com.example.upstream.domain.project.Project;
import com.example.upstream.domain.skills.Section;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UpStreamController {
private KafkaTemplate<String,Education> kafkaTemplateEducation;
private KafkaTemplate<String, Section> kafkaTemplateSkills;
private KafkaTemplate<String, Location>kafkaTemplateLocation;
private KafkaTemplate<String,Project>kafkaTemplateProject;
private KafkaTemplate<String, Experience>kafkaTemplateExperience;
private KafkaTemplate<String,Certificate>kafkaTemplateCertificate;

    @Autowired
    public UpStreamController(KafkaTemplate<String, Education> kafkaTemplateEducation, KafkaTemplate<String, Section> kafkaTemplateSkills, KafkaTemplate<String, Location> kafkaTemplateLocation, KafkaTemplate<String, Project> kafkaTemplateProject, KafkaTemplate<String, Experience> kafkaTemplateExperience, KafkaTemplate<String, Certificate> kafkaTemplateCertificate) {
        this.kafkaTemplateEducation = kafkaTemplateEducation;
        this.kafkaTemplateSkills = kafkaTemplateSkills;
        this.kafkaTemplateLocation = kafkaTemplateLocation;
        this.kafkaTemplateProject = kafkaTemplateProject;
        this.kafkaTemplateExperience = kafkaTemplateExperience;
        this.kafkaTemplateCertificate = kafkaTemplateCertificate;
    }

//Creating topics
private static final  String  TOPIC ="education";
private static final String TOPIC1 = "skills";
private static final String TOPIC2 = "location";
private static final String TOPIC3 = "project";
private static final String TOPIC4 = "experience";
private static final String TOPIC5 = "certificate";
    @PostMapping("/education")
    public ResponseEntity<?> newEducation(@RequestBody Education education){
        ResponseEntity responseEntity = null;
        try {
            education.setOperationType("add");
             responseEntity = new ResponseEntity(education, HttpStatus.OK);
            kafkaTemplateEducation.send(TOPIC, education).get();
        }
        catch (TimeoutException e){
            responseEntity = new ResponseEntity(education,HttpStatus.BAD_REQUEST);
        }
        catch (KafkaException e){
            responseEntity = new ResponseEntity(education,HttpStatus.BAD_REQUEST);
        } catch (InterruptedException e) {
            System.out.println("caught  exception");
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
    @PutMapping("/education")
    public ResponseEntity<?> updateEducation(@RequestBody Education education){
        education.setOperationType("update");
        ResponseEntity responseEntity = new ResponseEntity(education,HttpStatus.OK);
        kafkaTemplateEducation.send(TOPIC,education);
        return responseEntity;
    }
    @DeleteMapping("/education")
    public ResponseEntity<?> deleteEducation(@RequestBody Education education){
        education.setOperationType("delete");
        ResponseEntity responseEntity = new ResponseEntity(education,HttpStatus.OK);
        kafkaTemplateEducation.send(TOPIC,education);
        return responseEntity;
    }
    @PostMapping("/location")
    public ResponseEntity<?> newLocation(@RequestBody Location location)
    {
        location.setOperationType("add");
        ResponseEntity responseEntity = new ResponseEntity(location,HttpStatus.OK);
        kafkaTemplateLocation.send(TOPIC2,location);
        return responseEntity;

    }
    @PutMapping("/location")
    public ResponseEntity<?> updateLocation(@RequestBody Location location){
        location.setOperationType("update");
        ResponseEntity responseEntity = new ResponseEntity(location,HttpStatus.OK);
        kafkaTemplateLocation.send(TOPIC2,location);
        return responseEntity;
    }
    @DeleteMapping("/location")
    public ResponseEntity<?> deleteEducation(@RequestBody Location location){
        location.setOperationType("delete");
        ResponseEntity responseEntity = new ResponseEntity(location,HttpStatus.OK);
        kafkaTemplateLocation.send(TOPIC2,location);
        return responseEntity;
    }

    @PostMapping("/skills")
    public ResponseEntity<?> newSkills(@RequestBody Section section)
    {
        section.setOperationType("add");
        ResponseEntity responseEntity = new ResponseEntity(section,HttpStatus.OK);
        kafkaTemplateSkills.send(TOPIC1,section);
        return responseEntity;

    }
    @PutMapping("/skills")
    public ResponseEntity<?> updateSkills(@RequestBody Section section)
    {
        section.setOperationType("update");
        ResponseEntity responseEntity = new ResponseEntity(section,HttpStatus.OK);
        kafkaTemplateSkills.send(TOPIC1,section);
        return responseEntity;

    }
    @DeleteMapping("/skills")
    public ResponseEntity<?> deleteSkills(@RequestBody Section section)
    {
        section.setOperationType("delete");
        ResponseEntity responseEntity = new ResponseEntity(section,HttpStatus.OK);
        kafkaTemplateSkills.send(TOPIC1,section);
        return responseEntity;

    }
    @PostMapping("/project")
    public ResponseEntity<?> newProject(@RequestBody Project project)
    {
        project.setOperationType("add");
        ResponseEntity responseEntity = new ResponseEntity(project,HttpStatus.OK);
        kafkaTemplateProject.send(TOPIC3,project);
        return responseEntity;

    }
    @PutMapping("/project")
    public ResponseEntity<?> updateProject(@RequestBody Project project)
    {
        project.setOperationType("update");
        ResponseEntity responseEntity = new ResponseEntity(project,HttpStatus.OK);
        kafkaTemplateProject.send(TOPIC3,project);
        return responseEntity;

    }
    @DeleteMapping("/project")
    public ResponseEntity<?> deleteProject(@RequestBody Project project)
    {
        project.setOperationType("delete");
        ResponseEntity responseEntity = new ResponseEntity(project,HttpStatus.OK);
        kafkaTemplateProject.send(TOPIC3,project);
        return responseEntity;

    }
    @PostMapping("/experience")
    public ResponseEntity<?> newExperience(@RequestBody Experience experience)
    {
        experience.setOperationType("add");
        ResponseEntity responseEntity = new ResponseEntity(experience,HttpStatus.OK);
        kafkaTemplateExperience.send(TOPIC4,experience);
        return responseEntity;

    }
    @PutMapping("/experience")
    public ResponseEntity<?> updateExperience(@RequestBody Experience experience)
    {
        experience.setOperationType("update");
        ResponseEntity responseEntity = new ResponseEntity(experience,HttpStatus.OK);
        kafkaTemplateExperience.send(TOPIC4,experience);
        return responseEntity;

    }
    @DeleteMapping("/experience")
    public ResponseEntity<?> deleteExperience(@RequestBody Experience experience)
    {
        experience.setOperationType("delete");
        ResponseEntity responseEntity = new ResponseEntity(experience,HttpStatus.OK);
        kafkaTemplateExperience.send(TOPIC4,experience);
        return responseEntity;

    }
    @PostMapping("/certificate")
    public ResponseEntity<?> newCertificate(@RequestBody Certificate certificate)
    {
        certificate.setOperationType("add");
        ResponseEntity responseEntity = new ResponseEntity(certificate,HttpStatus.OK);
        kafkaTemplateCertificate.send(TOPIC5,certificate);
        return responseEntity;

    }
    @PutMapping("/certificate")
    public ResponseEntity<?> updateCertificate(@RequestBody Certificate certificate)
    {
        certificate.setOperationType("update");
        ResponseEntity responseEntity = new ResponseEntity(certificate,HttpStatus.OK);
        kafkaTemplateCertificate.send(TOPIC5,certificate);
        return responseEntity;

    }
    @DeleteMapping("/certificate")
    public ResponseEntity<?> deleteCertificate(@RequestBody Certificate certificate)
    {
        certificate.setOperationType("delete");
        ResponseEntity responseEntity = new ResponseEntity(certificate,HttpStatus.OK);
        kafkaTemplateCertificate.send(TOPIC5,certificate);
        return responseEntity;

    }
}
