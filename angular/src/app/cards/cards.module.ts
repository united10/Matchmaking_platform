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
import { ProjectdialogComponent } from './projectdialog/projectdialog.component';

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

  declarations: [CardComponent,
                  DetailsdialogComponent,
                  EducationdialogComponent,
                  ExperienceComponent,
                  SkillComponent,
                  CertificatedialogComponent,
                  LocationdialogComponent,
                  ProjectdialogComponent],
  entryComponents: [DetailsdialogComponent,
                    EducationdialogComponent,
                    SkillComponent,
                    CertificatedialogComponent,

                    LocationdialogComponent,
                    ProjectdialogComponent],
  exports: [CardComponent]
})
export class CardsModule { }
