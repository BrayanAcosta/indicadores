import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Header } from '../util/header';

@Injectable({
  providedIn: 'root',
})
export class IndicadorService {

  private header: Header = new Header();
  constructor() { }

  get(http: HttpClient): Observable<HttpResponse<any>> {
    return http.get(this.header.url.concat("indicador/list"), {
      headers: this.header.headers,
      observe: 'response'
    });
  }

  save(http: HttpClient, body: any): Observable<HttpResponse<any>> {
    return http.post(this.header.url.concat("indicador/save"),
      body,
      {
        headers: this.header.headers,
        observe: 'response'
      }
    )
  }

  update(http: HttpClient, body: any): Observable<HttpResponse<any>> {
    return http.put(this.header.url.concat("indicador/update"),
      body,
      {
        headers: this.header.headers,
        observe: 'response'
      }
    )
  }

}
