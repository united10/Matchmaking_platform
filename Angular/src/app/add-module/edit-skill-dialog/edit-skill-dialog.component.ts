import { Component, OnInit , Inject } from '@angular/core';
import { SkillComponent } from '../skill-dialog/skill.component';
import { DownstreamService } from '../service/downstream.service';
import { ReadfromjsonService } from './../service/readfromjson.service';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { SkillService } from '../service/skill.service';
import { FormBuilder , FormControl, Validators , FormArray } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Skillauto } from '../skill-dialog/domain/skillauto';
import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';





@Component({
  selector: 'app-edit-skill-dialog',
  templateUrl: './edit-skill-dialog.component.html',
  styleUrls: ['./edit-skill-dialog.component.css']
})
export class EditSkillDialogComponent extends SkillComponent implements OnInit {
  employeeData: any;
  filteredSkills: Skillauto[] = [];
  isLoading = false;
  constructor(@Inject(MAT_DIALOG_DATA) protected data: any,
  protected dialogRef: MatDialogRef<SkillComponent>, protected readfromjsonService: ReadfromjsonService,
  protected skillService: SkillService, protected fb: FormBuilder,
  protected token: TokenStorageService, private downstream: DownstreamService ) {
    super(data, dialogRef, readfromjsonService, skillService, fb, token);
   }

  ngOnInit() {
    this.downstream.subject.subscribe(data => this.employeeData = data);
    console.log(this.employeeData.skillName);
    this.skillForm = this.fb.group({
      skills: this.fb.array([this.initItemRow()])
    });
    this.dataJson = this.readfromjsonService.readFromJson(this.json_url).subscribe(
      data => {
        this.dataJson = data;
      }
    );
  }

  initItemRow() {
    return this.fb.group({
      skillName: new FormControl(this.employeeData.skillName, Validators.required),
      skillLevel: new FormControl(this.employeeData.skillLevel, Validators.required)
    });
  }

  displayFn(skill: Skillauto) {
    if (skill) {
      return skill.name; }
  }

  onKeyUp(index: number) {
    this.temp = this.skillForm.get('skills') as FormArray;
    console.log(this.temp);
    this.temp.at(index).get('skillName').valueChanges.pipe(
      debounceTime(300),
      tap(() => this.isLoading = true),
      switchMap(value =>
        this.skillService.searchskills({name: value}, 1)
      .pipe(
        finalize(() => this.isLoading = false),
        )
      )
    )
    .subscribe(Iskills => this.filteredSkills = Iskills.skills);

 }

}
