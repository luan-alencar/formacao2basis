import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TarefaRoutingModule } from './tarefa-routing.module';
import { TarefaFormularioComponent } from './tarefa-formulario/tarefa-formulario.component';


@NgModule({
  declarations: [TarefaFormularioComponent],
  imports: [
    CommonModule,
    TarefaRoutingModule
  ]
})
export class TarefaModule { }
