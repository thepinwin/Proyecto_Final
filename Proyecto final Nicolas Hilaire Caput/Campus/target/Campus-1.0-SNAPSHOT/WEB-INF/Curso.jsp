<%-- 
    Document   : Curso
    Created on : 02-abr-2019, 13:09:27
    Author     : WEB 2
--%>
<%@page import="com.mycompany.campus.datamodel.entities.Tema"%>
<%@page import="com.mycompany.campus.datamodel.entities.CursoTema"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.campus.datamodel.entities.Info"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.campus.datamodel.entities.Curso"%>
<% Curso cur = (Curso) request.getAttribute("curso");%>
<div class="container" style="background-color: white">
    <div class="row">
        <div class="col s12 m4 l4" style="margin-top: 2%">
            <img class="responsive-img" src="<%=request.getContextPath()%>/Desc/<%=cur.getUrlFoto()%>" height="270" width="400"
                 style="border: solid 2px black;">
        </div>

        <div class="col s12 m3 l3.5">
            <h3 style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;  "><%=cur.getTitulo()%></h3>
            <p><i>Autor:</i></p>
            <p><%=(String) request.getAttribute("autor")%></p>
            <p><i>Fecha de la última actualización:</i></p>
            <p><%Calendar cal = Calendar.getInstance();
                cal.setTime(cur.getFecha());%>
                <%=cal.get(Calendar.DAY_OF_MONTH)%>/<%=cal.get(Calendar.MONTH)%>/<%=cal.get(Calendar.YEAR)%></p>
        </div>

        <div class="col s12 m5 l5" style="margin-top: 1.5%">
            <div class="card-panel grey center-align lighten-3">
                <h3>Información</h3>
                <a class="waves-effect modal-trigger waves-purple btn orange darken-1" href="#modal4" style="width:  80%;text-overflow: ellipsis; "><i class="material-icons left">info</i>Que incluye el curso</a>
                <br><br>
                <a class="waves-effect modal-trigger waves-purple btn orange darken-1 " href="#modal5" style="width:  80%;text-overflow: ellipsis; "><i class="material-icons left">info</i>Lo que aprenderas</a>

            </div>
        </div>

    </div>

    <div class="col s12" style="background-color: white; margin-top: -20px;">
        <h5>Descripción del curso: </h5>
        <p><i><%=cur.getDescripcion()%></i></p> 

        <%  boolean ok = false;
            if (session.getAttribute("logClien") != null && request.getAttribute("ok") != null) {
                if (((String) request.getAttribute("ok")).equals("true")) {
                    ok = true;
        %>



        <% if (cur.getUrlPdf() != null) {%>
        <a class="waves-effect waves-light btn" target="_blank" href="<%=request.getContextPath()%>/Desc/<%=cur.getUrlPdf()%>"><i class="material-icons left">cloud_download</i>Descargar PDF</a>
        <%}%>
        <% if (cur.getUrlVideo() != null) {%>
        <a class="waves-effect waves-light btn" href="ServletCursoVideo?id=<%=cur.getUrlVideo()%>"><i class="material-icons left">ondemand_video</i>Video</a>
        <%}%>



        <a class="waves-effect waves-light btn-large light-blue accent-2" style="margin: 1%;" href="Curso?curso=<%=cur.getId()%>">Ir al Curso</a>
        <%} else {%>
        <a class="waves-effect waves-light btn-large modal-trigger" href="#modal6"><i class="material-icons left">add</i>Adquirir Curso</a>
        <%}
        } else {%>
        <a class="waves-effect waves-light btn-large modal-trigger" href="#modal6"><i class="material-icons left">add</i>Adquirir Curso</a>
        <%}%></br></br>

        <% ArrayList map = (ArrayList) request.getAttribute("temas");

            if (map != null) {%>


        <h5>Temas</h5>
        <%if (!ok) {


        %>
        <form action="ServletAddNewCurso" method="POST">
            <a class="waves-effect waves-light btn blue accent-2 modal-trigger" href="#modal7"><i class="material-icons left">add</i>Comprar Seleccionados</a>
            <!--<input type="submit" class="btn blue accent-2" value="Comprar Seleccionados"/>--> 
            <input type="text" name="id" value="<%=cur.getId()%>" hidden="">
            <%}%>
            <ul class="collapsible expandable">
                <%for (int i = 0; i < map.size(); i = i + 1) {
                        CursoTema key = (CursoTema) map.get(i);

                %>
                <li>
                    <div class="collapsible-header">

                        <i class="material-icons">book</i><span style="width: 90%" class="left-align"><%=key.getTitulo()%></span>
                        <label >
                            <input type="checkbox" class="filled-in" name="temas" value="<%=key.getId()%>"/>
                            <span style="color: black"><%=key.getPrecio()%>€</span>
                        </label>
                    </div>

                    <div class="collapsible-body"> 
                        <div class="collection">

                        </div>
                    </div>
                </li>

                <%}%>
            </ul>
            <%}%>

            <!--                <div class="modal-content">
                    <h3 style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;">Pasos a seguir para la compra del curso</h3>
                    <ul>
                        <li>- Realiza la transferencia a la cuenta bancaria de que se le ha facilitado en el correo.</li>
                        <li>- Responde al correo con el recibo y el numero de factura.</li>
                        <li>- Recibirá un código para activar el curso.</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <a href="ServletAddNewCurso?ids=<%=cur.getId()%>" class="modal-close waves-effect waves-green btn blue">Comprar</a>
                </div>  -->
            <div id="modal7" class="modal">

                <div class="modal-content">
                    <h3 style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;">Pasos a seguir para la compra del curso</h3>
                    <ul>
                        <li>- Realiza la transferencia a la cuenta bancaria de que se le ha facilitado en el correo.</li>
                        <li>- Responde al correo con el recibo y el numero de factura.</li>
                        <li>- Recibirá un código para activar el curso.</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn blue accent-2" value="Comprar Seleccionados"/>
                </div>  
            </div>

        </form>
    </div>

