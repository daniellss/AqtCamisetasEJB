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
@Table(name = "RATINGARTISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratingartista.findAll", query = "SELECT r FROM Ratingartista r"),
    @NamedQuery(name = "Ratingartista.findByIdratingartista", query = "SELECT r FROM Ratingartista r WHERE r.idratingartista = :idratingartista"),
    @NamedQuery(name = "Ratingartista.findByCalificacion", query = "SELECT r FROM Ratingartista r WHERE r.calificacion = :calificacion")})
public class Ratingartista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRATINGARTISTA")
    private Integer idratingartista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION")
    private int calificacion;
    @JoinColumn(name = "ARTISTA", referencedColumnName = "USUARIO")
    @ManyToOne(optional = false)
    private Usuario artista;

    public Ratingartista() {
    }

    public Ratingartista(Integer idratingartista) {
        this.idratingartista = idratingartista;
    }

    public Ratingartista(Integer idratingartista, int calificacion) {
        this.idratingartista = idratingartista;
        this.calificacion = calificacion;
    }

    public Integer getIdratingartista() {
        return idratingartista;
    }

    public void setIdratingartista(Integer idratingartista) {
        this.idratingartista = idratingartista;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
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
        hash += (idratingartista != null ? idratingartista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratingartista)) {
            return false;
        }
        Ratingartista other = (Ratingartista) object;
        if ((this.idratingartista == null && other.idratingartista != null) || (this.idratingartista != null && !this.idratingartista.equals(other.idratingartista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Ratingartista[ idratingartista=" + idratingartista + " ]";
    }
    
}
