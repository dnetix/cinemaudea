/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cinemaudea.fsi.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByIdgenero", query = "SELECT g FROM Genero g WHERE g.idgenero = :idgenero"),
    @NamedQuery(name = "Genero.findByGenero", query = "SELECT g FROM Genero g WHERE g.genero = :genero")})
public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgenero")
    private Integer idgenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "genero")
    private String genero;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generoIdgenero")
    private Collection<Generos> generosCollection;

    public Genero() {
    }

    public Genero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public Genero(Integer idgenero, String genero) {
        this.idgenero = idgenero;
        this.genero = genero;
    }

    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Generos> getGenerosCollection() {
        return generosCollection;
    }

    public void setGenerosCollection(Collection<Generos> generosCollection) {
        this.generosCollection = generosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgenero != null ? idgenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.idgenero == null && other.idgenero != null) || (this.idgenero != null && !this.idgenero.equals(other.idgenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getGenero();
    }
    
}
