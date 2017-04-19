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
@Table(name = "ESTAMPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estampa.findAll", query = "SELECT e FROM Estampa e"),
    @NamedQuery(name = "Estampa.findByIdestampa", query = "SELECT e FROM Estampa e WHERE e.idestampa = :idestampa"),
    @NamedQuery(name = "Estampa.findByNombre", query = "SELECT e FROM Estampa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estampa.findByDescripcion", query = "SELECT e FROM Estampa e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estampa.findByPrecio", query = "SELECT e FROM Estampa e WHERE e.precio = :precio"),
    @NamedQuery(name = "Estampa.findByImagen", query = "SELECT e FROM Estampa e WHERE e.imagen = :imagen")})
public class Estampa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESTAMPA")
    private Integer idestampa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IMAGEN")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estampa")
    private Collection<Ratingestampa> ratingestampaCollection;
    @JoinColumn(name = "TEMA", referencedColumnName = "IDCATALOGO")
    @ManyToOne(optional = false)
    private Catalogo tema;
    @JoinColumn(name = "ARTISTA", referencedColumnName = "USUARIO")
    @ManyToOne(optional = false)
    private Usuario artista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estampa")
    private Collection<Carro> carroCollection;

    public Estampa() {
    }

    public Estampa(Integer idestampa) {
        this.idestampa = idestampa;
    }

    public Estampa(Integer idestampa, String nombre, String descripcion, int precio, String imagen) {
        this.idestampa = idestampa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Integer getIdestampa() {
        return idestampa;
    }

    public void setIdestampa(Integer idestampa) {
        this.idestampa = idestampa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<Ratingestampa> getRatingestampaCollection() {
        return ratingestampaCollection;
    }

    public void setRatingestampaCollection(Collection<Ratingestampa> ratingestampaCollection) {
        this.ratingestampaCollection = ratingestampaCollection;
    }

    public Catalogo getTema() {
        return tema;
    }

    public void setTema(Catalogo tema) {
        this.tema = tema;
    }

    public Usuario getArtista() {
        return artista;
    }

    public void setArtista(Usuario artista) {
        this.artista = artista;
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
        hash += (idestampa != null ? idestampa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estampa)) {
            return false;
        }
        Estampa other = (Estampa) object;
        if ((this.idestampa == null && other.idestampa != null) || (this.idestampa != null && !this.idestampa.equals(other.idestampa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Estampa[ idestampa=" + idestampa + " ]";
    }
    
}
