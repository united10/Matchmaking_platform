import { Component, OnInit, Inject, Renderer2 } from '@angular/core';

import { ExperienceService } from 'src/app/cards/service/experience.service';
import { Output } from '../experience-class/output';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ExperienceSection } from '../experience-class/section';
import { Chicklets } from '../experience-class/chicklets';
import { ExperienceDetails } from '../experience-class/experience-details';


@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {



  experienceForm: FormGroup;
  organistion: string;
  role: string;
  startDate: string;
  endDate: string;
  output: Output;
  errorMessage: string;
  totalRow: number;
  fromDay: string;
  fromMonth: string;
  fromYear: string;
  toDay: string;
  toMonth: string;
  toYear: string;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
    private dialogRef: MatDialogRef<ExperienceComponent>,
    private experienceService: ExperienceService, private fb: FormBuilder) {

  }

  ngOnInit() {
    this.experienceForm = this.fb.group({
      experience: this.fb.array([this.initItemRow()])
    });
  }

  initItemRow() {
    return this.fb.group({
      organisation: new FormControl('', Validators.required),
      role: new FormControl('', Validators.required),
      startDate: new FormControl('', Validators.required),
      endDate: new FormControl('', Validators.required)
    });
  }
  addRow() {
    const control = <FormArray>this.experienceForm.controls['experience'];
    control.push(this.initItemRow());
  }

  deleteRow(index: number) {
    const control = <FormArray>this.experienceForm.controls['experience'];
    if (control != null) {
      this.totalRow = control.value.length;
    }
    if (this.totalRow > 1) {
      control.removeAt(index);
    } else {
      alert('Add one more details.');
      return false;
    }
  }


  onSave() {
    const arr = this.experienceForm.get('experience') as FormArray;
    const chicklets = new Array<Chicklets>();
    for (let i = 0; i < arr.length; i++) {
      const row = arr.at(i);
      let fromDate;
      fromDate = row.value.startDate + '';
      console.log(fromDate);
      let date;
      date = fromDate.split(' ', 4);
      this.fromDay = date[2];
      this.fromYear = date[3];
      this.fromMonth = date[1];

      let toDate;
      toDate = row.value.endDate + '';
      console.log(fromDate);
      let date1;
      date1 = toDate.split(' ', 4);
      this.toDay = date1[2];
      this.toYear = date1[3];
      this.toMonth = date1[1];

      const experienceDetails = new ExperienceDetails(row.value.organisation,
                                  row.value.role,
                                  this.fromDay,
                                  this.fromMonth,
                                  this.fromYear,
                                  this.toDay,
                                  this.toMonth,
                                  this.toYear);
      const chicklet = new Chicklets(experienceDetails);
      chicklets.push(chicklet);
    }
    const section = new ExperienceSection('Experience', 'userId', 'add', chicklets);
    this.experienceService.addExperienceDetails(section).subscribe(
      data => {
        this.output = data;
        console.log(this.output);
        this.dialogRef.close();
      },
      error => {
        this.errorMessage = error;
      }
    );
  }

  onClose() {
    this.dialogRef.close();
  }
}
