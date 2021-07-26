import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResponsavelRoutingModule } from './responsavel-routing.module';
import { ResponsavelListComponent } from './responsavel-list/responsavel-list.component';
import { ResponsavelFormComponent } from './responsavel-form/responsavel-form.component';
import { ResponsavelService } from './service/responsavel.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [ResponsavelListComponent, ResponsavelFormComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    ResponsavelRoutingModule,
    SharedModule,
    HttpClientModule
  ],
  providers: [
    ResponsavelService
  ]
})
export class ResponsavelModule { }
