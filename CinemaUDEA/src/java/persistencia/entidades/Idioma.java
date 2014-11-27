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
@Table(name = "idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByIdidioma", query = "SELECT i FROM Idioma i WHERE i.ididioma = :ididioma"),
    @NamedQuery(name = "Idioma.findByIdioma", query = "SELECT i FROM Idioma i WHERE i.idioma = :idioma")})
public class Idioma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ididioma")
    private Integer ididioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idioma")
    private String idioma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idioma")
    private Collection<FormatoPelicula> formatoPeliculaCollection;
    @OneToMany(mappedBy = "subtitulos")
    private Collection<FormatoPelicula> formatoPeliculaCollection1;

    public Idioma() {
    }

    public Idioma(Integer ididioma) {
        this.ididioma = ididioma;
    }

    public Idioma(Integer ididioma, String idioma) {
        this.ididioma = ididioma;
        this.idioma = idioma;
    }

    public Integer getIdidioma() {
        return ididioma;
    }

    public void setIdidioma(Integer ididioma) {
        this.ididioma = ididioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @XmlTransient
    public Collection<FormatoPelicula> getFormatoPeliculaCollection() {
        return formatoPeliculaCollection;
    }

    public void setFormatoPeliculaCollection(Collection<FormatoPelicula> formatoPeliculaCollection) {
        this.formatoPeliculaCollection = formatoPeliculaCollection;
    }

    @XmlTransient
    public Collection<FormatoPelicula> getFormatoPeliculaCollection1() {
        return formatoPeliculaCollection1;
    }

    public void setFormatoPeliculaCollection1(Collection<FormatoPelicula> formatoPeliculaCollection1) {
        this.formatoPeliculaCollection1 = formatoPeliculaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ididioma != null ? ididioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.ididioma == null && other.ididioma != null) || (this.ididioma != null && !this.ididioma.equals(other.ididioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIdioma();
    }
    
}
