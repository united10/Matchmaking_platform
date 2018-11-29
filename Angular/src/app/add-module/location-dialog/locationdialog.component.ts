import { LocationService } from './../service/location.service';
import { PastLocation } from './../location-dialog/domain/pastlocation';
import { CurrentLocation } from './../location-dialog/domain/currentlocation';
import { LocationChicklets } from './../location-dialog/domain/chicklets';
import { LocationSection } from './../location-dialog/domain/section';

import { Component, OnInit , Inject } from '@angular/core';
import { FormGroup, FormArray, FormControl, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Output } from '../outputclass/output';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { Currentcities } from './domain/currentcities';
import { Pastcities } from './domain/pastcities';
import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';

@Component({
  selector: 'app-locationdialog',
  templateUrl: './locationdialog.component.html',
  styleUrls: ['./locationdialog.component.css']
})
export class LocationdialogComponent implements OnInit {
    locationForm: FormGroup;
    filteredCurrentCityName: Currentcities[] = [];
    filteredPastCityName: Pastcities[] = [];
    isLoading = false;
    isLoading1 = false;
    output: Output;
    currentId: string;
    currentCityName: string;
    currentStateName: string;
    currentPincode: string;
    pastId: string;
    pastCityName: string;
    pastStateName: string;
    pastPincode: string;
    // currentlocation: string;
    // pastlocation: string;
    errorMessage: string;
    totalRow: number;
    temp: FormArray;

    constructor(@Inject(MAT_DIALOG_DATA) private data: any,
      private dialogRef: MatDialogRef<LocationdialogComponent>,
      private locationService: LocationService, private fb: FormBuilder,
      private token: TokenStorageService) {
    }

    ngOnInit() {
      this.locationForm = this.fb.group({
        currentId: new FormControl(''),
        currentCityName: new FormControl(''),
        currentStateName: new FormControl(''),
        currentPincode: new FormControl(''),
        pastLocation: this.fb.array([this.initItemRow()])
      });
    }
    onKeyUp(index: number) {
      console.log('qualif' + index);
      this.locationForm.get('currentCityName').valueChanges.pipe(
        debounceTime(300),
        tap(() => this.isLoading = true),
        switchMap(value =>
          this.locationService.searchcurrentcities({name: value}, 1)
        .pipe(
          finalize(() => this.isLoading = false),
          )
        )
      )
      .subscribe(response => this.filteredCurrentCityName = response.cities);
   }
  displayFn(currentcity: Currentcities) {
    if (currentcity) {
      return currentcity.name; }
  }
  onKeyUp1(index: number) {
    console.log('qualif' + index);
    this.temp = this.locationForm.get('pastLocation') as FormArray;
    this.temp.at(index).get('pastCityName').valueChanges.pipe(
      debounceTime(300),
      tap(() => this.isLoading1 = true),
      switchMap(value =>
        this.locationService.searchpastcities({name: value}, 1)
      .pipe(
        finalize(() => this.isLoading1 = false),
        )
      )
    )
    .subscribe(response => this.filteredPastCityName = response.cities);
 }
displayFn1(pastcity: Pastcities) {
  if (pastcity) {
    return pastcity.name; }
}

    initItemRow() {
      return this.fb.group({
        pastId: new FormControl(''),
        pastCityName: new FormControl(''),
        pastStateName: new FormControl(''),
        pastPincode: new FormControl('')
      });
    }
    addRow() {
      const control = <FormArray>this.locationForm.controls['pastLocation'];
      control.push(this.initItemRow());
    }
    deleteRow(index: number) {
      const control = <FormArray>this.locationForm.controls['pastLocation'];
      if (control != null) {
        this.totalRow = control.value.length;
      }
      if (this.totalRow > 1) {
        control.removeAt(index);
      } else {
        alert('Add one more details.');
        return false;
      }
    }
  onSave() {
    this.currentId = this.locationForm.get('currentId').value as string;
    this.currentCityName = this.locationForm.get('currentCityName').value as string;
    this.currentStateName = this.locationForm.get('currentStateName').value as string;
    this.currentPincode = this.locationForm.get('currentPincode').value as string;

      const arr = this.locationForm.get('pastLocation') as FormArray;
      const values = arr.value;
      const currentlocation = new CurrentLocation(this.currentId, this.currentCityName, this.currentPincode, this.currentStateName);
      const chicklets = new Array<LocationChicklets>();
      const pastLocations = new Array<PastLocation>();
      for (const row of values) {
        const pastlocation = new PastLocation(
          row.pastId , row.pastCityName, row.pastStateName , row.pastPincode);
          console.log(pastlocation);
        pastLocations.push(pastlocation);
        console.log(chicklets);
      }
      const chicklet = new LocationChicklets( currentlocation , pastLocations);
        console.log(chicklet);
        chicklets.push(chicklet);

      const section = new LocationSection('sectionId', this.token.getEmail(), 'add', chicklets);
      this.locationService.addLocationDetails(section).subscribe(
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
