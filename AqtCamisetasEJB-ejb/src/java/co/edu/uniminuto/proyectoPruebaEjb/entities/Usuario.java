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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Direccion> direccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artista")
    private Collection<Utilidad> utilidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Pago> pagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Checkon> checkonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artista")
    private Collection<Estampa> estampaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artista")
    private Collection<Ratingartista> ratingartistaCollection;

    public Usuario() {
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(String usuario, String nombre, String contrasena, String correo, String tipo) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Direccion> getDireccionCollection() {
        return direccionCollection;
    }

    public void setDireccionCollection(Collection<Direccion> direccionCollection) {
        this.direccionCollection = direccionCollection;
    }

    @XmlTransient
    public Collection<Utilidad> getUtilidadCollection() {
        return utilidadCollection;
    }

    public void setUtilidadCollection(Collection<Utilidad> utilidadCollection) {
        this.utilidadCollection = utilidadCollection;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @XmlTransient
    public Collection<Checkon> getCheckonCollection() {
        return checkonCollection;
    }

    public void setCheckonCollection(Collection<Checkon> checkonCollection) {
        this.checkonCollection = checkonCollection;
    }

    @XmlTransient
    public Collection<Estampa> getEstampaCollection() {
        return estampaCollection;
    }

    public void setEstampaCollection(Collection<Estampa> estampaCollection) {
        this.estampaCollection = estampaCollection;
    }

    @XmlTransient
    public Collection<Ratingartista> getRatingartistaCollection() {
        return ratingartistaCollection;
    }

    public void setRatingartistaCollection(Collection<Ratingartista> ratingartistaCollection) {
        this.ratingartistaCollection = ratingartistaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Usuario[ usuario=" + usuario + " ]";
    }
    
}
