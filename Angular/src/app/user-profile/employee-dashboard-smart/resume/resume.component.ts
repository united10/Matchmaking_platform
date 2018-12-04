import { Certificate } from './../../../add-module/certificate-dialog/domain/certificate';
import { Skill } from './../../../add-module/skill-dialog/domain/skill';
import { Qualification } from 'src/app/add-module/education-dialog/domain/qualification';
import { Institute } from './../../../add-module/education-dialog/domain/institute';
import { FormArray, FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Institution } from 'src/app/add-module/education-dialog/domain/institution';
import { EducationChicklets } from './../../../add-module/education-dialog/domain/educationchicklets';
import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import * as jsPDF from 'jspdf';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent implements OnInit {
  @ViewChild('container') container: ElementRef;
temp: FormArray;
temp2: any;
  institutionName: string;
  title: string;
  skillName: string;
  skillLevel: string;
  certificateName: String;
  certificateAuthority: String;

  constructor() { }

  ngOnInit() {
  }
  onReciving(employee: any) {
    console.log(employee);

    // // this.institutionName = employee.educations.institution.institutionName;
    // this.temp = employee.educations;
    // var qualification = new Array();
    // console.log(`education ${this.temp}`);
    // // console.log(`x ${this.education.qualification.title}`);
    // for (const education of employee.educations) {
    // //  qualification.push(education.qualification.title);
    // console.log('x' + education.institution.institutionName);
    // }
    // // console.log('cdcdcdc' + this.temp);
    // // this.temp2 = this.temp.at().get('institution');
    // // console.log('cdcdcdc' + this.temp2);
    // // this.institutionName = this.temp2.institutionName;
    // // console.log('cdcdcdc' + this.institutionName);

    for (const education of employee.educations) {
      this.institutionName = education.institution.institutionName;
      this.title = education.qualification.title;
      console.log('x' + education.institution.institutionName);
      console.log('x' + education.qualification.title);
    }

    for (const skill of employee.skills) {
      this.skillName = skill.skillName;
      this.skillLevel = skill.skillLevel;
    }


    for (const Certificates of employee.Certificate) {
      this.certificateAuthority = Certificates.certificateName;
      this.certificateName = Certificates.certificateName;
      console.log('x' + Certificates.certificateName);
    }
  }
  public downloadPDF() {
    var doc = new jsPDF("p", "mm", "a4");
    let specialElementHandlers = {
      '#editor':function(element, renderer)  {
        return true;
      }
    };

    let container= this.container.nativeElement;
    doc.fromHTML(container.innerHTML, 15, 15, {
     'width': 40,
     'elementHandlers': specialElementHandlers
    });
    doc.save('testing.pdf');
    // return xepOnline.Formatter.format('container2', {render: 'download'});
  }
}
