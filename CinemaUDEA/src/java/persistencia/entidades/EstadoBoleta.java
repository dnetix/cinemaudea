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
@Table(name = "estado_boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoBoleta.findAll", query = "SELECT e FROM EstadoBoleta e"),
    @NamedQuery(name = "EstadoBoleta.findByIdestadoboleta", query = "SELECT e FROM EstadoBoleta e WHERE e.idestadoboleta = :idestadoboleta"),
    @NamedQuery(name = "EstadoBoleta.findByEstado", query = "SELECT e FROM EstadoBoleta e WHERE e.estado = :estado")})
public class EstadoBoleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadoboleta")
    private Integer idestadoboleta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoboleta")
    private Collection<Boleta> boletaCollection;

    public EstadoBoleta() {
    }

    public EstadoBoleta(Integer idestadoboleta) {
        this.idestadoboleta = idestadoboleta;
    }

    public EstadoBoleta(Integer idestadoboleta, String estado) {
        this.idestadoboleta = idestadoboleta;
        this.estado = estado;
    }

    public Integer getIdestadoboleta() {
        return idestadoboleta;
    }

    public void setIdestadoboleta(Integer idestadoboleta) {
        this.idestadoboleta = idestadoboleta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idestadoboleta != null ? idestadoboleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoBoleta)) {
            return false;
        }
        EstadoBoleta other = (EstadoBoleta) object;
        if ((this.idestadoboleta == null && other.idestadoboleta != null) || (this.idestadoboleta != null && !this.idestadoboleta.equals(other.idestadoboleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.EstadoBoleta[ idestadoboleta=" + idestadoboleta + " ]";
    }
    
}
