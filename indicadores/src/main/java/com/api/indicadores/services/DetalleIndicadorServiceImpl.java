/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.services;

import com.api.indicadores.db.repository.IDetalleIndicadorRepository;
import com.api.indicadores.dto.HistorialIndicadorDto;
import com.api.indicadores.mapper.DetalleIndicadorMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class DetalleIndicadorServiceImpl implements IDetalleIndicadorService {

    @Autowired
    private IDetalleIndicadorRepository detalleIndicadorRepository;

    @Override
    public ResponseEntity<?> list(Integer id) throws Exception {
        List<HistorialIndicadorDto> list = new ArrayList();
        try {
            list = getDetalleIndicadorRepository().consultarDetalleIndicador(id)
                    .stream()
                    .map(obj -> DetalleIndicadorMapper.to(obj))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(list);
    }

}
