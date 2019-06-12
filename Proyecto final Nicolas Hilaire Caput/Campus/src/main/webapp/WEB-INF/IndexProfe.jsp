<%-- 
    Document   : IndexProfe
    Created on : 27-mar-2019, 9:58:45
    Author     : WEB 2
--%>
<%@page import="com.mycompany.campus.datamodel.entities.Curso"%>
<%@page import="java.util.List"%>
<div class="section" style="margin-bottom:  -11%; margin-top: -5%">
    <div class="row">
        <div class="col s12 m12 l12  center" style="background-color: #f5f4ef;font-family: 'Cormorant Unicase', serif;">
            <h1 >Mis Cursos</h1>
        </div>

    </div>
</div>

<div  class="row">
    <div class="col s12 m4 l2"></div>
    <div class="col s12 m4 l8" style="background-color: #f5f4ef; padding-top: 2%">
        <% List<Curso> cursos = (List<Curso>) request.getAttribute("ProfCur");
    if (cursos != null) {
        for (Curso cur : cursos) {%>

        <div class="col s12 m4 l4">
            <div class="card">
                <div class="card-image waves-effect waves-block waves-light">
                    <img class="activator" src="<%=request.getContextPath()%>/Desc/<%=cur.getUrlFoto()%>" height="200">
                </div>
                <div class="card-content">
                    <span class="card-title activator grey-text text-darken-4 truncate"><%=cur.getTitulo()%></span><i class="material-icons activator right">expand_less</i>
                    <p><a href="ServletCursoProf?curso=<%=cur.getId()%>">Abrir</a>
                        <%if(cur.getPublicado() == 1){%>
                            <span class="new badge red" data-badge-caption="Publicado"></span></p>
                         <%}%>
                        
                </div>
                <div class="card-reveal">
                    <span class="card-title grey-text text-darken-4"><%=cur.getTitulo()%><i class="material-icons right">close</i></span>
                    <p><%=cur.getDescripcion()%></p>
                </div>
            </div>
        </div>
        <%}
    }%>
    </div>
    <div class="col s12 m4 l2"></div>
</div>
<script>


//location.reload(true);


</script>
