/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.indicadores.services;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author Brayan
 */
public interface IDetalleIndicadorService {
    
    ResponseEntity<?> list(Integer id) throws Exception;
    
}
