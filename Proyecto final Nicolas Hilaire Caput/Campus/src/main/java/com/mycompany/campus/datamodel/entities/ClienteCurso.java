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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thepinguin
 */
@Entity
@Table(name = "cliente_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteCurso.findAll", query = "SELECT c FROM ClienteCurso c"),
    @NamedQuery(name = "ClienteCurso.findById", query = "SELECT c FROM ClienteCurso c WHERE c.id = :id"),
    @NamedQuery(name = "ClienteCurso.findByIdCliente", query = "SELECT c FROM ClienteCurso c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "ClienteCurso.findByIdCurso", query = "SELECT c FROM ClienteCurso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "ClienteCurso.findByIdTema", query = "SELECT c FROM ClienteCurso c WHERE c.idTema = :idTema"),
    @NamedQuery(name = "ClienteCurso.findByActive", query = "SELECT c FROM ClienteCurso c WHERE c.active = :active"),
    @NamedQuery(name = "ClienteCurso.findByRandom", query = "SELECT c FROM ClienteCurso c WHERE c.random = :random")})
public class ClienteCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso")
    private int idCurso;
    @Column(name = "id_tema")
    private Integer idTema;
    @Column(name = "active")
    private Integer active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "random")
    private int random;

    public ClienteCurso() {
    }

    public ClienteCurso(Integer id) {
        this.id = id;
    }

    public ClienteCurso(Integer id, int idCliente, int idCurso) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCurso = idCurso;
    }

    public ClienteCurso(int idCliente, int idCurso, int idTema, Integer random) {
        this.idCliente = idCliente;
        this.idCurso = idCurso;
        this.idTema = idTema;
        this.random = random;
    }

    public ClienteCurso(int idCliente, int idCurso) {
        this.idCliente = idCliente;
        this.idCurso = idCurso;
    }
    
    public ClienteCurso(int idCliente, int idCurso, Integer random) {
        this.idCliente = idCliente;
        this.idCurso = idCurso;
        this.random = random;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
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
        if (!(object instanceof ClienteCurso)) {
            return false;
        }
        ClienteCurso other = (ClienteCurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.ClienteCurso[ id=" + id + " ]";
    }
    
}
