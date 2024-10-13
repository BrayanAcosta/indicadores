import { Component, inject, OnInit } from '@angular/core';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { IndicadorController } from '../../controller/indicador-controller';

@Component({
  selector: 'app-add-indicador',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './add-indicador.component.html',
  styleUrl: './add-indicador.component.css'
})
export class AddIndicadorComponent implements OnInit{

  myForm: FormGroup;
  readonly dialogRef = inject(MatDialogRef<AddIndicadorComponent>);

  constructor(
    private fb: FormBuilder,
    private indicadorController:IndicadorController
  ) {
    this.myForm = this.fb.group({
      nombre: ['', [Validators.required,Validators.maxLength(100)]],
      valorEspe: ['', [Validators.required,Validators.maxLength(10)]],
      valorMini: ['', [Validators.required,Validators.maxLength(10)]],
      valorMax: ['', [Validators.required,Validators.maxLength(10)]],
    });
  }
  ngOnInit(): void {
    
  }

  onSubmit(){
    this.indicadorController.agregar(this);
  }

  close(){
    this.dialogRef.close();
  }

}
