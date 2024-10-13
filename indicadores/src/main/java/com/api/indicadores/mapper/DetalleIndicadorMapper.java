/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.mapper;

import com.api.indicadores.db.model.RegDetalleIndicador;
import com.api.indicadores.dto.DetalleIndicadorDto;
import com.api.indicadores.dto.HistorialIndicadorDto;
import com.api.indicadores.util.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brayan
 */
public class DetalleIndicadorMapper {

    public static RegDetalleIndicador to(DetalleIndicadorDto detalleIndicadorDto) {
        RegDetalleIndicador detalleIndicador = new RegDetalleIndicador();
        detalleIndicador.setDetIndId(detalleIndicadorDto.getDetIndId());
        detalleIndicador.setIndId(IndicadorMapper.to(detalleIndicadorDto.getIndId()));
        detalleIndicador.setDetValorEsperado(detalleIndicadorDto.getDetValorEsperado());
        detalleIndicador.setDetValorMinimo(detalleIndicadorDto.getDetValorMinimo());
        detalleIndicador.setDetValorMaximo(detalleIndicadorDto.getDetValorMaximo());
        detalleIndicador.setDetValorMedida(detalleIndicadorDto.getDetValorMedida());
        detalleIndicador.setDetFecha(detalleIndicadorDto.getDetFecha());
        detalleIndicador.setDetDescripcion(detalleIndicadorDto.getDetDescripcion());
        return detalleIndicador;
    }

    public static DetalleIndicadorDto to(RegDetalleIndicador detalleIndicador) {
        DetalleIndicadorDto detalleIndicadorDto = new DetalleIndicadorDto();
        detalleIndicadorDto.setDetIndId(detalleIndicador.getDetIndId());
        detalleIndicadorDto.setIndId(IndicadorMapper.to(detalleIndicador.getIndId()));
        detalleIndicadorDto.setDetValorEsperado(detalleIndicador.getDetValorEsperado());
        detalleIndicadorDto.setDetValorMinimo(detalleIndicador.getDetValorMinimo());
        detalleIndicadorDto.setDetValorMaximo(detalleIndicador.getDetValorMaximo());
        detalleIndicadorDto.setDetValorMedida(detalleIndicador.getDetValorMedida());
        detalleIndicadorDto.setDetFecha(detalleIndicador.getDetFecha());
        detalleIndicadorDto.setDetDescripcion(detalleIndicador.getDetDescripcion());
        return detalleIndicadorDto;
    }

    public static HistorialIndicadorDto to(Map<String, Object> historia) {
        HistorialIndicadorDto historialIndicadorDto = new HistorialIndicadorDto();
        historialIndicadorDto.setNombre(historia.get("IND_NOMBRE").toString());
        historialIndicadorDto.setValor_esperado(String.valueOf(historia.get("DET_VALOR_ESPERADO")));
        historialIndicadorDto.setValor_minimo(String.valueOf(historia.get("DET_VALOR_MINIMO")));
        historialIndicadorDto.setValor_maximo(String.valueOf(historia.get("DET_VALOR_MAXIMO")));
        historialIndicadorDto.setValor_medida(String.valueOf(historia.get("DET_VALOR_MEDIDA")));
       
        historialIndicadorDto.setFecha(String.valueOf(historia.get("DET_FECHA")));
        historialIndicadorDto.setDescripcion(String.valueOf(historia.get("DET_DESCRIPCION")));
        historialIndicadorDto.setColor(String.valueOf(historia.get("COLOR")));
        return historialIndicadorDto;
    }

}
