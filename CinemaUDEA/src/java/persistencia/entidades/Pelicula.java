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
import javax.persistence.Lob;
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
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findByIdpelicula", query = "SELECT p FROM Pelicula p WHERE p.idpelicula = :idpelicula"),
    @NamedQuery(name = "Pelicula.findByNombre", query = "SELECT p FROM Pelicula p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pelicula.findByFecha", query = "SELECT p FROM Pelicula p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pelicula.findByDuracion", query = "SELECT p FROM Pelicula p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "Pelicula.findByUrlImagen", query = "SELECT p FROM Pelicula p WHERE p.urlImagen = :urlImagen")})
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpelicula")
    private Integer idpelicula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "sinopsis")
    private String sinopsis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "url_imagen")
    private String urlImagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private Collection<Calificacion> calificacionCollection;
    @JoinColumn(name = "pais", referencedColumnName = "codigopais")
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private Collection<Elenco> elencoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculaIdpelicula")
    private Collection<Generos> generosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private Collection<Equipo> equipoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private Collection<FormatoPelicula> formatoPeliculaCollection;

    public Pelicula() {
    }

    public Pelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Pelicula(Integer idpelicula, String nombre, String fecha, String sinopsis, int duracion, String urlImagen) {
        this.idpelicula = idpelicula;
        this.nombre = nombre;
        this.fecha = fecha;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.urlImagen = urlImagen;
    }

    public Integer getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Collection<Elenco> getElencoCollection() {
        return elencoCollection;
    }

    public void setElencoCollection(Collection<Elenco> elencoCollection) {
        this.elencoCollection = elencoCollection;
    }

    @XmlTransient
    public Collection<Generos> getGenerosCollection() {
        return generosCollection;
    }

    public void setGenerosCollection(Collection<Generos> generosCollection) {
        this.generosCollection = generosCollection;
    }

    @XmlTransient
    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
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
        hash += (idpelicula != null ? idpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idpelicula == null && other.idpelicula != null) || (this.idpelicula != null && !this.idpelicula.equals(other.idpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // Por defecto el toString retorna el nombre de la pelicula
        return getNombre();
    }
    
}
