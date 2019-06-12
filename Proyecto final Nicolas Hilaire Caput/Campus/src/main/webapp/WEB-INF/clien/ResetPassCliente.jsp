<%-- 
    Document   : ResetPassCliente
    Created on : 20-may-2019, 15:26:13
    Author     : WEB 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">
    
    <% if(request.getAttribute("ok") != null){
        
    
        
    
    if(((String)request.getAttribute("ok")).equals("nop")){%>
    
    <h3 style="color: red">Corrreo incorrecto</h3>
    <%}else if(((String)request.getAttribute("ok")).equals("sep")){%>
    incorrecto
     <h3 style="color: red">Verificación caducada</h3>
     
     <%}}%>
    
    <h3 class="center">Restablecer Contraseña</h3>
    <h5>Ayuda para identificarte</h5>
    <form method="POST" action="ServletResetPass">
        <p>Introduce la dirección de correo electrónico asociada a tu cuenta:</p>
        <label for="email">Email</label>
        <input id="email" type="email" name="mail" class="validate">

        <input class="btn  blue accent-2 right" type="submit" id="enviar" value="Enviar"/></br></br>
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
        $(".progress").show();

    });
</script>