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
@Table(name = "CAMISETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camiseta.findAll", query = "SELECT c FROM Camiseta c"),
    @NamedQuery(name = "Camiseta.findByIdcamiseta", query = "SELECT c FROM Camiseta c WHERE c.idcamiseta = :idcamiseta"),
    @NamedQuery(name = "Camiseta.findByMaterial", query = "SELECT c FROM Camiseta c WHERE c.material = :material"),
    @NamedQuery(name = "Camiseta.findByColor", query = "SELECT c FROM Camiseta c WHERE c.color = :color"),
    @NamedQuery(name = "Camiseta.findByTalla", query = "SELECT c FROM Camiseta c WHERE c.talla = :talla"),
    @NamedQuery(name = "Camiseta.findByPrecio", query = "SELECT c FROM Camiseta c WHERE c.precio = :precio")})
public class Camiseta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCAMISETA")
    private Integer idcamiseta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MATERIAL")
    private String material;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TALLA")
    private String talla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camiseta")
    private Collection<Carro> carroCollection;

    public Camiseta() {
    }

    public Camiseta(Integer idcamiseta) {
        this.idcamiseta = idcamiseta;
    }

    public Camiseta(Integer idcamiseta, String material, String color, String talla, int precio) {
        this.idcamiseta = idcamiseta;
        this.material = material;
        this.color = color;
        this.talla = talla;
        this.precio = precio;
    }

    public Integer getIdcamiseta() {
        return idcamiseta;
    }

    public void setIdcamiseta(Integer idcamiseta) {
        this.idcamiseta = idcamiseta;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
        hash += (idcamiseta != null ? idcamiseta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camiseta)) {
            return false;
        }
        Camiseta other = (Camiseta) object;
        if ((this.idcamiseta == null && other.idcamiseta != null) || (this.idcamiseta != null && !this.idcamiseta.equals(other.idcamiseta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Camiseta[ idcamiseta=" + idcamiseta + " ]";
    }
    
}
