import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResponsavelRoutingModule } from './responsavel-routing.module';
import { ResponsavelListComponent } from './responsavel-list/responsavel-list.component';
import { ResponsavelFormComponent } from './responsavel-form/responsavel-form.component';


@NgModule({
  declarations: [ResponsavelListComponent, ResponsavelFormComponent],
  imports: [
    CommonModule,
    ResponsavelRoutingModule
  ]
})
export class ResponsavelModule { }
