import { ProjectService } from './../service/project.service';
import { ReadfromjsonService } from './../service/readfromjson.service';
import { Project } from './../project-dialog/domain/project';
import { Skill } from './../project-dialog/domain/skill';
import { ProjectChicklets } from './../project-dialog/domain/projectchicklets';
import { ProjectSection } from './../project-dialog/domain/projectsection';
import { Component, OnInit , Inject } from '@angular/core';
import { FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { Domain } from './domain/domain';
import { Organisation } from './domain/organisation';
import { Client } from './domain/client';
import { Tech } from './domain/Tech';
import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';


@Component({
  selector: 'app-projectdialog',
  templateUrl: './projectdialog.component.html',
  styleUrls: ['./projectdialog.component.css']
})


export class ProjectdialogComponent implements OnInit {
  projectForm: FormGroup;
  filteredDomains: Domain[] = [];
  filteredOrganisation: Organisation[] = [];
  filteredClients: Client[] = [];
  filteredTech: Tech[] = [];
  isLoading = false;
  isLoading1 = false;
  isLoading2 = false;
  isLoading3 = false;
  title: string;
  startDate: string;
  endDate: string;
  url: string;
  domain: string;
  role: string;
  company: string;
  client: string;
  skill: string;
  level: string;
  description: string;
  errorMessage: string;
  totalRow: number;
  dataJson: any;
  json_url = 'assets/project.json';
  temp: FormArray;
  options: string[] = ['Beginner', 'Intermediate', 'Advance'];

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
  private dialogRef: MatDialogRef<ProjectdialogComponent>,
  private fb: FormBuilder, private projectService: ProjectService,
  private readfromjsonService: ReadfromjsonService,
  private token: TokenStorageService) { }

  ngOnInit() {
    const regForUrl = '(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?';
    this.projectForm = this.fb.group({
      title: ['', [Validators.required]],
      startDate: '',
      endDate: '',
      url: ['', [ Validators.pattern(regForUrl)]],
      domain : '',
      role: '',
      company: '',
      client: '',
      technologiesUsed: this.fb.array([this.createTechnology()]),
      description: ''
    });

    this.dataJson = this.readfromjsonService.readFromJson(this.json_url).subscribe(
      data => {
        this.dataJson = data;
      }
    );
  }
  onKeyUp(index: number) {
    this.projectForm.get('domain').valueChanges.pipe(
      debounceTime(300),
      tap(() => this.isLoading = true),
      switchMap(value =>
        this.projectService.searchdomain({name: value}, 1)
      .pipe(
        finalize(() => this.isLoading = false),
        )
      )
    )
    .subscribe(response => this.filteredDomains = response.domains);
 }
displayFn(domain: Domain) {
  if (domain) {
    return domain.name; }
}

onKeyUp1(index: number) {
  this.projectForm.get('company').valueChanges.pipe(
    debounceTime(300),
    tap(() => this.isLoading1 = true),
    switchMap(value =>
      this.projectService.searchcompany({name: value}, 1)
    .pipe(
      finalize(() => this.isLoading1 = false),
      )
    )
  )
  .subscribe(response => this.filteredOrganisation = response.organizations);
}
displayFn1(organisation: Organisation) {
if (organisation) {
  return organisation.name; }
}

onKeyUp2(index: number) {
  this.projectForm.get('client').valueChanges.pipe(
    debounceTime(300),
    tap(() => this.isLoading2 = true),
    switchMap(value =>
      this.projectService.searchclient({name: value}, 1)
    .pipe(
      finalize(() => this.isLoading2 = false),
      )
    )
  )
  .subscribe(response => this.filteredClients = response.organizations);
}
displayFn2(client: Client) {
if (client) {
  return client.name; }
}

  onKeyUp3(index: number) {
    this.temp = this.projectForm.get('technologiesUsed') as FormArray;
    this.temp.at(index).get('skill').valueChanges.pipe(
      debounceTime(300),
      tap(() => this.isLoading3 = true),
      switchMap(value =>
        this.projectService.searchtech({name: value}, 1)
      .pipe(
        finalize(() => this.isLoading3 = false),
        )
      )
    )
    .subscribe(techs => this.filteredTech = techs.skills);
 }
displayFn3(tech: Tech) {
  if (tech) {
    return tech.name; }
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
    this.domain = this.projectForm.get('domain').value as string;
    this.role = this.projectForm.get('role').value as string;
    this.company = this.projectForm.get('company').value as string;
    this.client = this.projectForm.get('client').value as string;
    this.description = this.projectForm.get('description').value as string;

    const technologies = new Array<Skill>();
      const arr = this.projectForm.get('technologiesUsed') as FormArray;
      const values = arr.value;
      for (const row of values) {
        const technology = new Skill(row.skill , row.level);
        technologies.push(technology);
      }

    const project = new Project(this.title, this.startDate, this.endDate,
       this.url, this.domain, this.role , this.company, this.client ,
        technologies , this.description );
    const chicklets = new Array<ProjectChicklets>();
    const chicklet = new ProjectChicklets(project);
    chicklets.push(chicklet);
    const section = new ProjectSection('sectionId', this.token.getEmail(), 'add', chicklets);
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
