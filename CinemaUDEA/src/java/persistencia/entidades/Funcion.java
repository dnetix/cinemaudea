/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

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
@Table(name = "funcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByIdfuncion", query = "SELECT f FROM Funcion f WHERE f.idfuncion = :idfuncion"),
    @NamedQuery(name = "Funcion.findByFecha", query = "SELECT f FROM Funcion f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Funcion.findByInicio", query = "SELECT f FROM Funcion f WHERE f.inicio = :inicio"),
    @NamedQuery(name = "Funcion.findByFin", query = "SELECT f FROM Funcion f WHERE f.fin = :fin")})
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncion")
    private Integer idfuncion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIME)
    private Date inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin")
    @Temporal(TemporalType.TIME)
    private Date fin;
    @JoinColumn(name = "cartelera", referencedColumnName = "idcartelera")
    @ManyToOne(optional = false)
    private Cartelera cartelera;
    @JoinColumn(name = "sala", referencedColumnName = "idsala")
    @ManyToOne(optional = false)
    private Sala sala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcion")
    private Collection<Boleta> boletaCollection;

    public Funcion() {
    }

    public Funcion(Integer idfuncion) {
        this.idfuncion = idfuncion;
    }

    public Funcion(Integer idfuncion, Date fecha, Date inicio, Date fin) {
        this.idfuncion = idfuncion;
        this.fecha = fecha;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Integer getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(Integer idfuncion) {
        this.idfuncion = idfuncion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @XmlTransient
    public Collection<Boleta> getBoletaCollection() {
        return boletaCollection;
    }

    public void setBoletaCollection(Collection<Boleta> boletaCollection) {
        this.boletaCollection = boletaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncion != null ? idfuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.idfuncion == null && other.idfuncion != null) || (this.idfuncion != null && !this.idfuncion.equals(other.idfuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Funcion[ idfuncion=" + idfuncion + " ]";
    }
    
}
