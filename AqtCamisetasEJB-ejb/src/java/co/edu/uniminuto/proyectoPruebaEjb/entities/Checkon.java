/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.proyectoPruebaEjb.entities;

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
 * @author daniel
 */
@Entity
@Table(name = "CHECKON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkon.findAll", query = "SELECT c FROM Checkon c"),
    @NamedQuery(name = "Checkon.findByIdcheckon", query = "SELECT c FROM Checkon c WHERE c.idcheckon = :idcheckon"),
    @NamedQuery(name = "Checkon.findByFecha", query = "SELECT c FROM Checkon c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Checkon.findByPrecio", query = "SELECT c FROM Checkon c WHERE c.precio = :precio")})
public class Checkon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCHECKON")
    private Integer idcheckon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FECHA")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @JoinColumn(name = "PAGO", referencedColumnName = "IDPAGO")
    @ManyToOne(optional = false)
    private Pago pago;
    @JoinColumn(name = "USUARIO", referencedColumnName = "USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkon")
    private Collection<Carro> carroCollection;

    public Checkon() {
    }

    public Checkon(Integer idcheckon) {
        this.idcheckon = idcheckon;
    }

    public Checkon(Integer idcheckon, String fecha, int precio) {
        this.idcheckon = idcheckon;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Integer getIdcheckon() {
        return idcheckon;
    }

    public void setIdcheckon(Integer idcheckon) {
        this.idcheckon = idcheckon;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Carro> getCarroCollection() {
        return carroCollection;
    }

    public void setCarroCollection(Collection<Carro> carroCollection) {
        this.carroCollection = carroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcheckon != null ? idcheckon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkon)) {
            return false;
        }
        Checkon other = (Checkon) object;
        if ((this.idcheckon == null && other.idcheckon != null) || (this.idcheckon != null && !this.idcheckon.equals(other.idcheckon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Checkon[ idcheckon=" + idcheckon + " ]";
    }
    
}
