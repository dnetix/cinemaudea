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
@Table(name = "silla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Silla.findAll", query = "SELECT s FROM Silla s"),
    @NamedQuery(name = "Silla.findByIdsilla", query = "SELECT s FROM Silla s WHERE s.idsilla = :idsilla"),
    @NamedQuery(name = "Silla.findByLetra", query = "SELECT s FROM Silla s WHERE s.letra = :letra"),
    @NamedQuery(name = "Silla.findByNumero", query = "SELECT s FROM Silla s WHERE s.numero = :numero")})
public class Silla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsilla")
    private Integer idsilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "letra")
    private String letra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @JoinColumn(name = "localidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad localidad;
    @JoinColumn(name = "sala", referencedColumnName = "idsala")
    @ManyToOne(optional = false)
    private Sala sala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "silla")
    private Collection<Boleta> boletaCollection;

    public Silla() {
    }

    public Silla(Integer idsilla) {
        this.idsilla = idsilla;
    }

    public Silla(Integer idsilla, String letra, int numero) {
        this.idsilla = idsilla;
        this.letra = letra;
        this.numero = numero;
    }

    public Integer getIdsilla() {
        return idsilla;
    }

    public void setIdsilla(Integer idsilla) {
        this.idsilla = idsilla;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
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
        hash += (idsilla != null ? idsilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Silla)) {
            return false;
        }
        Silla other = (Silla) object;
        if ((this.idsilla == null && other.idsilla != null) || (this.idsilla != null && !this.idsilla.equals(other.idsilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Silla[ idsilla=" + idsilla + " ]";
    }
    
}
