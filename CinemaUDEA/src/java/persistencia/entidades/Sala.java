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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findByIdsala", query = "SELECT s FROM Sala s WHERE s.idsala = :idsala"),
    @NamedQuery(name = "Sala.findByUbicacion", query = "SELECT s FROM Sala s WHERE s.ubicacion = :ubicacion"),
    @NamedQuery(name = "Sala.findBySillas", query = "SELECT s FROM Sala s WHERE s.sillas = :sillas")})
public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsala")
    private Integer idsala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sillas")
    private int sillas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private Collection<Silla> sillaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private Collection<Funcion> funcionCollection;
    @JoinColumn(name = "teatro", referencedColumnName = "idteatro")
    @ManyToOne(optional = false)
    private Teatro teatro;

    public Sala() {
    }

    public Sala(Integer idsala) {
        this.idsala = idsala;
    }

    public Sala(Integer idsala, String ubicacion, int sillas) {
        this.idsala = idsala;
        this.ubicacion = ubicacion;
        this.sillas = sillas;
    }

    public Integer getIdsala() {
        return idsala;
    }

    public void setIdsala(Integer idsala) {
        this.idsala = idsala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getSillas() {
        return sillas;
    }

    public void setSillas(int sillas) {
        this.sillas = sillas;
    }

    @XmlTransient
    public Collection<Silla> getSillaCollection() {
        return sillaCollection;
    }

    public void setSillaCollection(Collection<Silla> sillaCollection) {
        this.sillaCollection = sillaCollection;
    }

    @XmlTransient
    public Collection<Funcion> getFuncionCollection() {
        return funcionCollection;
    }

    public void setFuncionCollection(Collection<Funcion> funcionCollection) {
        this.funcionCollection = funcionCollection;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsala != null ? idsala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.idsala == null && other.idsala != null) || (this.idsala != null && !this.idsala.equals(other.idsala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Sala[ idsala=" + idsala + " ]";
    }
    
}
