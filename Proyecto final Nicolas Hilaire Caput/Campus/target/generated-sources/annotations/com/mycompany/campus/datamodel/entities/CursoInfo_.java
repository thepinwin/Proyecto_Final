package com.mycompany.campus.datamodel.entities;

import com.mycompany.campus.datamodel.entities.Info;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T12:12:52")
@StaticMetamodel(CursoInfo.class)
public class CursoInfo_ { 

    public static volatile SingularAttribute<CursoInfo, String> texto;
    public static volatile CollectionAttribute<CursoInfo, Info> infoCollection;
    public static volatile SingularAttribute<CursoInfo, Integer> idCurso;
    public static volatile SingularAttribute<CursoInfo, Integer> id;

}