import { Component, OnInit, Inject, Renderer2 } from '@angular/core';

import { ExperienceService } from 'src/app/add-module/service/experience.service';
import { Output } from '../experience-dialog/domain/output';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ExperienceSection } from '../experience-dialog/domain/section';
import { Chicklets } from '../experience-dialog/domain/chicklets';
import { ExperienceDetails } from '../experience-dialog/domain/experience-details';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { Organisation } from './domain/organisation';
import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';


@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {



  experienceForm: FormGroup;
  filteredOrganisations: Organisation[] = [];
  isLoading = false;
  organisation: string;
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
  temp: FormArray;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
    private dialogRef: MatDialogRef<ExperienceComponent>,
    private experienceService: ExperienceService, private fb: FormBuilder,
    private token: TokenStorageService) {

  }

  ngOnInit() {
    this.experienceForm = this.fb.group({
      experience: this.fb.array([this.initItemRow()])
    });
  }
  onKeyUp(index: number) {
    console.log('qualif' + index);
    this.temp = this.experienceForm.get('experience') as FormArray;
    this.temp.at(index).get('organisation').valueChanges.pipe(
      debounceTime(300),
      tap(() => this.isLoading = true),
      switchMap(value =>
        this.experienceService.search({name: value}, 1)
      .pipe(
        finalize(() => this.isLoading = false),
        )
      )
    )
    .subscribe(response => this.filteredOrganisations = response.organisations);
 }
displayFn(organisation: Organisation) {
  if (organisation) {
    return organisation.name; }
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
    const section = new ExperienceSection('Experience', this.token.getEmail(), 'add', chicklets);
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
