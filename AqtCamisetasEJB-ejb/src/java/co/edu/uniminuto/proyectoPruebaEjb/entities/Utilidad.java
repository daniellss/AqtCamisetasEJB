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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "UTILIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilidad.findAll", query = "SELECT u FROM Utilidad u"),
    @NamedQuery(name = "Utilidad.findByIdutilidad", query = "SELECT u FROM Utilidad u WHERE u.idutilidad = :idutilidad"),
    @NamedQuery(name = "Utilidad.findByPrecio", query = "SELECT u FROM Utilidad u WHERE u.precio = :precio")})
public class Utilidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUTILIDAD")
    private Integer idutilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @JoinColumn(name = "ARTISTA", referencedColumnName = "USUARIO")
    @ManyToOne(optional = false)
    private Usuario artista;

    public Utilidad() {
    }

    public Utilidad(Integer idutilidad) {
        this.idutilidad = idutilidad;
    }

    public Utilidad(Integer idutilidad, int precio) {
        this.idutilidad = idutilidad;
        this.precio = precio;
    }

    public Integer getIdutilidad() {
        return idutilidad;
    }

    public void setIdutilidad(Integer idutilidad) {
        this.idutilidad = idutilidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Usuario getArtista() {
        return artista;
    }

    public void setArtista(Usuario artista) {
        this.artista = artista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilidad != null ? idutilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilidad)) {
            return false;
        }
        Utilidad other = (Utilidad) object;
        if ((this.idutilidad == null && other.idutilidad != null) || (this.idutilidad != null && !this.idutilidad.equals(other.idutilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Utilidad[ idutilidad=" + idutilidad + " ]";
    }
    
}
