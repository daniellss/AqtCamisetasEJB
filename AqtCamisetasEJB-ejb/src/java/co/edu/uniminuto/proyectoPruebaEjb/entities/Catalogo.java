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
@Table(name = "CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c"),
    @NamedQuery(name = "Catalogo.findByIdcatalogo", query = "SELECT c FROM Catalogo c WHERE c.idcatalogo = :idcatalogo"),
    @NamedQuery(name = "Catalogo.findByTema", query = "SELECT c FROM Catalogo c WHERE c.tema = :tema")})
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATALOGO")
    private Integer idcatalogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TEMA")
    private String tema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tema")
    private Collection<Estampa> estampaCollection;

    public Catalogo() {
    }

    public Catalogo(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public Catalogo(Integer idcatalogo, String tema) {
        this.idcatalogo = idcatalogo;
        this.tema = tema;
    }

    public Integer getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @XmlTransient
    public Collection<Estampa> getEstampaCollection() {
        return estampaCollection;
    }

    public void setEstampaCollection(Collection<Estampa> estampaCollection) {
        this.estampaCollection = estampaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatalogo != null ? idcatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.idcatalogo == null && other.idcatalogo != null) || (this.idcatalogo != null && !this.idcatalogo.equals(other.idcatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.proyectoPruebaEjb.entities.Catalogo[ idcatalogo=" + idcatalogo + " ]";
    }
    
}
