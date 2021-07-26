import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsavelListComponent } from './responsavel-list.component';

describe('ResponsavelListComponent', () => {
  let component: ResponsavelListComponent;
  let fixture: ComponentFixture<ResponsavelListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResponsavelListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsavelListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
