package com.stackroute.cacheservice.resource;

import com.stackroute.cacheservice.RedisDomain.*;
import com.stackroute.cacheservice.RedisService.*;

import com.stackroute.cacheservice.domain.Experience;
import com.stackroute.cacheservice.RedisDomain.*;
import com.stackroute.cacheservice.domain.education;
import com.stackroute.cacheservice.domain.Location;
import com.stackroute.cacheservice.domain.Skill;
import com.stackroute.cacheservice.service.*;
import com.stackroute.cacheservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1")
public class ExperienceResource {


    private ExperienceService experienceService;
    private EducationService educationService;
    private LocationService locationService;
    private SkillService skillService;
    private EducService educService;
    private ExpService expService;
    private LocService locService;
    private SkillServices skillServices;
    private QualificationService qualificationService;

    @Autowired
    public ExperienceResource(ExperienceService experienceService,
                              EducationService educationService,
                              LocationService locationService ,
                              SkillService skillService,
                              EducService educService ,
                              ExpService expService,
                              LocService locService ,
                              SkillServices skillServices,
                              QualificationService qualificationService) {
        this.experienceService=experienceService;
        this.educationService=educationService;
        this.locationService=locationService;
        this.skillService = skillService;
        this.educService = educService;
        this.expService = expService;
        this.locService = locService;
        this.skillServices = skillServices;
        this.qualificationService = qualificationService;
    }

    @GetMapping("/experience")
    public List<Experience> getAllexperirence(){

        List<Experience> experienceCollection=experienceService.getAllExperience();
        for(int i=0;i<experienceCollection.size();i++){
            RedisExperience redisExperience = new RedisExperience();
            Experience experience1 = experienceCollection.get(i);
            redisExperience.setId(experience1.getId());
            redisExperience.setName(experience1.getName());
            expService.saveExperience(redisExperience);
        }
        return experienceCollection;
    }

    @GetMapping("/redisExperience")
    public List<RedisExperience> getAllRedisExperience(){
        List<RedisExperience> redisExperiences = expService.getAllRedisExperience();
        return redisExperiences;
    }

    @GetMapping("/redisExperience/{term}")
    public List<RedisExperience> searchOrganization(@PathVariable("term") String term){
        List<RedisExperience> redisExperiences  = expService.getAllRedisExperience();
        List<RedisExperience> autoOrganization = new ArrayList<>();
        Pattern regex = Pattern.compile("(" + term.toLowerCase() + ")");
        for(int i = 0 ; i<redisExperiences.size(); i++){
            Matcher m = regex.matcher(redisExperiences.get(i).toString().toLowerCase());
            if (m.find()) {
                autoOrganization.add(redisExperiences.get(i));
            }
        }
        System.out.println(autoOrganization);
        return autoOrganization;
    }

   @GetMapping("/education")
    public List<education> getAlleducation(){
       List<education> educationsCollection = educationService.getAlleducation();
       System.out.println(educationsCollection);
       for(int i = 0; i<educationsCollection.size();i++ ){
           RedisEducation redisEducation=new RedisEducation();
           education education1=educationsCollection.get(i);
           redisEducation.setId(education1.getId());
           redisEducation.setName(education1.getName());
           educService.saveEducation(redisEducation);
       }
       System.out.println(educService.getALlRedisEducation());
       return educationsCollection;
    }

    @GetMapping("/qualification")
    public List<education> getAllQualification(){
        List<education> qualificationCollection = educationService.getAllQualification();
        System.out.println(qualificationCollection);
        for(int i = 0; i<qualificationCollection.size();i++ ){
            RedisQualification redisQualification=new RedisQualification();
            education education1=qualificationCollection.get(i);
            redisQualification.setId(education1.getId());
            redisQualification.setName(education1.getName());
            qualificationService.saveQualification(redisQualification);
          //  System.out.println("22222"+qualificationService.saveQualification(redisQualification));
        }
        System.out.println("22" + qualificationService.getAllRedisQualification());
        return qualificationCollection;
    }

    @GetMapping("/redisEducation/education")
    public EducationOutput getAllRedisEducation(){
        List<RedisEducation> redisEducations = educService.getALlRedisEducation();
        EducationOutput educationOutput =EducationOutput.builder().educations(redisEducations).build();
        System.out.println(educService.getALlRedisEducation());
        return educationOutput;
    }

    @GetMapping("/redisEducation/qualification")
    public QualificationOutput getAllRedisQualification(){
        List<RedisQualification> redisQualifications = qualificationService.getAllRedisQualification();
        QualificationOutput qualificationOutput =QualificationOutput.builder().Qualifications(redisQualifications).build();
        System.out.println("srk" + qualificationService.getAllRedisQualification());
        return qualificationOutput;
    }

