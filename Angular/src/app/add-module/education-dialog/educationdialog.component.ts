import { Component, OnInit, Inject, Renderer2 } from '@angular/core';
import { ReadfromjsonService } from './../service/readfromjson.service';
import { Qualification } from '../education-dialog/domain/qualification';
import { Institution } from '../education-dialog/domain/institution';
import { EducationChicklets } from '../education-dialog/domain/educationchicklets';
import { EducationService } from 'src/app/add-module/service/education.service';
import { Output } from '../outputclass/output';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { EducationSection } from '../education-dialog/domain/educationsection';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';
import { IQualificationResponse, Qualificationn } from './domain/qualificationn';

@Component({
  selector: 'app-educationdialog',
  templateUrl: './educationdialog.component.html',
  styleUrls: ['./educationdialog.component.css']
})
export class EducationdialogComponent implements OnInit {
  filteredQualifications: Qualificationn[] = [];
  isLoading = false;
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
  temp: FormArray;
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
  onKeyUp(index: number) {
    console.log('qualif' + index);
    this.temp = this.educationForm.get('education') as FormArray;
    this.temp.at(index).get('qualification').valueChanges.pipe(
      debounceTime(300),
      tap(() => this.isLoading = true),
      switchMap(value =>
        this.educationService.search({name: value}, 1)
      .pipe(
        finalize(() => this.isLoading = false),
        )
      )
    )
    .subscribe(qualifications => this.filteredQualifications = qualifications.educations);
 }
displayFn(qualification: Qualificationn) {
  if (qualification) {
    return qualification.name; }
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
