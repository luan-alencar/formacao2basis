import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TarefaFormularioComponent } from './tarefa-formulario/tarefa-formulario.component';
import { TarefaListagemComponent } from './tarefa-listagem/tarefa-listagem.component';


const routes: Routes = [

  {
    path: '',
    component: TarefaListagemComponent
  },
  {
    path: 'formulario',
    component: TarefaFormularioComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TarefaRoutingModule { }
