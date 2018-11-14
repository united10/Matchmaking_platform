import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Certificate } from '../certificateclasses/certificate';
import { CertificateChicklets } from '../certificateclasses/certificatechicklets';
import { CertificateSection } from '../certificateclasses/certificatesection';
@Component({
  selector: 'app-certificatedialog',
  templateUrl: './certificatedialog.component.html',
  styleUrls: ['./certificatedialog.component.css']
})
export class CertificatedialogComponent implements OnInit {

  certificateForm: FormGroup;
  certificateName: string;
  certificateAuthority: string;
  licenseNumber: string;
  fromDate: string;
  toDate: string;
  errorMessage: string;
  totalRow: number;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
  private dialogRef: MatDialogRef<CertificatedialogComponent>, private fb: FormBuilder) {

}
  ngOnInit() {
    this.certificateForm = this.fb.group({
      certificate: this.fb.array([this.initItemRow()])
    });
  }
  initItemRow() {
    return this.fb.group({
      certificateName: new FormControl('', Validators.required),
      certificateAuthority: new FormControl('', Validators.required),
      licenseNumber: new FormControl('', Validators.required),
      fromDate: new FormControl('', Validators.required),
      toDate: new FormControl('', Validators.required)
    });
  }
  addRow() {
    const control = <FormArray>this.certificateForm.controls['certificate'];
    control.push(this.initItemRow());

  }
  deleteRow(index: number) {
    const control = <FormArray>this.certificateForm.controls['certificate'];
    if (control != null) {
      this.totalRow = control.value.length;
    }
    if (this.totalRow > 1 ) {
      control.removeAt(index);
    } else {
      alert('Add one more details.');
      return false;
    }
  }

  onSave() {
    const arr = this.certificateForm.get('certificate') as FormArray;
    const chicklets = new Array<CertificateChicklets>();
    for (let i = 0; i < arr.length; i++) {
      const row = arr.at(i);
      const certificateDetails = new Certificate(row.value.qualification, row.value.certificateAuthority,
        row.value.licenseNumber, row.value.fromDate, row.value.toDate);
      const chicklet = new CertificateChicklets(certificateDetails);
      chicklets.push(chicklet);
    }
     const section = new CertificateSection('Certificate', 'userId', 'add', chicklets);
    // this.educationService.addEducationDetails(section).subscribe(
    //   data => {
    //     this.output = data;
    //     console.log(this.output);
    //     this.dialogRef.close();
    //   },
    //   error => {
    //     this.errorMessage = error;
    //   }
    // );
  }

  onClose() {
    this.dialogRef.close();
  }
}

