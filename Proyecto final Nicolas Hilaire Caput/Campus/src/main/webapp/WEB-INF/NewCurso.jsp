<%-- 
    Document   : NewCurso
    Created on : 26-mar-2019, 15:44:39
    Author     : Nicolas H. Caput
--%>

<%@page import="com.mycompany.campus.datamodel.entities.Categoria"%>
<%@page import="java.util.List"%>
<div class="col s12 m4 l4 "></div>
<div class="col s12 m4 l4 " style="background-color: #f3f1ec;">
    <h1 class="center-align" style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;  ">Crear nuevo curso</h1>
    <form name="formulario" method="post" action="ServletNewCurso" enctype="multipart/form-data">

        <label>Titulo:</label> <br>
        <input type="text" id="nombre" name="nombre" required /><br> <br>

        <label>Descripcion:</label> <br>
        <textarea rows="10" cols="40" id="descripcion" required name="descripcion"></textarea> <br> <br>


        <label>Portada Curso: </label> <br>
        <input type="hidden" name="MAX_FILE_SIZE" value="1000000" class="submit"> 
        <input type="file" name="foto" id="img" required accept="image/*" /> <br> <br> 
        <label>Precentación PDF: </label> <br>
        <input type="file" name="pdf" accept="application/pdf" />
        <p></p>
        <label>Video:</label> <br>
        <input type="file" name="file" />
        <br><br>

        <%List<Categoria> lis = (List<Categoria>) request.getAttribute("catess");%>
        <div class="input-field">
            <select required id="cat" name="cat" >
                <%for (Categoria ca : lis) {%>
                <option value="<%=ca.getId()%>"><%=ca.getCategoria()%></option>

                <%}%>
            </select>
            <label>Categoría</label>
        </div>
        <p></p>
        <label>Precio:</label> <br>
        <input type="number" name="precio" id="precio" step="0.01" required maxlength="4"><br> <br>

        <input class=" btn red accent-3 " type="reset" name="limpiar"  value="Borrar los datos"/>
        <input id="enviar" class="submit btn blue accent-2 right" type="submit"  name="enviar" value="Guardar cambios"  /><br><br>
        <div class="progress">
            <div class="indeterminate"></div>
        </div>


    </form>
</div>
<div class="col s12 m4 l4"></div>

<script>
    $(document).ready(function () {
        $(".progress").hide();

    });
    $("#enviar").click(function () {



        var nombre = document.getElementById("nombre").value;
        var apellido = document.getElementById("descripcion").value;
        var precio = document.getElementById("precio").value;
        var img = document.getElementById("img").value;

        // Nombre
        if (nombre == "" || apellido == "" || isNaN(precio) || img == "") {

        } else {
            $(".progress").show();
            return true;
        }
    });
</script>