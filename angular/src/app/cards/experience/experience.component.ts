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
  fromDay: number;
  fromMonth: number;
  fromYear: number;
  toDay: number;
  toMonth: number;
  toYear: number;
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
      let fromDay ;
      fromDay = parseInt(date[2] , 10);
      let fromYear;
      fromYear = parseInt(date[3] , 10);
      let fromMonthStr;
      fromMonthStr = date[1];
      let fromMonth;

      switch (fromMonthStr) {
        case 'Jan': fromMonth = 1;
        break;
        case 'Feb': fromMonth = 2;
        break;
        case 'Mar': fromMonth = 3;
        break;
        case 'Apr': fromMonth = 4;
        break;
        case 'May': fromMonth = 5;
        break;
        case 'Jun': fromMonth = 6;
        break;
        case 'Jul': fromMonth = 7;
        break;
        case 'Aug': fromMonth = 8;
        break;
        case 'Sep': fromMonth = 9;
        break;
        case 'Oct': fromMonth = 10;
        break;
        case 'Nov': fromMonth = 11;
        break;
        case 'Dec': fromMonth = 12;
        break;
      }

      console.log(date);
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
