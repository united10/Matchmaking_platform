import { Component, Input, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';

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
    private tokenstorageservice: TokenStorageService ) {}


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

  logout() {
    this.tokenstorageservice.signOut();
    window.location.reload();
  }
}
