import { FormArray } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material/dialog';
import { Component, OnInit, Inject } from '@angular/core';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {

  name: string;
  temp: FormArray;
  email: string;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
  private dialogRef: MatDialogRef<PortfolioComponent>,
  private dialog: MatDialog) { }


  ngOnInit() {
  }
  onReciving(employee: any) {
      console.log(employee);
      this.name = employee.name;
      this.email = employee.email;
      console.log(this.name);
  }
}
