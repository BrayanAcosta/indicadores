import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { Indicador } from '../../model/indicador';
import { IndicadorController } from '../../controller/indicador-controller';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { AddIndicadorComponent } from '../../components/add-indicador/add-indicador.component';
import { Historial } from '../../model/historial';
import { UpdateIndicadorComponent } from '../../components/update-indicador/update-indicador.component';

@Component({
  selector: 'app-view-indicador',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
    MatDialogModule
  ],
  templateUrl: './view-indicador.component.html',
  styleUrl: './view-indicador.component.css',
})
export class ViewIndicadorComponent implements OnInit {

  listaIdicadores: Indicador[] = [];
  listadoHistorial: Historial[] = [];

  readonly dialog = inject(MatDialog);
  idIndicador: number = 0;
  indicador: Indicador = new Indicador();

  isVisible = false;


  constructor(private indicadorController: IndicadorController) {

  }

  ngOnInit(): void {
    this.indicadorController.init(this);
  }

  openDialog() {
    const dialogRef = this.dialog.open(AddIndicadorComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result == "ok") {
        this.indicadorController.listarIndicadores(this);
      }
    });
  }

  abrir(id: any) {
    this.idIndicador = id;
    this.indicadorController.historial(this);
  }

  abrirActualizar() {
    const dialogRef = this.dialog.open(UpdateIndicadorComponent,{
      data:this.indicador
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result == "ok") {
        this.indicadorController.historial(this);
      }
    });
  }

  convertToDate(dateStr: any): Date {
    const [year, month, day] = dateStr.split('-').map(Number);
    return new Date(year, month , day); 
  }

}
