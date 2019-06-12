<%-- 
    Document   : NewPass
    Created on : 21-may-2019, 10:10:10
    Author     : WEB 2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">

    <%  String valor = (String) request.getAttribute("id");
        if ((String) request.getAttribute("ok") != null) {%>

    <h3 style="color: red">Corrreo incorrecto</h3>
    <%}%>

    <h3 class="center">Restablecer Contraseña</h3>
    <h5>Ayuda para identificarte</h5>
    <form method="POST" action="ServletNewPassProf">
        <p>Introduce la dirección de correo electrónico asociada a tu cuenta:</p>
        <label for="contra">Nueva Contraseña:</label></br>
        <input id="pass1" type="password" name="password1"/></br></br>

        <label for="contra">Repite la nueva contraseña:</label></br>
        <input id="pass2" type="password" name="password2"/></br></br>

        <input type="text" name="is" value="<%=valor%>" hidden="">

        <input id="enviar" class="btn  blue accent-2 right" type="submit" value="Enviar"/></br></br>
        
        <div class="progress">
            <div class="indeterminate"></div>
        </div>
    </form></br>
</div>
<div class="col s12 m4 l4"></div>
<script>

    $(document).ready(function () {
        $(".progress").hide();

    });

    $("#enviar").click(function () {

        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;

        // Nombre
        if (pass1 == pass2) {
            $(".progress").show();
            return true;
        } else {

            return false;
        }
    });
</script>