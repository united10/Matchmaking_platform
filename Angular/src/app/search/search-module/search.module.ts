import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search/search.component';
import { MaterialModule } from 'src/app/login/login-module/material.module';
import { BrowserModule } from '@angular/platform-browser';
import { SpeechModule } from '../lib';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    BrowserModule,
    SpeechModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: 'SPEECH_LANG', useValue: 'en-US' }
  ],
  declarations: [SearchComponent]
})
export class SearchModule { }
