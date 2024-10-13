/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
public class HistorialIndicadorDto {
    
    private String nombre;
    private String valor_esperado;
    private String valor_minimo;
    private String valor_maximo;
    private String valor_medida;
    private String fecha;
    private String descripcion;
    private String color;
    
}
