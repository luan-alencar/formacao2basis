import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { ResponsavelModule } from './modulos/responsavel/responsavel.module';
import { TarefaModule } from './modulos/tarefa/tarefa.module';
import { AnexoModule } from './modulos/anexo/anexo.module';

const routes: Routes = [
  { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros' } },
  { path: 'login-success', component: LoginSuccessComponent },

  {
    path: 'responsaveis',
    loadChildren: () => ResponsavelModule
  },

  {
    path: 'tarefas',
    loadChildren: () => TarefaModule
  },

  {
    path: 'anexos',
    loadChildren: () => AnexoModule
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
