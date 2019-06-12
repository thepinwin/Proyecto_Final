package com.mycompany.campus.datamodel.entities;

import com.mycompany.campus.datamodel.entities.Categoria;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T12:12:52")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> descripcion;
    public static volatile SingularAttribute<Curso, String> urlVideo;
    public static volatile SingularAttribute<Curso, String> urlFoto;
    public static volatile SingularAttribute<Curso, Categoria> categoria;
    public static volatile SingularAttribute<Curso, String> titulo;
    public static volatile SingularAttribute<Curso, Date> fecha;
    public static volatile SingularAttribute<Curso, BigDecimal> precio;
    public static volatile SingularAttribute<Curso, Integer> idProfesor;
    public static volatile SingularAttribute<Curso, Date> fechaDuracion;
    public static volatile SingularAttribute<Curso, Integer> idEmpresa;
    public static volatile SingularAttribute<Curso, Integer> id;
    public static volatile SingularAttribute<Curso, String> urlPdf;
    public static volatile SingularAttribute<Curso, Short> publicado;

}