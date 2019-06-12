package com.mycompany.campus.datamodel.entities;

import com.mycompany.campus.datamodel.entities.Tema;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T12:12:52")
@StaticMetamodel(CursoTema.class)
public class CursoTema_ { 

    public static volatile CollectionAttribute<CursoTema, Tema> temaCollection;
    public static volatile SingularAttribute<CursoTema, BigDecimal> precio;
    public static volatile SingularAttribute<CursoTema, Integer> idCurso;
    public static volatile SingularAttribute<CursoTema, String> titulo;
    public static volatile SingularAttribute<CursoTema, Integer> id;

}