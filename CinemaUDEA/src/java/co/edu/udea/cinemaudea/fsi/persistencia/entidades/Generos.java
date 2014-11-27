/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cinemaudea.fsi.persistencia.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "generos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generos.findAll", query = "SELECT g FROM Generos g"),
    @NamedQuery(name = "Generos.findByIdgeneros", query = "SELECT g FROM Generos g WHERE g.idgeneros = :idgeneros")})
public class Generos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgeneros")
    private Integer idgeneros;
    @JoinColumn(name = "genero_idgenero", referencedColumnName = "idgenero")
    @ManyToOne(optional = false)
    private Genero generoIdgenero;
    @JoinColumn(name = "pelicula_idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne(optional = false)
    private Pelicula peliculaIdpelicula;

    public Generos() {
    }

    public Generos(Integer idgeneros) {
        this.idgeneros = idgeneros;
    }

    public Integer getIdgeneros() {
        return idgeneros;
    }

    public void setIdgeneros(Integer idgeneros) {
        this.idgeneros = idgeneros;
    }

    public Genero getGeneroIdgenero() {
        return generoIdgenero;
    }

    public void setGeneroIdgenero(Genero generoIdgenero) {
        this.generoIdgenero = generoIdgenero;
    }

    public Pelicula getPeliculaIdpelicula() {
        return peliculaIdpelicula;
    }

    public void setPeliculaIdpelicula(Pelicula peliculaIdpelicula) {
        this.peliculaIdpelicula = peliculaIdpelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgeneros != null ? idgeneros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generos)) {
            return false;
        }
        Generos other = (Generos) object;
        if ((this.idgeneros == null && other.idgeneros != null) || (this.idgeneros != null && !this.idgeneros.equals(other.idgeneros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Generos[ idgeneros=" + idgeneros + " ]";
    }
    
}
