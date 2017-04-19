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
@Table(name = "RATINGESTAMPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratingestampa.findAll", query = "SELECT r FROM Ratingestampa r"),
    @NamedQuery(name = "Ratingestampa.findByIdratingestampa", query = "SELECT r FROM Ratingestampa r WHERE r.idratingestampa = :idratingestampa"),
    @NamedQuery(name = "Ratingestampa.findByCalificacion", query = "SELECT r FROM Ratingestampa r WHERE r.calificacion = :calificacion")})
public class Ratingestampa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRATINGESTAMPA")
    private Integer idratingestampa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION")
    private int calificacion;
    @JoinColumn(name = "ESTAMPA", referencedColumnName = "IDESTAMPA")
    @ManyToOne(optional = false)
    private Estampa estampa;

    public Ratingestampa() {
    }

    public Ratingestampa(Integer idratingestampa) {
        this.idratingestampa = idratingestampa;
    }

    public Ratingestampa(Integer idratingestampa, int calificacion) {
        this.idratingestampa = idratingestampa;
        this.calificacion = calificacion;
    }

    public Integer getIdratingestampa() {
        return idratingestampa;
    }

    public void setIdratingestampa(Integer idratingestampa) {
        this.idratingestampa = idratingestampa;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
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
        hash += (idratingestampa != null ? idratingestampa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratingestampa)) {
            return false;
        }
        Ratingestampa other = (Ratingestampa) object;
        if ((this.idratingestampa == null && other.idratingestampa != null) || (this.idratingestampa != null && !this.idratingestampa.equals(other.idratingestampa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Ratingestampa[ idratingestampa=" + idratingestampa + " ]";
    }
    
}
