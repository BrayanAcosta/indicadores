/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.services;

import com.api.indicadores.db.model.RegDetalleIndicador;
import com.api.indicadores.db.model.RegIndicadores;
import com.api.indicadores.db.repository.IDetalleIndicadorRepository;
import com.api.indicadores.db.repository.IIndicadorRepository;
import com.api.indicadores.dto.IndicadorDto;
import com.api.indicadores.dto.IndicadorUpdateDto;
import com.api.indicadores.mapper.IndicadorMapper;
import com.api.indicadores.util.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class IndicadorServiceImpl implements IIndicadorService {

    @Autowired
    private IIndicadorRepository indicadorRepositorio;
    @Autowired
    private IDetalleIndicadorRepository detalleIndicadorRepository;
    
    /**
     * 
     * @return {lista} listado de indices
     * @throws Exception 
     */
    
    @Override
    public ResponseEntity<?> listar() throws Exception {
        List<IndicadorDto> lista = getIndicadorRepositorio().findAll()
                .stream()
                .map(obj -> IndicadorMapper.to(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    /**
     * 
     * @param indicadorDto indicador a registrar
     * @return ResponseEntity encargada del codigo de estado respuesta http
     * @throws Exception 
     */
    
    @Override
    public ResponseEntity<?> save(IndicadorDto indicadorDto) throws Exception {
        Map<String, String> response = new HashMap();

        //Mapeo de clase dto a entidad db
        RegIndicadores indicadores = IndicadorMapper.to(indicadorDto);
        indicadores.setIndNombre(indicadores.getIndNombre().toUpperCase());

        //consultar indicador existente
        Optional<RegIndicadores> indicadoreName = getIndicadorRepositorio().consultarByNombre(indicadores.getIndNombre());
        if (indicadoreName.isPresent()) {
            response.put("msg", "El Indicador ya se registro anteriormente");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        //ingresar indicador
        getIndicadorRepositorio().save(indicadores);
        return ResponseEntity.ok(indicadores);
    }

    /**
     * 
     * @param indicadorUpdateDto indice actualizar
     * @return ResponseEntity encargada del codigo de estado respuesta http
     * @throws Exception 
     */
    
    @Override
    public ResponseEntity<?> update(IndicadorUpdateDto indicadorUpdateDto) throws Exception {
        Map<String, String> response = new HashMap();

        //mapeo de clase dto a entidad db
        IndicadorDto indicadorDtoRequest = indicadorUpdateDto;
        RegIndicadores indicadores = IndicadorMapper.to(indicadorDtoRequest);

        //consultar existencia de indicador a actualizar
        Optional<RegIndicadores> indicador = getIndicadorRepositorio().findById(indicadores.getIndId());
        if (!indicador.isPresent()) {
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        //verificar cambios sufridos en los datos
        RegIndicadores indicadorUpdate = indicador.get();
        if (comparar(indicadores, indicadorUpdate)) {
            indicadorUpdate.setIndValorEsperado(indicadores.getIndValorEsperado());
            indicadorUpdate.setIndValorMinimo(indicadores.getIndValorMinimo());
            indicadorUpdate.setIndValorMaximo(indicadores.getIndValorMaximo());
            indicadorUpdate.setIndValorMedida(indicadores.getIndValorMedida());
        
            //actualizar e ingresar historial de indicador
            getIndicadorRepositorio().save(indicadorUpdate);
            registrarHistorial(indicadorUpdateDto);
            
        }

        return ResponseEntity.ok(response);
    }
    
    /**
     * 
     * @param indicadores indicador que se agregara un registro de cambio
     * @throws Exception 
     */
    private void registrarHistorial(IndicadorUpdateDto indicadores) throws Exception{
        RegDetalleIndicador detalleIndicador = new RegDetalleIndicador();
        detalleIndicador.setIndId(IndicadorMapper.to(indicadores));
        detalleIndicador.setDetValorEsperado(indicadores.getIndValorEsperado());
        detalleIndicador.setDetValorMinimo(indicadores.getIndValorMinimo());
        detalleIndicador.setDetValorMaximo(indicadores.getIndValorMaximo());
        detalleIndicador.setDetValorMedida(indicadores.getIndValorMedida());
        
        Date fecha = new DateFormat("yyyy-MM-dd").formatDate(indicadores.getFecha());
        
        detalleIndicador.setDetFecha(fecha);
        detalleIndicador.setDetDescripcion(indicadores.getDescripcion());
        getDetalleIndicadorRepository().save(detalleIndicador);
    }

    /**
     * 
     * @param indicadores indicador principal a comparar
     * @param indicadores1 segundo indicador a comparar
     * @return boolean
     * @throws Exception 
     */
    private boolean comparar(RegIndicadores indicadores, RegIndicadores indicadores1) throws Exception {
        boolean equals = false;

        if (indicadores.getIndValorEsperado() != indicadores1.getIndValorEsperado()) {
            equals = true;
        }

        if (indicadores.getIndValorMinimo() != indicadores1.getIndValorMinimo()) {
            equals = true;
        }

        if (indicadores.getIndValorMaximo() != indicadores1.getIndValorMaximo()) {
            equals = true;
        }

        if (indicadores.getIndValorMedida() != indicadores1.getIndValorMedida()) {
            equals = true;
        }
        return equals;
    }

}
