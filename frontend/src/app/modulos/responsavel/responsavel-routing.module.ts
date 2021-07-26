import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResponsavelFormComponent } from './responsavel-form/responsavel-form.component';
import { ResponsavelListComponent } from './responsavel-list/responsavel-list.component';


const routes: Routes = [
  {
    path: '',
    component: ResponsavelListComponent
  },
  {
    path:'formulario',
    component: ResponsavelFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResponsavelRoutingModule { }
