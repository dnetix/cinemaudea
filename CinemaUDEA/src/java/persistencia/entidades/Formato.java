/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

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
 * @author DiegoCalle
 */
@Entity
@Table(name = "formato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formato.findAll", query = "SELECT f FROM Formato f"),
    @NamedQuery(name = "Formato.findByIdformato", query = "SELECT f FROM Formato f WHERE f.idformato = :idformato"),
    @NamedQuery(name = "Formato.findByFormato", query = "SELECT f FROM Formato f WHERE f.formato = :formato"),
    @NamedQuery(name = "Formato.findByProyeccion", query = "SELECT f FROM Formato f WHERE f.proyeccion = :proyeccion")})
public class Formato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformato")
    private Integer idformato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "formato")
    private String formato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "proyeccion")
    private String proyeccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formato")
    private Collection<Tarifa> tarifaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formato")
    private Collection<FormatoPelicula> formatoPeliculaCollection;

    public Formato() {
    }

    public Formato(Integer idformato) {
        this.idformato = idformato;
    }

    public Formato(Integer idformato, String formato, String proyeccion) {
        this.idformato = idformato;
        this.formato = formato;
        this.proyeccion = proyeccion;
    }

    public Integer getIdformato() {
        return idformato;
    }

    public void setIdformato(Integer idformato) {
        this.idformato = idformato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(String proyeccion) {
        this.proyeccion = proyeccion;
    }

    @XmlTransient
    public Collection<Tarifa> getTarifaCollection() {
        return tarifaCollection;
    }

    public void setTarifaCollection(Collection<Tarifa> tarifaCollection) {
        this.tarifaCollection = tarifaCollection;
    }

    @XmlTransient
    public Collection<FormatoPelicula> getFormatoPeliculaCollection() {
        return formatoPeliculaCollection;
    }

    public void setFormatoPeliculaCollection(Collection<FormatoPelicula> formatoPeliculaCollection) {
        this.formatoPeliculaCollection = formatoPeliculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformato != null ? idformato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formato)) {
            return false;
        }
        Formato other = (Formato) object;
        if ((this.idformato == null && other.idformato != null) || (this.idformato != null && !this.idformato.equals(other.idformato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getFormato() + " - " + getProyeccion();
    }
    
}
