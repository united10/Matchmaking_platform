import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Certificate } from '../certificatedialog/domain/certificate';
import { CertificateChicklets } from '../certificatedialog/domain/certificatechicklets';
import { CertificateSection } from '../certificatedialog/domain/certificatesection';
import { CertificateService } from '../service/certificate.service';
import { ReadfromjsonService } from './../service/readfromjson.service';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';

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
  dataJson: any;
  json_url = 'assets/certificate.json';

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
  private certificateService: CertificateService, private readfromjsonService: ReadfromjsonService,
  private dialogRef: MatDialogRef<CertificatedialogComponent>,
  private fb: FormBuilder,
  private token: TokenStorageService) {

}
  ngOnInit() {
    this.certificateForm = this.fb.group({
      certificate: this.fb.array([this.initItemRow()])
    });

    this.dataJson = this.readfromjsonService.readFromJson(this.json_url).subscribe(
      data => {
        this.dataJson = data;
      }
    );
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
      const certificateDetails = new Certificate(row.value.certificateName, row.value.certificateAuthority,
        row.value.licenseNumber, row.value.fromDate, row.value.toDate);
      const chicklet = new CertificateChicklets(certificateDetails);
      chicklets.push(chicklet);
    }
     const section = new CertificateSection('Certificate', this.token.getEmail(), 'add', chicklets);
    this.certificateService.addCertificateDetails(section).subscribe(
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

