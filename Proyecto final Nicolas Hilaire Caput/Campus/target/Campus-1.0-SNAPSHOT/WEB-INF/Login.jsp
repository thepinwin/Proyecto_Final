<%-- 
    Document   : login
    Created on : 10-dic-2018, 16:02:12
    Author     : thepinguin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">
    <h1 class="center" >Iniciar sesión</h1>
        
        <form method="POST" action="ServletLogin">
        <label for="mail">Mail</label></br>
        <input id="mail" type="text" name="mail"/></br>
        
        
        
        <label for="contra">Contraseña:</label></br>
        <input id="pass" type="password" name="password"/></br></br>
        <input class="btn  blue accent-2 right" type="submit" value="Iniciar Sesión"/></br></br>
        </form>
    <p class="right">Se ha olvidad la contraseña.<a href="ServletResetPass?id=pass">Restablecer Contraseña.</a></p>

</div>
<div class="col s12 m4 l4"></div>