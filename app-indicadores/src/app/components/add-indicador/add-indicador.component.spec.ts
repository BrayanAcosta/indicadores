import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIndicadorComponent } from './add-indicador.component';

describe('AddIndicadorComponent', () => {
  let component: AddIndicadorComponent;
  let fixture: ComponentFixture<AddIndicadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddIndicadorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddIndicadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
