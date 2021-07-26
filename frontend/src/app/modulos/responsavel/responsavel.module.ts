import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResponsavelRoutingModule } from './responsavel-routing.module';
import { ResponsavelListComponent } from './responsavel-list/responsavel-list.component';
import { ResponsavelFormComponent } from './responsavel-form/responsavel-form.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
  declarations: [ResponsavelListComponent, ResponsavelFormComponent],
  imports: [
    CommonModule,
    ResponsavelRoutingModule,
    CardModule,
    ButtonModule
  ]
})
export class ResponsavelModule { }
