/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b"),
    @NamedQuery(name = "Boleta.findByIdboleta", query = "SELECT b FROM Boleta b WHERE b.idboleta = :idboleta")})
public class Boleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idboleta")
    private Integer idboleta;
    @JoinTable(name = "compras", joinColumns = {
        @JoinColumn(name = "boleta", referencedColumnName = "idboleta")}, inverseJoinColumns = {
        @JoinColumn(name = "transaccion", referencedColumnName = "idtransaccion")})
    @ManyToMany
    private Collection<Transaccion> transaccionCollection;
    @JoinColumn(name = "estadoboleta", referencedColumnName = "idestadoboleta")
    @ManyToOne(optional = false)
    private EstadoBoleta estadoboleta;
    @JoinColumn(name = "funcion", referencedColumnName = "idfuncion")
    @ManyToOne(optional = false)
    private Funcion funcion;
    @JoinColumn(name = "silla", referencedColumnName = "idsilla")
    @ManyToOne(optional = false)
    private Silla silla;
    @JoinColumn(name = "socio", referencedColumnName = "idsocio")
    @ManyToOne
    private Socio socio;

    public Boleta() {
    }

    public Boleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    public EstadoBoleta getEstadoboleta() {
        return estadoboleta;
    }

    public void setEstadoboleta(EstadoBoleta estadoboleta) {
        this.estadoboleta = estadoboleta;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idboleta != null ? idboleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idboleta == null && other.idboleta != null) || (this.idboleta != null && !this.idboleta.equals(other.idboleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // Cambio el retorno del toString
        return "Boleta Nro. " + getIdboleta();
    }
    
}
