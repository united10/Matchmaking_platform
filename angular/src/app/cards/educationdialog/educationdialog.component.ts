import { Component, OnInit, Inject, Renderer2 } from '@angular/core';
import { Qualification } from '../classes/qualification';
import { Institution } from '../classes/institution';
import { Chicklets } from '../classes/chicklets';
import { EducationService } from 'src/app/cards/service/education.service';
import { Output } from '../classes/output';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Section } from '../classes/section';

@Component({
  selector: 'app-educationdialog',
  templateUrl: './educationdialog.component.html',
  styleUrls: ['./educationdialog.component.css']
})
export class EducationdialogComponent implements OnInit {

  detailsForm: FormGroup;
  qualification: string;
  institute: string;
  startDate: string;
  endDate: string;
  summary: string;
  output: Output;
  errorMessage: string;
  totalRow:number;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
    private dialogRef: MatDialogRef<EducationdialogComponent>,
    private educationService: EducationService, private fb: FormBuilder) {

  }

  ngOnInit() {
    this.detailsForm = this.fb.group({
      education: this.fb.array([this.initItemRow()])
    });
  }

  initItemRow() {
    return this.fb.group({
      qualification: new FormControl('', Validators.required),
      institute: new FormControl('',Validators.required),
      startDate: new FormControl('',Validators.required),
      endDate: new FormControl('',Validators.required)
    });
  }
  addRow() {
    const control = <FormArray>this.detailsForm.controls['education'];
    control.push(this.initItemRow());

  }
  deleteRow(index:number){
    const control = <FormArray>this.detailsForm.controls['education'];
    if(control!=null){
      this.totalRow=control.value.length;
    }
    if(this.totalRow>1){
      control.removeAt(index);
    }else{
      alert('Add one more details.');
      return false;
    }
  }

  onSave() {
    var arr = this.detailsForm.get('education') as FormArray;
    var chicklets = new Array<Chicklets>();
    for (let i = 0; i < arr.length; i++) {
      var row = arr.at(i);
      var qualification = new Qualification("qualificationId", row.value.qualification);
      var institution = new Institution("institutionId",
        row.value.institute,
        row.value.startDate,
        row.value.endDate);
      var chicklet = new Chicklets(qualification, institution, this.summary);
      chicklets.push(chicklet);
    }
    var section = new Section("Education", "userId", "add", chicklets);
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
