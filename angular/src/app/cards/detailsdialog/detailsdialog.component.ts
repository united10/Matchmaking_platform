import { CertificatedialogComponent } from './../certificatedialog/certificatedialog.component';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { EducationdialogComponent } from '../educationdialog/educationdialog.component';
import { ExperienceComponent } from '../experience/experience.component';
<<<<<<< HEAD
import { SkillComponent } from '../skill/skill.component';
//import {SkillComponent}
=======
import { CertificatedialogComponent } from '../certificatedialog/certificatedialog.component';
>>>>>>> 9c196e8daf33e7675773fa7bf723ce0f6a0673bd

@Component({
  selector: 'app-detailsdialog',
  templateUrl: './detailsdialog.component.html',
  styleUrls: ['./detailsdialog.component.css']
})
export class DetailsdialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
    private dialogRef: MatDialogRef<DetailsdialogComponent>,
    private dialog: MatDialog) { }

  ngOnInit() {
  }

  close(): void {
    this.dialogRef.close();
  }
  educationClick() {
    console.log('hey');
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(EducationdialogComponent, dialogConfig);
  }

  experienceClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(ExperienceComponent, dialogConfig);
  }
<<<<<<< HEAD

  skillClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(SkillComponent, dialogConfig);
    
  }
=======
>>>>>>> 9c196e8daf33e7675773fa7bf723ce0f6a0673bd
  certificateClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
<<<<<<< HEAD
    dialogConfig.width='40%';
=======
    dialogConfig.width = '40%';
>>>>>>> 9c196e8daf33e7675773fa7bf723ce0f6a0673bd
    this.dialog.open(CertificatedialogComponent, dialogConfig);
  }
}
