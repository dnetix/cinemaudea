/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cinemaudea.fsi.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "cartelera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartelera.findAll", query = "SELECT c FROM Cartelera c"),
    @NamedQuery(name = "Cartelera.findByIdcartelera", query = "SELECT c FROM Cartelera c WHERE c.idcartelera = :idcartelera"),
    @NamedQuery(name = "Cartelera.findByFechainicio", query = "SELECT c FROM Cartelera c WHERE c.fechainicio = :fechainicio"),
    @NamedQuery(name = "Cartelera.findByFechafin", query = "SELECT c FROM Cartelera c WHERE c.fechafin = :fechafin")})
public class Cartelera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcartelera")
    private Integer idcartelera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartelera")
    private Collection<Funcion> funcionCollection;
    @JoinColumn(name = "formatopelicula", referencedColumnName = "formatopelicula")
    @ManyToOne(optional = false)
    private FormatoPelicula formatopelicula;

    public Cartelera() {
    }

    public Cartelera(Integer idcartelera) {
        this.idcartelera = idcartelera;
    }

    public Cartelera(Integer idcartelera, Date fechainicio, Date fechafin) {
        this.idcartelera = idcartelera;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getIdcartelera() {
        return idcartelera;
    }

    public void setIdcartelera(Integer idcartelera) {
        this.idcartelera = idcartelera;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public Collection<Funcion> getFuncionCollection() {
        return funcionCollection;
    }

    public void setFuncionCollection(Collection<Funcion> funcionCollection) {
        this.funcionCollection = funcionCollection;
    }

    public FormatoPelicula getFormatopelicula() {
        return formatopelicula;
    }

    public void setFormatopelicula(FormatoPelicula formatopelicula) {
        this.formatopelicula = formatopelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcartelera != null ? idcartelera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartelera)) {
            return false;
        }
        Cartelera other = (Cartelera) object;
        if ((this.idcartelera == null && other.idcartelera != null) || (this.idcartelera != null && !this.idcartelera.equals(other.idcartelera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getFormatopelicula().getPelicula().getNombre() + " " + getFormatopelicula().getFormato().getFormato();
    }
    
}
