import { Component, Input, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { EducationChicklets } from 'src/app/add-module/education-dialog/domain/educationchicklets';
import { EducationSection } from 'src/app/add-module/education-dialog/domain/educationsection';
import { DownstreamBackendService } from '../../downstream-backend.service';
import { SkillChicklets } from 'src/app/add-module/skill-dialog/domain/skillchicklets';
import { SkillSection } from 'src/app/add-module/skill-dialog/domain/skillsection';
import { ProjectChicklets } from 'src/app/add-module/project-dialog/domain/projectchicklets';
import { ProjectSection } from 'src/app/add-module/project-dialog/domain/projectsection';
import { CertificateChicklets } from 'src/app/add-module/certificate-dialog/domain/certificatechicklets';
import { CertificateSection } from 'src/app/add-module/certificate-dialog/domain/certificatesection';
import { ExperienceSection } from 'src/app/add-module/experience-dialog/domain/section';

@Component({
  selector: 'app-employee-dashboard-dummy',
  templateUrl: './employee-dashboard-dummy.component.html',
  styleUrls: ['./employee-dashboard-dummy.component.css'],
})
export class EmployeeDashboardDummyComponent implements OnInit{
  /** Based on the screen size, switch from standard to one column per row */

  cards;
  keys;
  isLoggedIn = false;
  constructor(private breakpointObserver: BreakpointObserver,
    private tokenstorageservice: TokenStorageService ,private downstreamBackendService:DownstreamBackendService) {}


  ngOnInit() {
    if (this.tokenstorageservice.getToken()) {
      this.isLoggedIn = true;
    }
  }

  setEmployees(employees: any) {
    this.cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(

      map(({ matches }) => {
        const cards = [];
        let basicInfo;
        let educationInfo;
        let skillsInfo;
        let projectInfo;
        let locationInfo;
        let certificateInfo;
        let experienceInfo;
        let i = 0;
        console.log(employees);

        basicInfo = {'title': 'Basic Information', 'contents': {
          'employeeName': employees.name,
          'email': employees.email
        }};
        cards[i] = basicInfo;

        if (employees.educations != null) {
          let j = 0;
          educationInfo = {
            'title': 'Education',
            'contents': []
            };
            const contents = [];
          for (const education of employees.educations) {

            contents[j] = {
              'qualification': education.qualification.title,
              'summary': education.summary,
              'institution': education.institution.institutionName,
              'institution data':education.institution,
              'startDate': education.institution.startDate,
              'endDate': education.institution.endDate
            };

            j++;
          }
        educationInfo.contents = contents;
        i++;
        cards[i] = educationInfo;
        }

        if (employees.skills != null) {
          let j = 0;
          skillsInfo = {
            'title': 'Skills',
            'contents': []
            };
            const contents = [];
          for (const skill of employees.skills) {

            contents[j] = {
              'skillName': skill.skillName,
              'skillLevel': skill.skillLevel,
              'skill':skill

            };

            j++;
          }
        skillsInfo.contents = contents;
        i++;
        cards[i] = skillsInfo;
        }
        if (employees.projects != null) {
          let j = 0;
          projectInfo = {
            'title': 'Project',
            'contents': []
            };
            const contents = [];
          for (const projects of employees.projects) {

            contents[j] = {
              'title': projects.title,
              'fromDate': projects.fromDate,
              'toDate' : projects.toDate,
              'projectUrl' : projects.projectUrl,
              'role' : projects.role,
              'technologiesUsed' : projects.technologiesUsed,
              'description' : projects.description,
              'project':projects
            };

            j++;
          }
        projectInfo.contents = contents;
        i++;
        cards[i] = projectInfo;
        }
        if (employees.location != null) {
          let j = 0;
          locationInfo = {
            'title': 'Location',
            'contents':[ {
              'currentCityName' : employees.location.currentLocation.cityName,
              'currentStateName' : employees.location.currentLocation.stateName,
              'currentPinCode' :  employees.location.currentLocation.pinCode,
              'pastLocation' : employees.location.pastLocation
            }]
            };
        i++;
        cards[i] = locationInfo;
        }
        if (employees.certificates != null) {
          let j = 0;
          certificateInfo = {
            'title': 'Certificate',
            'contents': []
            };
            const contents = [];
          for (const certificates of employees.certificates) {

            contents[j] = {
              'certificateName' : certificates.certificateName,
              'certificateAuthority' : certificates.certificateAuthority,
              'licenseNumber' : certificates.licenseNumber,
              'fromDate' : certificates.fromDate,
              'toDate' : certificates.toDate,
              'certificate':certificates
            };

            j++;
          }
        certificateInfo.contents = contents;
        i++;
        cards[i] = certificateInfo;
        console.log(cards[i]);
        }
        if (employees.experiences != null) {
          let j = 0;
          experienceInfo = {
            'title': 'Experience',
            'contents': []
            };
            const contents = [];
          for (const experiences of employees.experiences) {

            contents[j] = {
              'organisation' :  experiences.organisation,
              'role' : experiences.role,
              'fromDate' : experiences.fromDate,
              'toDate' : experiences.toDate,
              'fromMonth' : experiences.fromMonth,
              'toMonth' : experiences.toMonth,
              'fromYear' : experiences.fromYear,
              'toYear' : experiences.toYear ,
              'experience': experiences
            };

            j++;
          }
        experienceInfo.contents = contents;
        i++;
        cards[i] = experienceInfo;
        console.log(cards[i]);
        }
        if (matches) {
          for (const index in cards) {
            cards[index].cols = 2;
            if (index !== '0') {
            cards[index].rows = cards[index].contents.length;
          } else {
            cards[index].rows = 1;
          }
        }
          return cards;
        }

        for (const index in cards) {
          if (index === '0') {cards[index].cols = 2;
            cards[index].rows = 1;
          } else {
            if(cards[index].title  === 'Skills') {
              cards[index].rows = cards[index].contents.length/2 ;
              cards[index].cols = 1;
            }else{
            console.log(cards[index].contents.length);
            cards[index].rows = cards[index].contents.length ;
            cards[index].cols = 1;
            }
          }

        }



        return cards;
      })
    );
  }

  hasProp(o, name) {
    return o.hasOwnProperty(name);
  }

  isTitle(title, check) {

    return title === check;
  }

  logout() {
    this.tokenstorageservice.signOut();
    window.location.reload();
  }

  onDelete(content,title){
    if(title==='Education'){
      
      var  educationChicklets=new EducationChicklets(content.qualification,content.institution,content.summary);
      const chicklets=[educationChicklets];
      var educationSection=new EducationSection("Education","userId","delete",chicklets);
      this.downstreamBackendService.deleteEducationDetails(educationSection)
      .subscribe(
        (data)=>{
          console.log(data);
          location.reload();
        }
      );
    }
    else if(title==='Skills'){
      var skillChicklet=new SkillChicklets(content.skill);
      const chicklets=[skillChicklet];
      var skillSection=new SkillSection("Skills","userId","delete",chicklets);
      this.downstreamBackendService.deleteSkillsDetails(skillSection)
      .subscribe(
        (data)=>{
          console.log(data);
          location.reload();
        }
      );
    }    else if(title==='Project'){
      var projectChicklet=new ProjectChicklets(content.project);
      const chicklets=[projectChicklet];
      var projectSection=new ProjectSection("Project","userId","delete",chicklets);
      this.downstreamBackendService.deleteProjectDetails(projectSection)
      .subscribe(
        (data)=>{
          console.log(data);
          location.reload();
        }
      );
    }    else if(title==='Certificate'){
      var certificateChicklet=new CertificateChicklets(content.certificate);
      const chicklets=[certificateChicklet];
      var certificateSection=new CertificateSection("Certificate","userId","delete",chicklets);
      this.downstreamBackendService.deleteCerificateDetails(certificateSection)
      .subscribe(
        (data)=>{
          console.log(data);
          location.reload();
        }
      );
    }    else if(title==='Experience'){
      var experienceChicklet=new experienceChicklet(content.skill);
      const chicklets=[experienceChicklet];
      var experienceSection=new ExperienceSection("Experience","userId","delete",chicklets);
      this.downstreamBackendService.deleteExperienceDetails(experienceSection)
      .subscribe(
        (data)=>{
          console.log(data);
          location.reload();
        }
      );
    }    else if(title==='Location'){
      var skillChicklet=new SkillChicklets(content.skill);
      const chicklets=[skillChicklet];
      var skillSection=new SkillSection("Skills","userId","delete",chicklets);
      this.downstreamBackendService.deleteSkillsDetails(skillSection)
      .subscribe(
        (data)=>{
          console.log(data);
          location.reload();
        }
      );
    }

  }
}
