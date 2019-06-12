<%-- 
    Document   : SignupProfesor
    Created on : 26-mar-2019, 13:21:16
    Author     : WEB 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;"> <br>
<a href="ServletNoSignupProfe?id=empresa" class='deep-orange lighten-1 btn-small right'>Empresa</a>
    <h1 class="center-align">Registro Profesores</h1>
        
        <form method="POST" action="ServletSignupProfe">
        <label for="nombre">Nombre:</label> </br>
        <input id="nombre" type="text" name="nombre"/></br>
        <label for="apellido">Apellidos:</label> </br>
        <input id="apellido" type="text" name="apellido"/></br>
        <label for="mail">Mail</label></br>
        <input id="mail" type="text" name="mail"/></br>
        <label for="contra">Contraseña:</label></br>
        <input id="pass" type="password" name="password"/></br>
        <label for="comunidad">Comunidad:</label> </br>
        <input id="comunidad" type="text" name="comunidad"/></br>
        </br>        
        <label for="dni">DNI:</label> </br>
        <input id="dni" type="text" name="dni"/></br>
        <input class="btn blue accent-2 right" type="submit" value="Regitrarse"/> </br></br>
        </form>
</div>
<div class="col s12 m4 l4"></div>