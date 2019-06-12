<%-- 
    Document   : compras
    Created on : 09-may-2019, 10:08:55
    Author     : WEB 2
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mycompany.campus.datamodel.entities.CursoTema"%>
<%@page import="com.mycompany.campus.datamodel.entities.RegistroCompra"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.campus.datamodel.entities.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col s12 m2 l2 "></div>
<div class="col s12 m8 l8 " style="background-color: #f3f1ec;">
    <h1>Registro de Compras</h1>

    <%HashMap<Integer, List<RegistroCompra>> hashMap = (HashMap) request.getAttribute("regis");

        if (hashMap != null) {

            for (HashMap.Entry<Integer, List<RegistroCompra>> entry : hashMap.entrySet()) {
  //  System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());


    %>
    <div class="row" id="fac">
        <div class="col s12 m12 l12">
            <div class="card blue-grey lighten-4 ">
                <div class="card-content ">
                    <span class="card-title">Nº <%=entry.getKey()%></span>


                    <table>
                        <thead>
                            <tr>
                                <th>Articulo</th>
                                <th>IVA</th>
                                <th>Total Precio</th>
                            </tr>
                        </thead>
                        <%  BigDecimal total = new BigDecimal(0);
                        
                        for (RegistroCompra e : entry.getValue()) {
                            total = total.add(e.getPrecio())  ;
                        %>
                        <tbody>
                            <tr>
                                <td><%=entry.getKey()%></td>
                                <td><%=e.getIva()%>€</td>
                                <td class="price"><%=e.getPrecio()%></td>
                            </tr>
                            <%
                                }%>

                            <tr>
                                <td></td>
                                <td></td>
                                <td id="total"><%=total%> €</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <%}
        }%>
</div>
<div class="col s12 m2 l2"></div>
