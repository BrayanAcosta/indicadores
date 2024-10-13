import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Header } from '../util/header';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DetalleIndicadorService {

  private header: Header = new Header();
  constructor() { }

  get(http: HttpClient,id:any): Observable<HttpResponse<any>> {
    return http.get(this.header.url.concat("detalleIndicador/list/").concat(id), {
      headers: this.header.headers,
      observe: 'response'
    });
  }
}