    @GetMapping("/redisEducation/education/{term}")
    public EducationOutput searchCollege(@PathVariable("term") String term){
        List<RedisEducation> redisEducations = educService.getALlRedisEducation();
        List<RedisEducation> autoCollege = new ArrayList<>();
        Pattern regex = Pattern.compile("(" + term.toLowerCase() + ")");
        for(int i = 0 ; i<redisEducations.size(); i++){
            Matcher m = regex.matcher(redisEducations.get(i).toString().toLowerCase());
            if (m.find()) {
                autoCollege.add(redisEducations.get(i));
            }
        }
        EducationOutput educationOutput = EducationOutput.builder().educations(autoCollege).build();
        System.out.println(autoCollege);
        return educationOutput;
    }

    @GetMapping("/redisEducation/qualification/{term}")
    public QualificationOutput searchQualification(@PathVariable("term") String term){
        List<RedisQualification> redisQualifications = qualificationService.getAllRedisQualification();
        List<RedisQualification> autoQualification = new ArrayList<>();
        Pattern regex = Pattern.compile("(" + term.toLowerCase() + ")");
        for(int i = 0 ; i<redisQualifications.size(); i++){
            Matcher m = regex.matcher(redisQualifications.get(i).toString().toLowerCase());
            if (m.find()) {
                autoQualification.add(redisQualifications.get(i));
            }
        }
        QualificationOutput qualificationOutput = QualificationOutput.builder().Qualifications(autoQualification).build();
        System.out.println(autoQualification);
        return qualificationOutput;
    }

   @GetMapping("/location")
    public List<Location> getAlllocation(){
       List<Location> locationsCollection = locationService.getAlllocation();
       for(int i = 0 ; i< locationsCollection.size() ; i++){
           RedisLocation redisLocation = new RedisLocation();
           Location location1 = locationsCollection.get(i);
           redisLocation.setId(location1.getId());
           redisLocation.setName(location1.getName());
           locService.saveLocation(redisLocation);
       }
       return locationsCollection;
   }

   @GetMapping("/redisLocation")
    public List<RedisLocation> getAllRedisLocation(){
        List<RedisLocation> redisLocations = locService.getAllRedisLocation();
        return redisLocations;
   }

    @GetMapping("/redisLocation/{term}")
    public List<RedisLocation> cityAutoComplete(@PathVariable("term") String term) {
        List<RedisLocation> locationsCollection = locService.getAllRedisLocation();
        List<RedisLocation> autoCities = new ArrayList<>();
        Pattern regex = Pattern.compile("(" + term.toLowerCase() + ")");
        for (int i = 0; i < locationsCollection.size(); i++) {
            Matcher m = regex.matcher(locationsCollection.get(i).toString().toLowerCase());
            if (m.find()) {
                autoCities.add(locationsCollection.get(i));
            }
        }
        System.out.println(autoCities);
        return autoCities;
    }



    @GetMapping("/skill")
    public List<Skill>getAllSkills(){
        List<Skill>skillCollection = skillService.getAllSkills();
        for(int i = 0 ; i<skillCollection.size() ; i++){
            RedisSkill redisSkill = new RedisSkill();
            Skill skill1 = skillCollection.get(i);
            redisSkill.setId(skill1.getId());
            redisSkill.setName(skill1.getName());
            skillServices.saveSkill(redisSkill);
        }
        return skillCollection;
   }

   @GetMapping("/redisSkill")
    public List<RedisSkill> getAllRedisSkill() {
        List<RedisSkill> redisSkills = skillServices.getAllRedisSkill();
        return redisSkills;
   }

   @GetMapping("/redisSkill/{term}")
   public List<RedisSkill> searchSkill(@PathVariable("term") String term){
        List<RedisSkill> redisSkills = skillServices.getAllRedisSkill();
       System.out.println("all skills"+redisSkills);
        List<RedisSkill> autoSkill = new ArrayList<>();
       Pattern regex = Pattern.compile("(" + term.toLowerCase() + ")");
        for(int i = 0 ; i< redisSkills.size(); i++){
            Matcher m = regex.matcher(redisSkills.get(i).toString().toLowerCase());
            if (m.find()) {
                autoSkill.add(redisSkills.get(i));
            }

        }
       System.out.println(autoSkill);
       return autoSkill;
   }

   @GetMapping("/output")
    public Output getAll(){
        List<RedisEducation> redisEducationList = educService.getALlRedisEducation();
        List<RedisLocation> redisLocationList = locService.getAllRedisLocation();
        List<RedisSkill> redisSkillList = skillServices.getAllRedisSkill();
        List<RedisExperience> redisExperienceList = expService.getAllRedisExperience();
        Output output = Output.builder().education(redisEducationList)
                                        .locations(redisLocationList)
                                        .skills(redisSkillList)
                                        .experiences(redisExperienceList)
                                        .build();
       System.out.println(output);
       return output;
   }
}
