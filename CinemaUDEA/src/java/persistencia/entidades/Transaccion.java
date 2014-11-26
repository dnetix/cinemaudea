/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByIdtransaccion", query = "SELECT t FROM Transaccion t WHERE t.idtransaccion = :idtransaccion"),
    @NamedQuery(name = "Transaccion.findByDescripcion", query = "SELECT t FROM Transaccion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Transaccion.findByAmount", query = "SELECT t FROM Transaccion t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transaccion.findByTax", query = "SELECT t FROM Transaccion t WHERE t.tax = :tax"),
    @NamedQuery(name = "Transaccion.findByTaxreturnbase", query = "SELECT t FROM Transaccion t WHERE t.taxreturnbase = :taxreturnbase"),
    @NamedQuery(name = "Transaccion.findBySignature", query = "SELECT t FROM Transaccion t WHERE t.signature = :signature"),
    @NamedQuery(name = "Transaccion.findByCurrency", query = "SELECT t FROM Transaccion t WHERE t.currency = :currency"),
    @NamedQuery(name = "Transaccion.findByTransactionstate", query = "SELECT t FROM Transaccion t WHERE t.transactionstate = :transactionstate"),
    @NamedQuery(name = "Transaccion.findByPolresponsecode", query = "SELECT t FROM Transaccion t WHERE t.polresponsecode = :polresponsecode")})
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "idtransaccion")
    private String idtransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private float tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxreturnbase")
    private int taxreturnbase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "signature")
    private String signature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "currency")
    private String currency;
    @Column(name = "transactionstate")
    private Integer transactionstate;
    @Size(max = 64)
    @Column(name = "polresponsecode")
    private String polresponsecode;
    @ManyToMany(mappedBy = "transaccionCollection")
    private Collection<Boleta> boletaCollection;
    @JoinColumn(name = "socio", referencedColumnName = "idsocio")
    @ManyToOne(optional = false)
    private Socio socio;

    public Transaccion() {
    }

    public Transaccion(String idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public Transaccion(String idtransaccion, String descripcion, float amount, float tax, int taxreturnbase, String signature, String currency) {
        this.idtransaccion = idtransaccion;
        this.descripcion = descripcion;
        this.amount = amount;
        this.tax = tax;
        this.taxreturnbase = taxreturnbase;
        this.signature = signature;
        this.currency = currency;
    }

    public String getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(String idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public int getTaxreturnbase() {
        return taxreturnbase;
    }

    public void setTaxreturnbase(int taxreturnbase) {
        this.taxreturnbase = taxreturnbase;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTransactionstate() {
        return transactionstate;
    }

    public void setTransactionstate(Integer transactionstate) {
        this.transactionstate = transactionstate;
    }

    public String getPolresponsecode() {
        return polresponsecode;
    }

    public void setPolresponsecode(String polresponsecode) {
        this.polresponsecode = polresponsecode;
    }

    @XmlTransient
    public Collection<Boleta> getBoletaCollection() {
        return boletaCollection;
    }

    public void setBoletaCollection(Collection<Boleta> boletaCollection) {
        this.boletaCollection = boletaCollection;
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
        hash += (idtransaccion != null ? idtransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idtransaccion == null && other.idtransaccion != null) || (this.idtransaccion != null && !this.idtransaccion.equals(other.idtransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.entidades.Transaccion[ idtransaccion=" + idtransaccion + " ]";
    }
    
}
