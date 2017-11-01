/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jake
 */
@Entity
@Table(name = "Entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e")
    , @NamedQuery(name = "Entrada.findByEntradaId", query = "SELECT e FROM Entrada e WHERE e.entradaId = :entradaId")
    , @NamedQuery(name = "Entrada.findByNombrePersona", query = "SELECT e FROM Entrada e WHERE e.nombrePersona = :nombrePersona")
    , @NamedQuery(name = "Entrada.findByHoraEntrada", query = "SELECT e FROM Entrada e WHERE e.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Entrada.findByFechaEntrada", query = "SELECT e FROM Entrada e WHERE e.fechaEntrada = :fechaEntrada")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entrada_id")
    private Integer entradaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_persona")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hora_entrada")
    private String horaEntrada;
    @Size(max = 50)
    @Column(name = "fecha_entrada")
    private String fechaEntrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrada")
    private Collection<Salida> salidaCollection;

    public Entrada() {
    }

    public Entrada(Integer entradaId) {
        this.entradaId = entradaId;
    }

    public Entrada(Integer entradaId, String nombrePersona, String horaEntrada) {
        this.entradaId = entradaId;
        this.nombrePersona = nombrePersona;
        this.horaEntrada = horaEntrada;
    }

    public Integer getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(Integer entradaId) {
        this.entradaId = entradaId;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @XmlTransient
    public Collection<Salida> getSalidaCollection() {
        return salidaCollection;
    }

    public void setSalidaCollection(Collection<Salida> salidaCollection) {
        this.salidaCollection = salidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entradaId != null ? entradaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.entradaId == null && other.entradaId != null) || (this.entradaId != null && !this.entradaId.equals(other.entradaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Entrada[ entradaId=" + entradaId + " ]";
    }
    
}
