/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.entities;

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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author WEB 2
 */
@Entity
@Table(name = "curso_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoInfo.findAll", query = "SELECT c FROM CursoInfo c"),
    @NamedQuery(name = "CursoInfo.findById", query = "SELECT c FROM CursoInfo c WHERE c.id = :id"),
    @NamedQuery(name = "CursoInfo.findByIdCurso", query = "SELECT c FROM CursoInfo c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "CursoInfo.findByTexto", query = "SELECT c FROM CursoInfo c WHERE c.texto = :texto")})
public class CursoInfo implements Serializable {
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
    @Size(min = 1, max = 50)
    @Column(name = "texto")
    private String texto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursoInfo")
    private Collection<Info> infoCollection;

    public CursoInfo() {
    }

    public CursoInfo(Integer id) {
        this.id = id;
    }

    public CursoInfo(Integer id, int idCurso, String texto) {
        this.id = id;
        this.idCurso = idCurso;
        this.texto = texto;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Info> getInfoCollection() {
        return infoCollection;
    }

    public void setInfoCollection(Collection<Info> infoCollection) {
        this.infoCollection = infoCollection;
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
        if (!(object instanceof CursoInfo)) {
            return false;
        }
        CursoInfo other = (CursoInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.CursoInfo[ id=" + id + " ]";
    }
    
}
