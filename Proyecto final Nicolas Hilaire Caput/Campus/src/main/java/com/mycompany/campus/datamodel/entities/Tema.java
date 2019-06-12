/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WEB 2
 */
@Entity
@Table(name = "tema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tema.findAll", query = "SELECT t FROM Tema t"),
    @NamedQuery(name = "Tema.findById", query = "SELECT t FROM Tema t WHERE t.id = :id"),
    @NamedQuery(name = "Tema.findByIdCurso", query = "SELECT t FROM Tema t WHERE t.idCurso = :idCurso"),
    @NamedQuery(name = "Tema.findByNombre", query = "SELECT t FROM Tema t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tema.findByUrl", query = "SELECT t FROM Tema t WHERE t.url = :url")})
public class Tema implements Serializable {
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
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "id_curso_tema", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CursoTema idCursoTema;

    public Tema() {
    }

    public Tema(Integer id) {
        this.id = id;
    }

    public Tema(Integer id, int idCurso, String nombre, String url) {
        this.id = id;
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.url = url;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CursoTema getIdCursoTema() {
        return idCursoTema;
    }

    public void setIdCursoTema(CursoTema idCursoTema) {
        this.idCursoTema = idCursoTema;
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
        if (!(object instanceof Tema)) {
            return false;
        }
        Tema other = (Tema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.Tema[ id=" + id + " ]";
    }
    
}