</div>

<div id="modal4" class="modal" style="background-color:rgba(0, 0, 0, 0);">
    <% List<Info> info = (List<Info>) request.getAttribute("info");%>

    <ul class="collection with-header">
        <li class="collection-header"><h4>QUE INCLUYE EL CURSO</h4></li>
            <% if (info != null) {%>
            <%for (Info fos : info) {

            %>
        <li class="collection-item"> <i class="material-icons left" style="color: #bdbdbd">chevron_right</i><div><%=fos.getTexto()%></div></li>
            <%}
            %>      </ul>
        <%}
        %>   
</div>

<div id="modal5" class="modal" style="background-color:rgba(0, 0, 0, 0);">
    <% List<Info> infos = (List<Info>) request.getAttribute("apre");%>

    <ul class="collection with-header">
        <li class="collection-header"><h4>LO QUE VAS APRENDER</h4></li>
            <% if (infos != null) {%>
            <%for (Info fos : infos) {

            %>
        <li class="collection-item"> <i class="material-icons left" style="color: #bdbdbd">chevron_right</i><div><%=fos.getTexto()%></div></li>
            <%}
            %>      </ul>
        <%}
        %>   
</div>


<div id="modal6" class="modal">

    <div class="modal-content">
        <h3 style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;">Pasos a seguir para la compra del curso</h3>
        <ul>
            <li>- Realiza la transferencia a la cuenta bancaria de que se le ha facilitado en el correo.</li>
            <li>- Responde al correo con el recibo y el numero de factura.</li>
            <li>- Recibirá un código para activar el curso.</li>
        </ul>
    </div>
    <div class="modal-footer">
        <a href="ServletAddNewCurso?ids=<%=cur.getId()%>" class="modal-close waves-effect waves-green btn blue">Comprar</a>
    </div>  
</div>


<script>
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems);
    });
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.collapsible');
        var instances = M.Collapsible.init(elems);
    });
</script>