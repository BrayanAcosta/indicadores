/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.indicadores.db.repository;

import com.api.indicadores.db.model.RegDetalleIndicador;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Brayan
 */
public interface IDetalleIndicadorRepository extends JpaRepository<RegDetalleIndicador, Integer> {

    @Query(value = "select his.* from consultaHistorialIndicador his where his.IND_ID = :id",nativeQuery = true)
    List<Map<String,Object>> consultarDetalleIndicador(@Param("id") Integer id) throws Exception;
    
}
