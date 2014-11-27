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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByIdlocalidad", query = "SELECT l FROM Localidad l WHERE l.idlocalidad = :idlocalidad"),
    @NamedQuery(name = "Localidad.findByLocalidad", query = "SELECT l FROM Localidad l WHERE l.localidad = :localidad")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "idlocalidad")
    private String idlocalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "localidad")
    private String localidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
    private Collection<Silla> sillaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad")
    private Collection<Tarifa> tarifaCollection;

    public Localidad() {
    }

    public Localidad(String idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public Localidad(String idlocalidad, String localidad) {
        this.idlocalidad = idlocalidad;
        this.localidad = localidad;
    }

    public String getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(String idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @XmlTransient
    public Collection<Silla> getSillaCollection() {
        return sillaCollection;
    }

    public void setSillaCollection(Collection<Silla> sillaCollection) {
        this.sillaCollection = sillaCollection;
    }

    @XmlTransient
    public Collection<Tarifa> getTarifaCollection() {
        return tarifaCollection;
    }

    public void setTarifaCollection(Collection<Tarifa> tarifaCollection) {
        this.tarifaCollection = tarifaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalidad != null ? idlocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idlocalidad == null && other.idlocalidad != null) || (this.idlocalidad != null && !this.idlocalidad.equals(other.idlocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getLocalidad();
    }
    
}
