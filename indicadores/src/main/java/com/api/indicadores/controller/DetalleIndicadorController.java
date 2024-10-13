/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.controller;

import com.api.indicadores.services.IDetalleIndicadorService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/v1/api/detalleIndicador")
public class DetalleIndicadorController {

    @Autowired
    private IDetalleIndicadorService detalleIndicadorService;

    /**
     *
     * @param id identidicador de indicador
     * @return devuelve una lista con el historial del indicador
     * @throws Exception
     */
    @GetMapping("/list/{indicador}")
    public ResponseEntity<?> list(@PathVariable("indicador") Integer id) throws Exception {
        return getDetalleIndicadorService().list(id);
    }

}
