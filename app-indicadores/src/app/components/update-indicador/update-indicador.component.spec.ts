import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateIndicadorComponent } from './update-indicador.component';

describe('UpdateIndicadorComponent', () => {
  let component: UpdateIndicadorComponent;
  let fixture: ComponentFixture<UpdateIndicadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateIndicadorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateIndicadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
