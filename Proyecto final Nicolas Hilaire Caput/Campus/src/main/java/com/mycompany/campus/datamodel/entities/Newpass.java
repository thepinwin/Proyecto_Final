/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WEB 2
 */
@Entity
@Table(name = "newpass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newpass.findAll", query = "SELECT n FROM Newpass n"),
    @NamedQuery(name = "Newpass.findById", query = "SELECT n FROM Newpass n WHERE n.id = :id"),
    @NamedQuery(name = "Newpass.findByMail", query = "SELECT n FROM Newpass n WHERE n.mail = :mail"),
    @NamedQuery(name = "Newpass.findByToken", query = "SELECT n FROM Newpass n WHERE n.token = :token"),
    @NamedQuery(name = "Newpass.findByFechaFin", query = "SELECT n FROM Newpass n WHERE n.fechaFin = :fechaFin")})
public class Newpass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public Newpass() {
    }

    public Newpass(Integer id) {
        this.id = id;
    }

    public Newpass(Integer id, String mail, String token, Date fechaFin) {
        this.id = id;
        this.mail = mail;
        this.token = token;
        this.fechaFin = fechaFin;
    }

    public Newpass(String mail, String token, Date fechaFin) {
        this.mail = mail;
        this.token = token;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
        if (!(object instanceof Newpass)) {
            return false;
        }
        Newpass other = (Newpass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.Newpass[ id=" + id + " ]";
    }

}
