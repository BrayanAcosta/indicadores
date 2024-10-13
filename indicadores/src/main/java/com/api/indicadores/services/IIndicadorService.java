/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.indicadores.services;


import com.api.indicadores.dto.IndicadorDto;
import com.api.indicadores.dto.IndicadorUpdateDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Brayan
 */
public interface IIndicadorService {
    
    ResponseEntity<?> listar() throws Exception;
    
    ResponseEntity<?> save(IndicadorDto indicadorDto) throws Exception;
    
    ResponseEntity<?> update(IndicadorUpdateDto indicadorUpdateDto) throws Exception;
    
    
}
