import { Injectable } from "@angular/core";
import { IndicadorService } from "../service/indicador.service";
import { ViewIndicadorComponent } from "../pages/view-indicador/view-indicador.component";
import { HttpClient } from "@angular/common/http";
import { AddIndicadorComponent } from "../components/add-indicador/add-indicador.component";
import { Indicador } from "../model/indicador";
import { DetalleIndicadorService } from "../service/detalle-indicador.service";
import { UpdateIndicadorComponent } from "../components/update-indicador/update-indicador.component";


@Injectable({
    providedIn: 'any',
})
export class IndicadorController {

    constructor(
        private indicadorService: IndicadorService,
        private detalleIndicador: DetalleIndicadorService,
        private http: HttpClient
    ) {

    }

    init(view: ViewIndicadorComponent) {
        this.listarIndicadores(view);
    }

    listarIndicadores(view: ViewIndicadorComponent) {
        this.indicadorService.get(this.http).subscribe({
            next: (response) => {
                if (response.ok) {
                    view.listaIdicadores = response.body;
                }
            },
            error: (error) => {
                console.error('Error en la solicitud:', error);
            }
        })
    }

    agregar(view: AddIndicadorComponent) {
        let indicador = new Indicador();
        indicador.indNombre = view.myForm.get("nombre")?.value;
        indicador.indValorEsperado = view.myForm.get("valorEspe")?.value;
        indicador.indValorMinimo = view.myForm.get("valorMini")?.value;
        indicador.indValorMaximo = view.myForm.get("valorMax")?.value;

        this.indicadorService.save(this.http, indicador).subscribe({
            next: (response) => {
                if(response.ok){
                    view.dialogRef.close("ok");
                }
            },
            error: (error) => {
                console.error('Error en la solicitud:', error);
            }
        });
    }

    historial(view:ViewIndicadorComponent){
        view.indicador = view.listaIdicadores.find((a) => { return a.indId == view.idIndicador }) ||  new Indicador();
        this.detalleIndicador.get(this.http, view.idIndicador).subscribe({
            next: (response) => {
                if(response.ok){
                    view.listadoHistorial = response.body;
                    view.isVisible = true;
                }
            },
            error: (error) => {
                console.error('Error en la solicitud:', error);
                view.isVisible=false;
            }
        });
    }

    actualizar(view:UpdateIndicadorComponent){
        let indicador = view.data;
        indicador.indValorEsperado = view.myForm.get("valorEspe")?.value;
        indicador.indValorMinimo = view.myForm.get("valorMini")?.value;
        indicador.indValorMaximo = view.myForm.get("valorMax")?.value;
        indicador.indValorMedida = view.myForm.get("valorMed")?.value;
        indicador.descripcion = view.myForm.get("descr")?.value;
        indicador.fecha = view.myForm.get("fecha")?.value;

        this.indicadorService.update(this.http, indicador).subscribe({
            next: (response) => {
                if(response.ok){
                    view.dialogRef.close("ok");
                }
            },
            error: (error) => {
                console.error('Error en la solicitud:', error);
            }
        });
    }

}