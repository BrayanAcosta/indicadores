/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.controller;

import com.api.indicadores.dto.IndicadorDto;
import com.api.indicadores.dto.IndicadorUpdateDto;
import com.api.indicadores.services.IIndicadorService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/v1/api/indicador")
public class IndicadorController {
    
    @Autowired
    private IIndicadorService indicadorService;
    
    /**
     * 
     * @return listado de indicadores
     * @throws Exception 
     */
    @GetMapping("/list")
    public ResponseEntity<?> list() throws Exception{
       return getIndicadorService().listar();
    }
    
    /**
     * 
     * @param indicadorDto indicador a ingresar
     * @return devuelve codigo de respuesta de la solicitud
     * @throws Exception 
     */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody IndicadorDto indicadorDto) throws Exception{
        return getIndicadorService().save(indicadorDto);
    }
    
    /**
     * 
     * @param indicadorUpdateDto indicador a actualizar
     * @return devuelve codigo de respuesta de la peticion
     * @throws Exception 
     */
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody IndicadorUpdateDto indicadorUpdateDto) throws Exception{
        return getIndicadorService().update(indicadorUpdateDto);
    }
}
