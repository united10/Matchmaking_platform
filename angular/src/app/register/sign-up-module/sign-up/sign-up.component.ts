import { Component, OnInit } from '@angular/core';
import { RegisterModel } from 'src/app/register/models/register.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegisterService } from 'src/app/register/services/register.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user: RegisterModel = new RegisterModel();
  registerForm: FormGroup;
  hide = true;
  submitted = false;
  errorMsg = '';

  constructor(
    private formBuilder: FormBuilder,
    private _registerService: RegisterService
  ) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: [this.user.name, [Validators.required]],
      email: [this.user.email, [Validators.required, Validators.email]],
      password: [
        this.user.password,
        [Validators.required, Validators.minLength(6), Validators.maxLength(30)]
      ]
    });
  }

  onRegisterSubmit() {
    this.submitted = true;
    console.log(this.registerForm.value);
    this._registerService.submit(this.registerForm.value).subscribe();
  }
}
