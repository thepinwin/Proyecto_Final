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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WEB 2
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findById", query = "SELECT p FROM Profesor p WHERE p.id = :id"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByApellidos", query = "SELECT p FROM Profesor p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Profesor.findByMail", query = "SELECT p FROM Profesor p WHERE p.mail = :mail"),
    @NamedQuery(name = "Profesor.findByContrasenya", query = "SELECT p FROM Profesor p WHERE p.contrasenya = :contrasenya"),
    @NamedQuery(name = "Profesor.findByComunidad", query = "SELECT p FROM Profesor p WHERE p.comunidad = :comunidad"),
    @NamedQuery(name = "Profesor.findByDni", query = "SELECT p FROM Profesor p WHERE p.dni = :dni"),
    @NamedQuery(name = "Profesor.findByCif", query = "SELECT p FROM Profesor p WHERE p.cif = :cif")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenya")
    private String contrasenya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "comunidad")
    private String comunidad;
    @Size(max = 45)
    @Column(name = "DNI")
    private String dni;
    @Size(max = 45)
    @Column(name = "CIF")
    private String cif;

    public Profesor() {
    }

    public Profesor(Integer id) {
        this.id = id;
    }

    public Profesor(Integer id, String nombre, String apellidos, String mail, String contrasenya, String comunidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.contrasenya = contrasenya;
        this.comunidad = comunidad;
    }

    public Profesor(String nombre, String apellidos, String mail, String contrasenya, String comunidad, String dni) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.contrasenya = contrasenya;
        this.comunidad = comunidad;
        this.dni = dni;
    }

    public Profesor(String nombre, String mail, String contrasenya, String comunidad, String cif) {
        this.nombre = nombre;
        this.mail = mail;
        this.contrasenya = contrasenya;
        this.comunidad = comunidad;
        this.cif = cif;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.Profesor[ id=" + id + " ]";
    }

}
