import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { EducationdialogComponent } from '../educationdialog/educationdialog.component';

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
    console.log("hey");
    this.dialogRef.close();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;
    dialogConfig.width='40%';
    this.dialog.open(EducationdialogComponent, dialogConfig);
  }
}
