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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author thepinguin
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findById", query = "SELECT c FROM Curso c WHERE c.id = :id"),
    @NamedQuery(name = "Curso.findByTitulo", query = "SELECT c FROM Curso c WHERE c.titulo = :titulo"),
    @NamedQuery(name = "Curso.findByUrlFoto", query = "SELECT c FROM Curso c WHERE c.urlFoto = :urlFoto"),
    @NamedQuery(name = "Curso.findByUrlPdf", query = "SELECT c FROM Curso c WHERE c.urlPdf = :urlPdf"),
    @NamedQuery(name = "Curso.findByUrlVideo", query = "SELECT c FROM Curso c WHERE c.urlVideo = :urlVideo"),
    @NamedQuery(name = "Curso.findByFecha", query = "SELECT c FROM Curso c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Curso.findByIdProfesor", query = "SELECT c FROM Curso c WHERE c.idProfesor = :idProfesor"),
    @NamedQuery(name = "Curso.findByPublicado", query = "SELECT c FROM Curso c WHERE c.publicado = :publicado"),
    @NamedQuery(name = "Curso.findByPrecio", query = "SELECT c FROM Curso c WHERE c.precio = :precio"),
    @NamedQuery(name = "Curso.findByFechaDuracion", query = "SELECT c FROM Curso c WHERE c.fechaDuracion = :fechaDuracion"),
    @NamedQuery(name = "Curso.findByIdEmpresa", query = "SELECT c FROM Curso c WHERE c.idEmpresa = :idEmpresa")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "url_foto")
    private String urlFoto;
    @Size(max = 200)
    @Column(name = "url_pdf")
    private String urlPdf;
    @Size(max = 200)
    @Column(name = "url_video")
    private String urlVideo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "idProfesor")
    private Integer idProfesor;
    @Column(name = "publicado")
    private Short publicado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "fecha_duracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDuracion;
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    public Curso() {
    }

    public Curso(Integer id) {
        this.id = id;
    }

        public Curso(Integer id, String titulo, String descripcion, Date fecha, BigDecimal precio) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
    }
    
    public Curso(String titulo, String descripcion, String urlFoto, String urlPdf, String urlVideo, Date fecha, int idProfesor, 
            BigDecimal precio, Short publicado, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.urlPdf = urlPdf;
        this.urlVideo = urlVideo;
        this.fecha = fecha;
        this.idProfesor = idProfesor;
        this.precio = precio;
        this.publicado = publicado;
        this.categoria = categoria;
    }
    
    public Curso(String titulo, String descripcion, String urlFoto, String urlPdf, String urlVideo, Date fecha,BigDecimal precio, 
            Short publicado, int idEmpresa, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.urlPdf = urlPdf;
        this.urlVideo = urlVideo;
        this.fecha = fecha;
        this.idEmpresa = idEmpresa;
        this.precio = precio;
        this.publicado = publicado;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlPdf() {
        return urlPdf;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Short getPublicado() {
        return publicado;
    }

    public void setPublicado(Short publicado) {
        this.publicado = publicado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaDuracion() {
        return fechaDuracion;
    }

    public void setFechaDuracion(Date fechaDuracion) {
        this.fechaDuracion = fechaDuracion;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.campus.datamodel.entities.Curso[ id=" + id + " ]";
    }
    
}
