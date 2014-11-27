/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cinemaudea.fsi.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "redime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Redime.findAll", query = "SELECT r FROM Redime r"),
    @NamedQuery(name = "Redime.findByIdredime", query = "SELECT r FROM Redime r WHERE r.idredime = :idredime"),
    @NamedQuery(name = "Redime.findByPuntos", query = "SELECT r FROM Redime r WHERE r.puntos = :puntos"),
    @NamedQuery(name = "Redime.findByFecha", query = "SELECT r FROM Redime r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Redime.findByCantidad", query = "SELECT r FROM Redime r WHERE r.cantidad = :cantidad")})
public class Redime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idredime")
    private Integer idredime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "producto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "socio", referencedColumnName = "idsocio")
    @ManyToOne(optional = false)
    private Socio socio;

    public Redime() {
    }

    public Redime(Integer idredime) {
        this.idredime = idredime;
    }

    public Redime(Integer idredime, int puntos, Date fecha) {
        this.idredime = idredime;
        this.puntos = puntos;
        this.fecha = fecha;
    }

    public Integer getIdredime() {
        return idredime;
    }

    public void setIdredime(Integer idredime) {
        this.idredime = idredime;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idredime != null ? idredime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Redime)) {
            return false;
        }
        Redime other = (Redime) object;
        if ((this.idredime == null && other.idredime != null) || (this.idredime != null && !this.idredime.equals(other.idredime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Redime[ idredime=" + idredime + " ]";
    }
    
}
