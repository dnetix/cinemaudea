/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "tarifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t"),
    @NamedQuery(name = "Tarifa.findByIdtarifa", query = "SELECT t FROM Tarifa t WHERE t.idtarifa = :idtarifa"),
    @NamedQuery(name = "Tarifa.findByContarjeta", query = "SELECT t FROM Tarifa t WHERE t.contarjeta = :contarjeta"),
    @NamedQuery(name = "Tarifa.findBySintarjeta", query = "SELECT t FROM Tarifa t WHERE t.sintarjeta = :sintarjeta"),
    @NamedQuery(name = "Tarifa.findByPuntos", query = "SELECT t FROM Tarifa t WHERE t.puntos = :puntos")})
public class Tarifa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtarifa")
    private Integer idtarifa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "contarjeta")
    private Float contarjeta;
    @Column(name = "sintarjeta")
    private Float sintarjeta;
    @Column(name = "puntos")
    private Integer puntos;
    @JoinColumn(name = "formato", referencedColumnName = "idformato")
    @ManyToOne(optional = false)
    private Formato formato;
    @JoinColumn(name = "localidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad localidad;

    public Tarifa() {
    }

    public Tarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Integer getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Float getContarjeta() {
        return contarjeta;
    }

    public void setContarjeta(Float contarjeta) {
        this.contarjeta = contarjeta;
    }

    public Float getSintarjeta() {
        return sintarjeta;
    }

    public void setSintarjeta(Float sintarjeta) {
        this.sintarjeta = sintarjeta;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarifa != null ? idtarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.idtarifa == null && other.idtarifa != null) || (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Tarifa[ idtarifa=" + idtarifa + " ]";
    }
    
}
