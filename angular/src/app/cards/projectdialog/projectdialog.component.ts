import { ProjectService } from './../service/project.service';
import { Project } from './../projectclasses/project';
import { Skill } from './../projectclasses/skill';
import { ProjectChicklets } from './../projectclasses/projectchicklets';
import { ProjectSection } from './../projectclasses/projectsection';

import { Component, OnInit , Inject } from '@angular/core';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-projectdialog',
  templateUrl: './projectdialog.component.html',
  styleUrls: ['./projectdialog.component.css']
})
export class ProjectdialogComponent implements OnInit {
  projectForm: FormGroup;
  title: string;
  startDate: string;
  endDate: string;
  url: string;
  role: string;
  skill: string;
  level: string;
  description: string;
  errorMessage: string;
  totalRow: number;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
  private dialogRef: MatDialogRef<ProjectdialogComponent>,
  private fb: FormBuilder, private projectService: ProjectService) { }

  ngOnInit() {
    this.projectForm = this.fb.group({
      title: ['', [Validators.required]],
      startDate: '',
      endDate: '',
      url: '',
      role: '',
      technologiesUsed: this.fb.array([this.createTechnology()]),
      description: ''
    });
  }

  createTechnology(): FormGroup {
    return this.fb.group({
      skill: '',
      level: ''
    });
  }

  addRow() {
    const control = <FormArray>this.projectForm.controls['technologiesUsed'];
      control.push(this.createTechnology());
  }


  deleteRow(i: number) {
    const control = <FormArray>this.projectForm.controls['technologiesUsed'];
      if (control != null) {
        this.totalRow = control.value.length;
      }
      if (this.totalRow > 1) {
        control.removeAt(i);
      } else {
        alert('Add atleast one technology.');
        return false;
      }
  }

  onSave() {
    this.title = this.projectForm.get('title').value as string;
    this.startDate = this.projectForm.get('startDate').value as string;
    this.endDate = this.projectForm.get('endDate').value as string;
    this.url = this.projectForm.get('url').value as string;
    this.role = this.projectForm.get('role').value as string;
    this.description = this.projectForm.get('description').value as string;

    const technologies = new Array<Skill>();
      const arr = this.projectForm.get('technologiesUsed') as FormArray;
      const values = arr.value;
      for (const row of values) {
        const technology = new Skill(row.skill , row.level);
        technologies.push(technology);
      }

    const project = new Project(this.title, this.startDate, this.endDate, this.url, this.role , technologies , this.description );
    const chicklets = new Array<ProjectChicklets>();
    const chicklet = new ProjectChicklets(project);
    chicklets.push(chicklet);
    const section = new ProjectSection('sectionId', 'userId', 'add', chicklets);
    console.log(section);
    this.projectService.addProjectDetails(section).subscribe(
      data => {
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
