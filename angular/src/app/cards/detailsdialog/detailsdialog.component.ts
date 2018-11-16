import { CertificatedialogComponent } from './../certificatedialog/certificatedialog.component';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { EducationdialogComponent } from '../educationdialog/educationdialog.component';
import { ExperienceComponent } from '../experience/experience.component';
import { SkillComponent } from '../skill/skill.component';
import { LocationdialogComponent } from '../locationdialog/locationdialog.component';
<<<<<<< HEAD
=======
import { ProjectdialogComponent } from '../projectdialog/projectdialog.component';
>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7

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
  skillClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(SkillComponent, dialogConfig);
  }
<<<<<<< HEAD
=======

  projectClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(ProjectdialogComponent, dialogConfig);
  }

>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
  certificateClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(CertificatedialogComponent, dialogConfig);
  }
  locationClick() {
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '40%';
    this.dialog.open(LocationdialogComponent, dialogConfig);
  }
}
