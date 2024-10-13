import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewIndicadorComponent } from './view-indicador.component';

describe('ViewIndicadorComponent', () => {
  let component: ViewIndicadorComponent;
  let fixture: ComponentFixture<ViewIndicadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewIndicadorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewIndicadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
