<%-- 
    Document   : CursoProf
    Created on : 03-abr-2019, 15:47:02
    Author     : WEB 2
--%>

<%@page import="com.mycompany.campus.datamodel.entities.Profesor"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.mycompany.campus.datamodel.entities.Info"%>
<%@page import="com.mycompany.campus.datamodel.entities.CursoTema"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mycompany.campus.datamodel.entities.Tema"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.mycompany.campus.datamodel.entities.Curso"%>
<% Curso cur = (Curso) request.getAttribute("cursoProf");%>

<div class="container" style="background-color: white">
    <div class="row">
        <div class="col s12 m4 l4" style="margin-top: 2%; ">
            <img class="responsive-img" src="<%=request.getContextPath()%>/Desc/<%=cur.getUrlFoto()%>" height="270" width="400"
                 style="border: solid 2px black;">
        </div>

        <div class="col s12 m3 l3">
            <h3 style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;  "><%=cur.getTitulo()%></h3>
            <p><i>Autor:</i></p>
            <p><%=((Profesor) session.getAttribute("logProf")).getNombre()%></p>
            <p><i>Fecha de la última actualización:</i></p>
            <p><%Calendar cal = Calendar.getInstance();
                cal.setTime(cur.getFecha());%>
                <%=cal.get(Calendar.DAY_OF_MONTH)%>/<%=cal.get(Calendar.MONTH)%>/<%=cal.get(Calendar.YEAR)%></p>
        </div>


        <div class="col s12 m5 l5" style="margin-top: 1.5%">
            <div class="card-panel grey center-align lighten-3">
                <h3>Información</h3>
                <h4 class=""><%=cur.getPrecio()%>€</h4>
                <a class="waves-effect modal-trigger waves-purple btn orange darken-1" href="#modal4" style="width:  70%;"><i class="material-icons left">info</i>Que incluye el curso</a>
                <% if (cur.getPublicado() != 1) {%>
                <a  class="btn-floating modal-trigger tooltipped" data-position="right" data-tooltip="Resumen del contenido" href="#modal2"><i class="material-icons">add</i></a>
                <%}%>
                <br> <br><a class="waves-effect modal-trigger waves-purple btn orange darken-1" href="#modal5" style="width:  70%;"><i class="material-icons left">info</i>Lo que aprenderas</a>
                <% if (cur.getPublicado() != 1) {%>
                <a class="btn-floating modal-trigger tooltipped" data-position="right" data-tooltip="Que va aprender el cliente" href="#modal3"><i class="material-icons">add</i></a>
                <%}%>
                <br><br><div class="switch" >
                    <% if (cur.getPublicado() > 0) {%>

                    <div>
                        <h5>Curso Publicado!!</h5>
                        <label class="tooltipped" data-tooltip="¡Curso Publicado!">
                            Off
                            <input disabled type="checkbox"  class="modal-trigger" checked="">
                            <span class="lever"></span>
                            On
                        </label>
                    </div>
                    <%} else {%>

                    <div>
                        <h5>¡Publicar Curso!</h5>
                        <label class="tooltipped" data-tooltip="¡Publicar Curso!">
                            Off
                            <input type="checkbox" href="#modal6" class="modal-trigger">
                            <span class="lever"></span>
                            On
                        </label>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
    <div class="col s12" style="background-color: white; margin-top: -20px;">
        <h5>Descripción del curso: </h5>
        <p><i><%=cur.getDescripcion()%></i></p> 


        <div >

            <% if (cur.getUrlPdf() != null) {%>
            <a class="waves-effect waves-light btn" target="_blank" href="<%=request.getContextPath()%>/Desc/<%=cur.getUrlPdf()%>"><i class="material-icons left">cloud_download</i>Descargar PDF</a>
            <%}%>
            <% if (cur.getUrlVideo() != null) {%>
            <a class="waves-effect waves-light btn" href="ServletCursoVideo?id=<%=cur.getUrlVideo()%>"><i class="material-icons left">ondemand_video</i>Video</a>
            <%}%>
        </div>

        <br>

        <% if (cur.getPublicado() != 1) {%>
        <a class="waves-effect waves-light btn modal-trigger blue accent-2" href="#modal1"><i class="material-icons left">add_box</i>Añadir tema</a>
        <a href="DropCurso?curso=<%=cur.getId()%>" id="borrar" class="waves-effect waves-light btn red accent-3 right"><i class="material-icons left">delete_forever</i>Borrar Curso</a>

        <%}
            ArrayList map = (ArrayList) request.getAttribute("temas");

            if (map != null) {%>
        <h5>Temas</h5>
        <ul class="collapsible expandable">
            <%for (int i = 0; i < map.size(); i = i + 2) {
                    CursoTema key = (CursoTema) map.get(i);
                    List<Tema> value = (List<Tema>) map.get(i + 1);
            %>
            <li>
                <div class="collapsible-header">

                    <i class="material-icons">book</i><span style="width: 90%" class="left-align"><%=key.getTitulo()%></span>

                    <span style="margin-left: 0px"><%=key.getPrecio()%>€</span>

                </div>

                <div class="collapsible-body"> 
                    <div class="collection">
                        <% if (cur.getPublicado() != 1) {%>
                        <a href="NoServletContent?curso=<%=cur.getId()%>&tema=<%=key.getId()%>" class="waves-effect waves-light btn-small"><i class="material-icons left">add</i>Añadir contenido</a> </br></br>
                        <a href="ServletDropTema?curso=<%=cur.getId()%>&tema=<%=key.getId()%>" id="borrar" class="waves-effect waves-light btn-small red accent-3"><i class="material-icons left">delete</i>Borrar Tema</a>
                        <% }
                            if (value != null) {
                                for (Tema algo : value) {%>

                        <a href="<%=request.getContextPath()%>/Desc/<%=algo.getUrl()%>" target="_blank" class="collection-item"><%=algo.getNombre()%></a>

                        <%}
                            }%>
                    </div>
                </div>
            </li>

            <%}%>
        </ul>
        <%}%>
    </div>
    <script>

        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.collapsible');
            var instances = M.Collapsible.init(elems);
        });


        var elem = document.querySelector('.collapsible.expandable');
        var instance = M.Collapsible.init(elem, {
            accordion: false
        });

        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.modal');
            var instances = M.Modal.init(elems);
        });

        $(document).ready(function () {
            $("#borrar").click(function () {
                var result = confirm("¿Seguro que quiere borrar el Curso?");

                if (result) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.tooltipped');
            var instances = M.Tooltip.init(elems);
        });

    </script>



</div>

<div id="modal1" class="modal">
    <form action="ServletNewTema">

        <div class="modal-content">

            <h3 class="center-align" style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;">Nuevo Tema</h3>

            <label>Título del Tema:</label><br>
            <input type="text" name="titulo" required>

            <label>Precio(?):</label> <br>
            <input  type="number" name="precio" step="0.01" required >
            <input type="text" name="curso" value="<%=cur.getId()%>" hidden="">

        </div>
        <div class="modal-footer">
            <input type="submit" value="Nuevo Tema" class="waves-effect waves-light btn blue accent-2">
        </div>
    </form> 
</div>

<div id="modal2" class="modal">
    <form action="ServletInfo">

        <div class="modal-content">

            ¿Que incluye el curso?<br>
            <input type="text" name="text">
            <input type="text" name="curso" value="<%=cur.getId()%>" hidden="">
            <input type="text" name="tipo" value="info" hidden="">

        </div>
        <div class="modal-footer">
            <input type="submit" value="Crear" class="waves-effect waves-light btn blue accent-2">
        </div>

    </form> 
</div>

<div id="modal3" class="modal">
    <form action="ServletInfo">

        <div class="modal-content">

            ¿Que se aprendera en el curso?<br>
            <input type="text" name="text">
            <input type="text" name="curso" value="<%=cur.getId()%>" hidden="">
            <input type="text" name="tipo" value="apre" hidden="">

        </div>
        <div class="modal-footer">
            <input type="submit" value="Crear" class="waves-effect waves-light btn blue accent-2">
        </div>

    </form> 
</div>

<div id="modal4" class="modal">
    <% List<Info> info = (List<Info>) request.getAttribute("info");%>
    <% if (cur.getPublicado() != 1) {%>


    <ul class="collection with-header">
        <li class="collection-header"><h4>QUE INCLUYE EL CURSO</h4></li>
            <% if (info != null) {%>
            <%for (Info fos : info) {

            %>
        <li class="collection-item"><div><%=fos.getTexto()%><a href="DropInfo?info=<%=fos.getId()%>&curso=<%=cur.getId()%>" class="secondary-content">
                    <i class="material-icons" style="color: red">delete</i></a></div></li>
        <%}%>      </ul>
        <%}
        } else {%>  

    <ul class="collection with-header">
        <li class="collection-header"><h4>QUE INCLUYE EL CURSO</h4></li>
            <% if (info != null) {%>
            <%for (Info fos : info) {

            %>
        <li class="collection-item"><%=fos.getTexto()%></li>
        <%}%>      </ul>

    <%}}%>
</div>

<div id="modal5" class="modal">
    <% List<Info> infos = (List<Info>) request.getAttribute("apre");%>
    <% if (cur.getPublicado() != 1) {%>


    <ul class="collection with-header">
        <li class="collection-header"><h4>QUE INCLUYE EL CURSO</h4></li>
            <% if (infos != null) {%>
            <%for (Info fos : infos) {

            %>
        <li class="collection-item"><div><%=fos.getTexto()%><a href="DropInfo?info=<%=fos.getId()%>&curso=<%=cur.getId()%>" class="secondary-content">
                    <i class="material-icons" style="color: red">delete</i></a></div></li>
        <%}%>      </ul>
        <%}
        } else {%>  

    <ul class="collection with-header">
        <li class="collection-header"><h4>QUE INCLUYE EL CURSO</h4></li>
            <% if (info != null) {%>
            <%for (Info fos : infos) {

            %>
        <li class="collection-item"><%=fos.getTexto()%></li>
        <%}%>      </ul>

    <%}}%> 
</div>

<div id="modal6" class="modal">
    <div style="padding: 3%">
        <form action="ServletPublicar" method="POST">

            <h5>Publicar Curso <i class="material-icons" style="color: red">help_outline</i></h5>
            <p>Una vez publicado el curso,<b style="color: red"> es permanente, no se podra borrar ni añadir nuevos contenidos</b></p>
            <h6>Condicones de para publicar un curso:</h6>
            <ul>
                <li> - Todo tema creado tiene que tener contenidos.</li>

                <li> - El apartado de información los dos tiene que tener contenido.</li>
            </ul>
            <input type="text" name="curso" value="<%=cur.getId()%>" hidden="">

            <button type="submit" class="red-text waves-effect waves-light btn right orange lighten-1">Publicar</button>
            <br>
        </form>
    </div>
</div>