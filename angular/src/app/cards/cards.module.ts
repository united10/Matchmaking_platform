import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardComponent } from './card/card.component';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { DetailsdialogComponent } from './detailsdialog/detailsdialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EducationdialogComponent } from './educationdialog/educationdialog.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { ExperienceComponent } from './experience/experience.component';
import { SkillComponent } from './skill/skill.component';
import { CertificatedialogComponent } from './certificatedialog/certificatedialog.component';
import { LocationdialogComponent } from './locationdialog/locationdialog.component';

@NgModule({
  imports: [
    CommonModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
<<<<<<< HEAD
<<<<<<< HEAD
  declarations: [CardComponent, DetailsdialogComponent, EducationdialogComponent, ExperienceComponent],
  entryComponents: [DetailsdialogComponent, EducationdialogComponent, ExperienceComponent],
=======
<<<<<<< HEAD
  declarations: [CardComponent, DetailsdialogComponent, EducationdialogComponent, ExperienceComponent, SkillComponent,CertificatedialogComponent],
  entryComponents: [DetailsdialogComponent, EducationdialogComponent,SkillComponent,CertificatedialogComponent],
=======
  declarations: [CardComponent, DetailsdialogComponent, EducationdialogComponent, ExperienceComponent, CertificatedialogComponent],
  entryComponents: [DetailsdialogComponent, EducationdialogComponent, CertificatedialogComponent],
>>>>>>> 9c196e8daf33e7675773fa7bf723ce0f6a0673bd
>>>>>>> 852ac48a5695665c9008b18b404a4035b0801772
=======
  declarations: [CardComponent,
                  DetailsdialogComponent,
                  EducationdialogComponent,
                  ExperienceComponent,
                  SkillComponent,
                  CertificatedialogComponent,
                  LocationdialogComponent],
  entryComponents: [DetailsdialogComponent,
                    EducationdialogComponent,
                    SkillComponent,
                    CertificatedialogComponent,
                    LocationdialogComponent],
>>>>>>> fee8a28e90d5620b2d6014cef17cf39656d3b12a
  exports: [CardComponent]
})
export class CardsModule { }
