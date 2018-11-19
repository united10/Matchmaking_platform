import { Component, OnInit, Inject, Renderer2 } from '@angular/core';
import { ReadfromjsonService } from './../service/readfromjson.service';
import { Qualification } from '../educationclasses/qualification';
import { Institution } from '../educationclasses/institution';
import { EducationChicklets } from '../educationclasses/educationchicklets';
import { EducationService } from 'src/app/cards/service/education.service';
import { Output } from '../outputclass/output';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { EducationSection } from '../educationclasses/educationsection';
import { TokenStorageService } from 'src/app/login/auth/token-storage.service';

@Component({
  selector: 'app-educationdialog',
  templateUrl: './educationdialog.component.html',
  styleUrls: ['./educationdialog.component.css']
})
export class EducationdialogComponent implements OnInit {

  educationForm: FormGroup;
  qualification: string;
  institute: string;
  startDate: string;
  endDate: string;
  summary: string;
  output: Output;
  errorMessage: string;
  totalRow: number;
  dataJson: any;
  json_url = 'assets/education.json';
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
    private dialogRef: MatDialogRef<EducationdialogComponent>,
    private educationService: EducationService, private fb: FormBuilder,
    private readfromjsonService: ReadfromjsonService,
    private token: TokenStorageService) {

  }

  ngOnInit() {
    this.educationForm = this.fb.group({
      education: this.fb.array([this.initItemRow()])
    });

    this.dataJson = this.readfromjsonService.readFromJson(this.json_url).subscribe(
      data => {
        this.dataJson = data;
      }
    );
}

  initItemRow() {
    return this.fb.group({
      qualification: new FormControl('', Validators.required),
      institute: new FormControl('', Validators.required),
      startDate: new FormControl('', Validators.required),
      endDate: new FormControl('', Validators.required)
    });
  }
  addRow() {
    const control = <FormArray>this.educationForm.controls['education'];
    control.push(this.initItemRow());

  }
  deleteRow(index: number) {
    const control = <FormArray>this.educationForm.controls['education'];
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
    const arr = this.educationForm.get('education') as FormArray;
    const chicklets = new Array<EducationChicklets>();
    for (let i = 0; i < arr.length; i++) {
      const row = arr.at(i);
      const qualification = new Qualification('qualificationId', row.value.qualification);
      const institution = new Institution('institutionId',
        row.value.institute,
        row.value.startDate,
        row.value.endDate);
      const chicklet = new EducationChicklets(qualification, institution, this.summary);
      chicklets.push(chicklet);
    }
    const section = new EducationSection('Education', this.token.getEmail(), 'add', chicklets);
    this.educationService.addEducationDetails(section).subscribe(
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
