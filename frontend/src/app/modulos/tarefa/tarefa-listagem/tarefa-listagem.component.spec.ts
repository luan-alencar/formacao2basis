import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TarefaListagemComponent } from './tarefa-listagem.component';

describe('TarefaListagemComponent', () => {
  let component: TarefaListagemComponent;
  let fixture: ComponentFixture<TarefaListagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TarefaListagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TarefaListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
