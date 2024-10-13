/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.indicadores.db.repository;

import com.api.indicadores.db.model.RegIndicadores;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Brayan
 */
public interface IIndicadorRepository extends JpaRepository<RegIndicadores, Integer>{
    
    @Query(value = "select ind.* from reg_indicadores ind where ind.IND_NOMBRE = :nam", nativeQuery = true)
    Optional<RegIndicadores> consultarByNombre(@Param("nam") String nombre) throws Exception;
    
}
