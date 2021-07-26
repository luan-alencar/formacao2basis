import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AnexoRoutingModule } from './anexo-routing.module';
import { AnexoFormularioComponent } from './anexo-formulario/anexo-formulario.component';
import { AnexoListagemComponent } from './anexo-listagem/anexo-listagem.component';


@NgModule({
  declarations: [AnexoListagemComponent, AnexoFormularioComponent],
  imports: [
    CommonModule,
    AnexoRoutingModule
  ]
})
export class AnexoModule { }
