import { Component, OnInit } from '@angular/core';
import { Section } from '../experience-class/section';
import { Chicklets } from '../experience-class/chicklets';
import { ExperienceDetails } from '../experience-class/experience-details';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  detailsForm: FormGroup;
  private  organisation: string;
  private  role: string;
  private  fromDate: number;
  private  fromMonth: number;
  private  fromYear: number;
  private  toDate: number;
  private  toMonth: number;
  private  toYear: number;

  section: Section;
  chicklets: Chicklets;
  experienceDetails: ExperienceDetails;

  constructor() { }

  ngOnInit() {
  }

  sendFunction() {
    this.section = new Section();
    this.chicklets = new Chicklets();
    this.experienceDetails = new ExperienceDetails();

    this.experienceDetails.organisation = this.organisation;
    this.experienceDetails.role = this.role;
    this.experienceDetails.fromDate = this.fromDate;
    this.experienceDetails.fromMonth = this.fromMonth;
    this.experienceDetails.fromYear = this.fromYear;
    this.experienceDetails.toDate = this.toDate;
    this.experienceDetails.toMonth = this.toMonth;
    this.experienceDetails.toYear = this.toYear;

    this.chicklets.experienceDetails = this.experienceDetails;

    this.section.sectionId = "123";
    this.section.userId = "456";
    this.section.operationType = "789";
    this.section.chicklets = this.chicklets;

    console.log("working");
    console.log(this.section);


  //  // console.log(this.experienceObject); 
  //  this._backendService.sendFun(this.experienceObject).subscribe(data => this.output = data);
  //  console.log("working success");
 }

}
