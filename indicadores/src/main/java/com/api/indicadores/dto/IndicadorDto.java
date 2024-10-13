/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.dto;

import jakarta.persistence.Column;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
public class IndicadorDto implements Serializable{
    
    private Integer indId;
    private String indNombre;
    private Long indValorEsperado;
    private Long indValorMinimo;
    private Long indValorMaximo;
    private Long indValorMedida;

    public IndicadorDto() {
    }

    public IndicadorDto(Integer indId) {
        this.indId = indId;
    }
    
}
