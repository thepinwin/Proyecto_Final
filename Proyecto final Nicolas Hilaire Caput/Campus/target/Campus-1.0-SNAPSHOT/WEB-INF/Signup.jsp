<%-- 
    Document   : signup
    Created on : 05-dic-2018, 15:52:14
    Author     : thepinguin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">

        <h1 class="center-align">Registro</h1>
        
        <form method="POST" action="ServletFormulario">
        <label for="nombre">Nombre:</label> </br>
        <input id="nombre" type="text" name="nombre"/></br>
        <label for="apellido">Apellidos:</label> </br>
        <input id="apellido" type="text" name="apellido"/></br>
        <label for="mail">Mail</label></br>
        <input id="mail" type="text" name="mail"/></br>
        <label for="contra">Contraseña:</label></br>
        <input id="pass" type="password" name="password"/></br>
        </br>        
        <input class="btn blue accent-2 right" type="submit" value="Registrarse"/></br></br>
        </form>

</div>
<div class="col s12 m4 l4"></div>