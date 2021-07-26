import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnexoFormularioComponent } from './anexo-formulario/anexo-formulario.component';
import { AnexoListagemComponent } from './anexo-listagem/anexo-listagem.component';


const routes: Routes = [

  {
    path: '',
    component: AnexoListagemComponent
  },
  {
    path: 'formulario',
    component: AnexoFormularioComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AnexoRoutingModule { }
