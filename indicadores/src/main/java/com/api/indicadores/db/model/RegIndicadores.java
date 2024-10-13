/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.db.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
@Entity
@Table(name = "reg_indicadores")
public class RegIndicadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IND_ID")
    private Integer indId;
    @Column(name = "IND_NOMBRE")
    private String indNombre;
    @Column(name = "IND_VALOR_ESPERADO")
    private Long indValorEsperado;
    @Column(name = "IND_VALOR_MINIMO")
    private Long indValorMinimo;
    @Column(name = "IND_VALOR_MAXIMO")
    private Long indValorMaximo;
    @Column(name = "IND_VALOR_MEDIDA")
    private Long indValorMedida;
    
    public RegIndicadores() {
    }

    public RegIndicadores(Integer indId) {
        this.indId = indId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indId != null ? indId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegIndicadores)) {
            return false;
        }
        RegIndicadores other = (RegIndicadores) object;
        if ((this.indId == null && other.indId != null) || (this.indId != null && !this.indId.equals(other.indId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.indicadores.db.model.RegIndicadores[ indId=" + indId + " ]";
    }
    
}
