/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WEB 2
 */
@Entity
@Table(name = "registro_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroCompra.findAll", query = "SELECT r FROM RegistroCompra r"),
    @NamedQuery(name = "RegistroCompra.findById", query = "SELECT r FROM RegistroCompra r WHERE r.id = :id"),
    @NamedQuery(name = "RegistroCompra.findByIdFactura", query = "SELECT r FROM RegistroCompra r WHERE r.idFactura = :idFactura"),
    @NamedQuery(name = "RegistroCompra.findByIdCliente", query = "SELECT r FROM RegistroCompra r WHERE r.idCliente = :idCliente"),
    @NamedQuery(name = "RegistroCompra.findByIdCurso", query = "SELECT r FROM RegistroCompra r WHERE r.idCurso = :idCurso"),
    @NamedQuery(name = "RegistroCompra.findByIdTema", query = "SELECT r FROM RegistroCompra r WHERE r.idTema = :idTema"),
    @NamedQuery(name = "RegistroCompra.findByFecha", query = "SELECT r FROM RegistroCompra r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RegistroCompra.findByPrecioBase", query = "SELECT r FROM RegistroCompra r WHERE r.precioBase = :precioBase"),
    @NamedQuery(name = "RegistroCompra.findByIva", query = "SELECT r FROM RegistroCompra r WHERE r.iva = :iva"),
    @NamedQuery(name = "RegistroCompra.findByPrecio", query = "SELECT r FROM RegistroCompra r WHERE r.precio = :precio")})
public class RegistroCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_factura")
    private int idFactura;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_base")
    private BigDecimal precioBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private BigDecimal iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;

    public RegistroCompra() {
    }

    public RegistroCompra(Integer id) {
        this.id = id;
    }

    public RegistroCompra(Integer id, int idFactura, int idCliente, int idCurso, int idTema, Date fecha, BigDecimal precioBase, BigDecimal iva, BigDecimal precio) {
        this.id = id;
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idCurso = idCurso;
        this.idTema = idTema;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.iva = iva;
        this.precio = precio;
    }
    
    public RegistroCompra(int idFactura, int idCliente, int idCurso, Date fecha, BigDecimal precioBase, BigDecimal iva, BigDecimal precio) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idCurso = idCurso;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.iva = iva;
        this.precio = precio;
    }
    
    public RegistroCompra(int idFactura, int idCliente, int idCurso,int idTema, Date fecha, BigDecimal precioBase, BigDecimal iva, BigDecimal precio) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idCurso = idCurso;
        this.idTema = idTema;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.iva = iva;
        this.precio = precio;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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
        if (!(object instanceof RegistroCompra)) {
            return false;
        }
        RegistroCompra other = (RegistroCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.RegistroCompra[ id=" + id + " ]";
    }
    
}
