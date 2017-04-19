/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.proyectoPruebaEjb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "CARRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findByIdcarro", query = "SELECT c FROM Carro c WHERE c.idcarro = :idcarro"),
    @NamedQuery(name = "Carro.findByCantidad", query = "SELECT c FROM Carro c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Carro.findByAdicional", query = "SELECT c FROM Carro c WHERE c.adicional = :adicional")})
public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCARRO")
    private Integer idcarro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADICIONAL")
    private int adicional;
    @JoinColumn(name = "CAMISETA", referencedColumnName = "IDCAMISETA")
    @ManyToOne(optional = false)
    private Camiseta camiseta;
    @JoinColumn(name = "CHECKON", referencedColumnName = "IDCHECKON")
    @ManyToOne(optional = false)
    private Checkon checkon;
    @JoinColumn(name = "ESTAMPA", referencedColumnName = "IDESTAMPA")
    @ManyToOne(optional = false)
    private Estampa estampa;

    public Carro() {
    }

    public Carro(Integer idcarro) {
        this.idcarro = idcarro;
    }

    public Carro(Integer idcarro, int cantidad, int adicional) {
        this.idcarro = idcarro;
        this.cantidad = cantidad;
        this.adicional = adicional;
    }

    public Integer getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(Integer idcarro) {
        this.idcarro = idcarro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAdicional() {
        return adicional;
    }

    public void setAdicional(int adicional) {
        this.adicional = adicional;
    }

    public Camiseta getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(Camiseta camiseta) {
        this.camiseta = camiseta;
    }

    public Checkon getCheckon() {
        return checkon;
    }

    public void setCheckon(Checkon checkon) {
        this.checkon = checkon;
    }

    public Estampa getEstampa() {
        return estampa;
    }

    public void setEstampa(Estampa estampa) {
        this.estampa = estampa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarro != null ? idcarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idcarro == null && other.idcarro != null) || (this.idcarro != null && !this.idcarro.equals(other.idcarro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Carro[ idcarro=" + idcarro + " ]";
    }
    
}
