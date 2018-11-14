import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormGroup, FormBuilder, FormControl, Validators, FormArray } from '@angular/forms';
import { Component, OnInit, Inject } from '@angular/core';
import { SkillService } from '../service/skill.service';
import { SkillChicklets } from '../skillclasses/skillchicklets';
import { Skill } from '../skillclasses/skill';
import { SkillSection } from '../skillclasses/skillsection';
import { Output } from '../outputclass/output';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  skillForm: FormGroup;
  skillName: string;
  skillLevel: string;
  output: Output;
  errorMessage: string;
  totalRow:number;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
    private dialogRef: MatDialogRef<SkillComponent>,
    private skillService: SkillService, private fb: FormBuilder) {

  }

  ngOnInit() {
    this.skillForm = this.fb.group({
      skills: this.fb.array([this.initItemRow()])
    });
  }

  initItemRow() {
    return this.fb.group({
      skillName: new FormControl('',Validators.required),
      skillLevel: new FormControl('',Validators.required)
    });
  }
  addRow() {
    const control = <FormArray>this.skillForm.controls['skills'];
    control.push(this.initItemRow());

  }
  deleteRow(index:number){
    const control = <FormArray>this.skillForm.controls['skills'];
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
    var arr = this.skillForm.get('skills') as FormArray;
    var chicklets = new Array<SkillChicklets>();
    for (let i = 0; i < arr.length; i++) {
      const row = arr.at(i);
      const skill = new Skill("skillId", row.value.skillName,row.value.skillLevel);
      const chicklet = new SkillChicklets(skill);
      chicklets.push(chicklet);
    }
    console.log("fjd "+chicklets);
    const section = new SkillSection("Skill", "userId", "add", chicklets);
    this.skillService.addSkillDetails(section).subscribe(
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
