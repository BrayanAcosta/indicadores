
package com.api.indicadores.db.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
@Entity
@Table(name = "reg_detalle_indicador")
public class RegDetalleIndicador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DET_IND_ID")
    private Integer detIndId;
    @Column(name = "DET_VALOR_ESPERADO")
    private Long detValorEsperado;
    @Column(name = "DET_VALOR_MINIMO")
    private Long detValorMinimo;
    @Column(name = "DET_VALOR_MAXIMO")
    private Long detValorMaximo;
    @Column(name = "DET_VALOR_MEDIDA")
    private Long detValorMedida;
    @Column(name = "DET_FECHA")
    @Temporal(TemporalType.DATE)
    private Date detFecha;
    @Column(name = "DET_DESCRIPCION")
    private String detDescripcion;
    @JoinColumn(name = "IND_ID", referencedColumnName = "IND_ID")
    @ManyToOne
    private RegIndicadores indId;

    public RegDetalleIndicador() {
    }

    public RegDetalleIndicador(Integer detIndId) {
        this.detIndId = detIndId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detIndId != null ? detIndId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegDetalleIndicador)) {
            return false;
        }
        RegDetalleIndicador other = (RegDetalleIndicador) object;
        if ((this.detIndId == null && other.detIndId != null) || (this.detIndId != null && !this.detIndId.equals(other.detIndId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.indicadores.db.model.RegDetalleIndicador[ detIndId=" + detIndId + " ]";
    }
    
}
