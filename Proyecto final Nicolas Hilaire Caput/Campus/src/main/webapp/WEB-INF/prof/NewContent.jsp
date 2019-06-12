<%-- 
    Document   : NewCurso
    Created on : 26-mar-2019, 15:44:39
    Author     : Nicolas H. Caput
--%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">

<form name="formulario" method="post" action="ServletnewContent" enctype="multipart/form-data"
      style="margin-bottom: 50px;">
    <h2 class="center">Añadir Contenido</h2>
<%String[] ids = (String[]) request.getAttribute("Ids");%>
    <label>Nombre:</label> <br>
    <input type="text" id="nombre" name="nombre" required /><br> <br>

    <label>Fichero: </label> <br>
        <div class="file-field input-field">
      <div class="btn blue accent-2">
        <span>File</span>
        <input type="file" required name="file">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div>
    
    <input type="text" name="curso" value="<%=ids[0]%>" hidden="">
    <input type="text" name="tema" value="<%=ids[1]%>" hidden="">
    
    
    <input class="submit btn red accent-3" type="reset" name="limpiar"  value="Borrar los datos"/>
    <input id="enviar" class="submit btn blue accent-2 right" type="submit"  name="enviar" value="Subir"  />
    

</form>
</div>
<div class="col s12 m4 l4"></div>