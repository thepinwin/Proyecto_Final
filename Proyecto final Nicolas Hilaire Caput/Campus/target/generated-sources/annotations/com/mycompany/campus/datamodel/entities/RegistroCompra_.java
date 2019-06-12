package com.mycompany.campus.datamodel.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-12T12:12:52")
@StaticMetamodel(RegistroCompra.class)
public class RegistroCompra_ { 

    public static volatile SingularAttribute<RegistroCompra, Date> fecha;
    public static volatile SingularAttribute<RegistroCompra, BigDecimal> precio;
    public static volatile SingularAttribute<RegistroCompra, Integer> idCliente;
    public static volatile SingularAttribute<RegistroCompra, BigDecimal> precioBase;
    public static volatile SingularAttribute<RegistroCompra, Integer> idTema;
    public static volatile SingularAttribute<RegistroCompra, BigDecimal> iva;
    public static volatile SingularAttribute<RegistroCompra, Integer> idFactura;
    public static volatile SingularAttribute<RegistroCompra, Integer> idCurso;
    public static volatile SingularAttribute<RegistroCompra, Integer> id;

}