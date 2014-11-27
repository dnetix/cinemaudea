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
@Table(name = "teatro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teatro.findAll", query = "SELECT t FROM Teatro t"),
    @NamedQuery(name = "Teatro.findByIdteatro", query = "SELECT t FROM Teatro t WHERE t.idteatro = :idteatro"),
    @NamedQuery(name = "Teatro.findByNombre", query = "SELECT t FROM Teatro t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Teatro.findByDireccion", query = "SELECT t FROM Teatro t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "Teatro.findByTelefono", query = "SELECT t FROM Teatro t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Teatro.findByCiudad", query = "SELECT t FROM Teatro t WHERE t.ciudad = :ciudad")})
public class Teatro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idteatro")
    private Integer idteatro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teatro")
    private Collection<Sala> salaCollection;

    public Teatro() {
    }

    public Teatro(Integer idteatro) {
        this.idteatro = idteatro;
    }

    public Teatro(Integer idteatro, String nombre, String direccion, String telefono) {
        this.idteatro = idteatro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getIdteatro() {
        return idteatro;
    }

    public void setIdteatro(Integer idteatro) {
        this.idteatro = idteatro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Sala> getSalaCollection() {
        return salaCollection;
    }

    public void setSalaCollection(Collection<Sala> salaCollection) {
        this.salaCollection = salaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteatro != null ? idteatro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teatro)) {
            return false;
        }
        Teatro other = (Teatro) object;
        if ((this.idteatro == null && other.idteatro != null) || (this.idteatro != null && !this.idteatro.equals(other.idteatro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}
