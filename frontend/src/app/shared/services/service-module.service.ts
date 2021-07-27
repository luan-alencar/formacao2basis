import { CommonModule } from '@angular/common';
import { Injectable, NgModule } from '@angular/core';
import { AnexoService } from 'src/app/modulos/anexo/service/anexo.service';
import { ResponsavelService } from 'src/app/modulos/responsavel/service/responsavel.service';
import { TarefaService } from 'src/app/modulos/tarefa/service/tarefa.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
      ResponsavelService,
      TarefaService,
      AnexoService
  ]
})
export class ServiceModule { }

