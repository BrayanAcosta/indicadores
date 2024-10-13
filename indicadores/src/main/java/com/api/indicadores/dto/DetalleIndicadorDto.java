/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
public class DetalleIndicadorDto implements Serializable{
   
    private Integer detIndId;
    private Long detValorEsperado;
    private Long detValorMinimo;
    private Long detValorMaximo;
    private Long detValorMedida;
    private Date detFecha;
    private String detDescripcion;
    private IndicadorDto indId;

    public DetalleIndicadorDto() {
    }

    public DetalleIndicadorDto(Integer detIndId) {
        this.detIndId = detIndId;
    }
   
}
