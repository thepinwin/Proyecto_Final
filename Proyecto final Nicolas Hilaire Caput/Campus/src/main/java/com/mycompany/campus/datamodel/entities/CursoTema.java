/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author WEB 2
 */
@Entity
@Table(name = "curso_tema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoTema.findAll", query = "SELECT c FROM CursoTema c"),
    @NamedQuery(name = "CursoTema.findById", query = "SELECT c FROM CursoTema c WHERE c.id = :id"),
    @NamedQuery(name = "CursoTema.findByIdCurso", query = "SELECT c FROM CursoTema c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "CursoTema.findByTitulo", query = "SELECT c FROM CursoTema c WHERE c.titulo = :titulo"),
    @NamedQuery(name = "CursoTema.findByPrecio", query = "SELECT c FROM CursoTema c WHERE c.precio = :precio")})
public class CursoTema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso")
    private int idCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoTema")
    private Collection<Tema> temaCollection;

    public CursoTema() {
    }

    public CursoTema(Integer id) {
        this.id = id;
    }

    public CursoTema(Integer id, int idCurso, String titulo) {
        this.id = id;
        this.idCurso = idCurso;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Tema> getTemaCollection() {
        return temaCollection;
    }

    public void setTemaCollection(Collection<Tema> temaCollection) {
        this.temaCollection = temaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoTema)) {
            return false;
        }
        CursoTema other = (CursoTema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.CursoTema[ id=" + id + " ]";
    }
    
}
