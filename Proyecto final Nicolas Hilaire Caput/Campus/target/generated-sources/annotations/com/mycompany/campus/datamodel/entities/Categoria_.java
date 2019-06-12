package com.mycompany.campus.datamodel.entities;

import com.mycompany.campus.datamodel.entities.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T12:12:52")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile CollectionAttribute<Categoria, Curso> cursoCollection;
    public static volatile SingularAttribute<Categoria, String> categoria;
    public static volatile SingularAttribute<Categoria, Integer> id;

}