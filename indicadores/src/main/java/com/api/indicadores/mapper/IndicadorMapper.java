/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.mapper;

import com.api.indicadores.db.model.RegIndicadores;
import com.api.indicadores.dto.IndicadorDto;

/**
 *
 * @author Brayan
 */
public class IndicadorMapper {
    
    public static RegIndicadores to(IndicadorDto indicadorDto){
        RegIndicadores indicadores = new RegIndicadores();
        indicadores.setIndId(indicadorDto.getIndId());
        indicadores.setIndNombre(indicadorDto.getIndNombre());
        indicadores.setIndValorEsperado(indicadorDto.getIndValorEsperado());
        indicadores.setIndValorMinimo(indicadorDto.getIndValorMinimo());
        indicadores.setIndValorMaximo(indicadorDto.getIndValorMaximo());
        indicadores.setIndValorMedida(indicadorDto.getIndValorMedida());
        return indicadores;
    }
    
    public static IndicadorDto to(RegIndicadores indicadores){
        IndicadorDto indicadorDto = new IndicadorDto();
        indicadorDto.setIndId(indicadores.getIndId());
        indicadorDto.setIndNombre(indicadores.getIndNombre());
        indicadorDto.setIndValorEsperado(indicadores.getIndValorEsperado());
        indicadorDto.setIndValorMinimo(indicadores.getIndValorMinimo());
        indicadorDto.setIndValorMaximo(indicadores.getIndValorMaximo());
        indicadorDto.setIndValorMedida(indicadores.getIndValorMedida());
        return indicadorDto;
    }
    
}
