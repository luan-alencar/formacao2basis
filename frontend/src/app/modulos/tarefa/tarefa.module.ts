import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TarefaRoutingModule } from './tarefa-routing.module';
import { TarefaFormularioComponent } from './tarefa-formulario/tarefa-formulario.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { TarefaService } from './service/tarefa.service';
import { TarefaListagemComponent } from './tarefa-listagem/tarefa-listagem.component';
import { TableModule } from 'primeng/table';



@NgModule({
  declarations: [TarefaFormularioComponent, TarefaListagemComponent],
  imports: [
    CommonModule,
    TarefaRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    HttpClientModule,
    TableModule

  ],
  providers: [
    TarefaService
  ]
})
export class TarefaModule { }
