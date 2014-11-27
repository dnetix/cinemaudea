/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cinemaudea.fsi.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DiegoCalle
 */
@Entity
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findByIdsocio", query = "SELECT s FROM Socio s WHERE s.idsocio = :idsocio"),
    @NamedQuery(name = "Socio.findByTipodocumento", query = "SELECT s FROM Socio s WHERE s.tipodocumento = :tipodocumento"),
    @NamedQuery(name = "Socio.findByNrodocumento", query = "SELECT s FROM Socio s WHERE s.nrodocumento = :nrodocumento"),
    @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Socio.findByApellidos", query = "SELECT s FROM Socio s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Socio.findByFechanacimiento", query = "SELECT s FROM Socio s WHERE s.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Socio.findByGenero", query = "SELECT s FROM Socio s WHERE s.genero = :genero"),
    @NamedQuery(name = "Socio.findByEmail", query = "SELECT s FROM Socio s WHERE s.email = :email"),
    @NamedQuery(name = "Socio.findByContrasena", query = "SELECT s FROM Socio s WHERE s.contrasena = :contrasena"),
    @NamedQuery(name = "Socio.findByTelefono", query = "SELECT s FROM Socio s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Socio.findByCelular", query = "SELECT s FROM Socio s WHERE s.celular = :celular")})
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsocio")
    private Integer idsocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipodocumento")
    private String tipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nrodocumento")
    private String nrodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 60)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "genero")
    private String genero;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "celular")
    private String celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private Collection<Compra> compraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private Collection<Calificacion> calificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private Collection<Redime> redimeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private Collection<Transaccion> transaccionCollection;
    @OneToMany(mappedBy = "socio")
    private Collection<Boleta> boletaCollection;

    public Socio() {
    }

    public Socio(Integer idsocio) {
        this.idsocio = idsocio;
    }

    public Socio(Integer idsocio, String tipodocumento, String nrodocumento, String nombre, String genero, String email, String contrasena, String celular) {
        this.idsocio = idsocio;
        this.tipodocumento = tipodocumento;
        this.nrodocumento = nrodocumento;
        this.nombre = nombre;
        this.genero = genero;
        this.email = email;
        this.contrasena = contrasena;
        this.celular = celular;
    }

    public Integer getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Integer idsocio) {
        this.idsocio = idsocio;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    @XmlTransient
    public Collection<Redime> getRedimeCollection() {
        return redimeCollection;
    }

    public void setRedimeCollection(Collection<Redime> redimeCollection) {
        this.redimeCollection = redimeCollection;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
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
        hash += (idsocio != null ? idsocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.idsocio == null && other.idsocio != null) || (this.idsocio != null && !this.idsocio.equals(other.idsocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
    
}
