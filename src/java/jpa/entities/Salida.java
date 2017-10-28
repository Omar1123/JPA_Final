/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jake
 */
@Entity
@Table(name = "Salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s")
    , @NamedQuery(name = "Salida.findBySalidaId", query = "SELECT s FROM Salida s WHERE s.salidaId = :salidaId")
    , @NamedQuery(name = "Salida.findByObservaciones", query = "SELECT s FROM Salida s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "Salida.findByHoraSalida", query = "SELECT s FROM Salida s WHERE s.horaSalida = :horaSalida")
    , @NamedQuery(name = "Salida.findByFechaSalida", query = "SELECT s FROM Salida s WHERE s.fechaSalida = :fechaSalida")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "salida_id")
    private Integer salidaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "hora_salida")
    private String horaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "fecha_salida")
    private String fechaSalida;
    @JoinColumn(name = "id_entrada", referencedColumnName = "entrada_id")
    @ManyToOne(optional = false)
    private Entrada idEntrada;

    public Salida() {
    }

    public Salida(Integer salidaId) {
        this.salidaId = salidaId;
    }

    public Salida(Integer salidaId, String observaciones, String horaSalida, String fechaSalida) {
        this.salidaId = salidaId;
        this.observaciones = observaciones;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
    }

    public Integer getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(Integer salidaId) {
        this.salidaId = salidaId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Entrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salidaId != null ? salidaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.salidaId == null && other.salidaId != null) || (this.salidaId != null && !this.salidaId.equals(other.salidaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Salida[ salidaId=" + salidaId + " ]";
    }
    
}
