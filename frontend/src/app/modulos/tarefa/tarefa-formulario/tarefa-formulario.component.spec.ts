import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TarefaFormularioComponent } from './tarefa-formulario.component';

describe('TarefaFormularioComponent', () => {
  let component: TarefaFormularioComponent;
  let fixture: ComponentFixture<TarefaFormularioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TarefaFormularioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TarefaFormularioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
