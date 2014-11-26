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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "formato_pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormatoPelicula.findAll", query = "SELECT f FROM FormatoPelicula f"),
    @NamedQuery(name = "FormatoPelicula.findByFormatopelicula", query = "SELECT f FROM FormatoPelicula f WHERE f.formatopelicula = :formatopelicula")})
public class FormatoPelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "formatopelicula")
    private Integer formatopelicula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formatopelicula")
    private Collection<Cartelera> carteleraCollection;
    @JoinColumn(name = "formato", referencedColumnName = "idformato")
    @ManyToOne(optional = false)
    private Formato formato;
    @JoinColumn(name = "idioma", referencedColumnName = "ididioma")
    @ManyToOne(optional = false)
    private Idioma idioma;
    @JoinColumn(name = "subtitulos", referencedColumnName = "ididioma")
    @ManyToOne
    private Idioma subtitulos;
    @JoinColumn(name = "pelicula", referencedColumnName = "idpelicula")
    @ManyToOne(optional = false)
    private Pelicula pelicula;

    public FormatoPelicula() {
    }

    public FormatoPelicula(Integer formatopelicula) {
        this.formatopelicula = formatopelicula;
    }

    public Integer getFormatopelicula() {
        return formatopelicula;
    }

    public void setFormatopelicula(Integer formatopelicula) {
        this.formatopelicula = formatopelicula;
    }

    @XmlTransient
    public Collection<Cartelera> getCarteleraCollection() {
        return carteleraCollection;
    }

    public void setCarteleraCollection(Collection<Cartelera> carteleraCollection) {
        this.carteleraCollection = carteleraCollection;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Idioma getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(Idioma subtitulos) {
        this.subtitulos = subtitulos;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formatopelicula != null ? formatopelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormatoPelicula)) {
            return false;
        }
        FormatoPelicula other = (FormatoPelicula) object;
        if ((this.formatopelicula == null && other.formatopelicula != null) || (this.formatopelicula != null && !this.formatopelicula.equals(other.formatopelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.FormatoPelicula[ formatopelicula=" + formatopelicula + " ]";
    }
    
}
