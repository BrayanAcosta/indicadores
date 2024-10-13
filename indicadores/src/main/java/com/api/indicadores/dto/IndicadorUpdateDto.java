/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
public class IndicadorUpdateDto extends IndicadorDto{
    
    private String descripcion;
    private String fecha;
    
    public IndicadorUpdateDto(){
        super();
    }
}
