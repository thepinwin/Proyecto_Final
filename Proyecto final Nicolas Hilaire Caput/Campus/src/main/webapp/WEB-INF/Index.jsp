<%-- 
    Document   : Index
    Created on : 26-mar-2019, 10:03:03
    Author     : WEB 2
--%>

<%@page import="com.mycompany.campus.datamodel.entities.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
if (cursos != null) {
    if (cursos.size() > 3) {%>

<div class="slider" style="margin-top: -50px">
    <ul class="slides">
        <li>
 +           <img src="<%=request.getContextPath()%>/Desc/<%=((Curso) cursos.get(0)).getUrlFoto()%>">
            <div class="caption center-align">
                
            </div>
        </li>
        <li>
            <img src="<%=request.getContextPath()%>/Desc/<%=((Curso) cursos.get(1)).getUrlFoto()%>">
            <div class="caption left-align">

            </div>
        </li>
        <li>
            <img src="<%=request.getContextPath()%>/Desc/<%=((Curso) cursos.get(2)).getUrlFoto()%>">
            <div class="caption right-align">
            </div>
        </li>
        <li>
            <img src="<%=request.getContextPath()%>/Desc/<%=((Curso) cursos.get(3)).getUrlFoto()%>"> 
            <div class="caption center-align">
            </div>
        </li>
    </ul>
</div>
<div class="row">
    <div class="col s12 m1 l1 "></div>

    <div class="container" >
        <div style="background-color: #f5f4ef">
        <%}}
            if (cursos != null) {

                for (Curso cur : cursos) {%>

        <div class="col s12 m4 l4">

            <div class="card">
                <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="<%=request.getContextPath()%>/Desc/<%=cur.getUrlFoto()%>" height="200">
                </div>
                <div class="card-content">
                    <span class="card-title truncate activator grey-text text-darken-4"><%=cur.getTitulo()%></span><i class="material-icons activator right">expand_less</i>
                    <p><a href="ServletCurso?curso=<%=cur.getId()%>">Adquirir Curso</a><span class="new badge deep-orange darken-2" data-badge-caption="<%=cur.getPrecio()%> €" style="float: right"></span></p> 
                </div>
                <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4"><%=cur.getTitulo()%><i class="material-icons right">close</i></span>
                    <p><%=cur.getDescripcion()%></p>
                </div>
            </div>
        </div>
        <%}
            }%>

</div>
    </div>
    <div class="col s12 m1 l1 "></div>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.slider');
            var instances = M.Slider.init(elems);
        });
    </script>
</div>