import { TestBed } from '@angular/core/testing';

import { DetalleIndicadorService } from './detalle-indicador.service';

describe('DetalleIndicadorService', () => {
  let service: DetalleIndicadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetalleIndicadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
