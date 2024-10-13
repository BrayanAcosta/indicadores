import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { IndicadorController } from '../../controller/indicador-controller';
import { Indicador } from '../../model/indicador';

@Component({
  selector: 'app-update-indicador',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './update-indicador.component.html',
  styleUrl: './update-indicador.component.css'
})
export class UpdateIndicadorComponent {

  myForm: FormGroup;
  readonly dialogRef = inject(MatDialogRef<UpdateIndicadorComponent>);
  readonly data = inject<Indicador>(MAT_DIALOG_DATA);


  constructor(
    private fb: FormBuilder,
    private indicadorController:IndicadorController
  ) {
    this.myForm = this.fb.group({
      valorEspe: [this.data.indValorEsperado || "", [Validators.required,Validators.maxLength(10)]],
      valorMini: [this.data.indValorMinimo, [Validators.required,Validators.maxLength(10)]],
      valorMax: [this.data.indValorMaximo, [Validators.required,Validators.maxLength(10)]],
      valorMed: [this.data.indValorMedida, [Validators.required,Validators.maxLength(10)]],
      fecha: ['', Validators.required],
      descr: ["", [Validators.required,Validators.maxLength(200)]]
    });
  }

  onSubmit(){
    this.indicadorController.actualizar(this);
  }

  close(){
    this.dialogRef.close();
  }


}
