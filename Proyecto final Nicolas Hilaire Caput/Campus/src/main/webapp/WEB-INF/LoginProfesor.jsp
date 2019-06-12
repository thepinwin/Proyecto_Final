<%-- 
    Document   : LoginProfesor
    Created on : 26-mar-2019, 13:20:42
    Author     : WEB 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">
    <h1 class="center">Iniciar sesión Prof/Empre</h1>

<form method="POST" action="ServletLoginProf">
    <label for="mail">Mail</label></br>
    <input id="mail" type="text" name="mail"/></br>

    <label for="contra">Contraseña:</label></br>
    <input id="pass" type="password" name="password"/></br></br>
    <input class="btn  blue accent-2 right" type="submit" value="Iniciar sesión"/></br></br>
    <p class="right">Se ha olvidad la contraseña. <a href="ServletResetPassProf?id=pass">Restablecer Contraseña.</a></p>
</form>
</div>
<div class="col s12 m4 l4"></div>