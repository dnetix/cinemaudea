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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "elenco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elenco.findAll", query = "SELECT e FROM Elenco e"),
    @NamedQuery(name = "Elenco.findByIdelenco", query = "SELECT e FROM Elenco e WHERE e.idelenco = :idelenco"),
    @NamedQuery(name = "Elenco.findByPersonaje", query = "SELECT e FROM Elenco e WHERE e.personaje = :personaje")})
public class Elenco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idelenco")
    private Integer idelenco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "personaje")
    private String personaje;
    @JoinColumn(name = "pelicula", referencedColumnName = "idpelicula")
    @ManyToOne(optional = false)
    private Pelicula pelicula;
    @JoinColumn(name = "persona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona persona;

    public Elenco() {
    }

    public Elenco(Integer idelenco) {
        this.idelenco = idelenco;
    }

    public Elenco(Integer idelenco, String personaje) {
        this.idelenco = idelenco;
        this.personaje = personaje;
    }

    public Integer getIdelenco() {
        return idelenco;
    }

    public void setIdelenco(Integer idelenco) {
        this.idelenco = idelenco;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelenco != null ? idelenco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elenco)) {
            return false;
        }
        Elenco other = (Elenco) object;
        if ((this.idelenco == null && other.idelenco != null) || (this.idelenco != null && !this.idelenco.equals(other.idelenco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Elenco[ idelenco=" + idelenco + " ]";
    }
    
}
