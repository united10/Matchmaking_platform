import { Component, Input } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';

@Component({
  selector: 'app-employee-dashboard-dummy',
  templateUrl: './employee-dashboard-dummy.component.html',
  styleUrls: ['./employee-dashboard-dummy.component.css'],
})
export class EmployeeDashboardDummyComponent {
  /** Based on the screen size, switch from standard to one column per row */

  cards;
  keys;
  constructor(private breakpointObserver: BreakpointObserver) {}

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
              'skillLevel': skill.skillLevel

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
              'description' : projects.description
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
            'contents': []
            };
            const contents = [];
          for (const location of employees.location) {

            contents[j] = {
              'currentLocation' : location.currentLocation,
              'pastLocation' : location.pastLocation
            };

            j++;
          }
        locationInfo.contents = contents;
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
              'toDate' : certificates.toDate
            };

            j++;
          }
        certificateInfo.contents = contents;
        i++;
        cards[i] = certificateInfo;
        }
        if (employees.experience != null) {
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
              'toYear' : experiences.toYear
            };

            j++;
          }
        experienceInfo.contents = contents;
        i++;
        cards[i] = experienceInfo;
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
            console.log(cards[index].contents.length);
            cards[index].rows = cards[index].contents.length / 2;
            cards[index].cols = 1;
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
}
