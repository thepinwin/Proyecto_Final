<%-- 
    Document   : IndexUser
    Created on : 01-abr-2019, 13:12:52
    Author     : Nicolas H. Caput
--%>
<%@page import="com.mycompany.campus.datamodel.entities.Curso"%>
<%@page import="java.util.List"%>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('.tabs').tabs();
    });
</script>



<div  class="row">
    <div class="col s12 m4 l2"></div>
    <div class="col s12 m4 l8 card" style="background-color: white; padding-top: 2%">
        <div class="row">
            <div style="margin-top: -5%">
                <div class="col s12 m12 l12  center" style="font-family: 'Cormorant Unicase', serif;  ">
                    <h1 >Mis Cursos</h1>
                </div>
            </div>

            <div class="col s12">
                <ul class="tabs">
                    <li class="tab col s6 light-blue accent-2">
                        <a href="#miscursos" class="active indigo-text text-darken-4">Mis Cursos</a>
                    </li>
                    <li class="tab col s6 light-blue accent-2">
                        <a href="#activar" class="indigo-text text-darken-4">Activar cursos</a>
                    </li>
                </ul>
                <div class="col s12" id="miscursos">
                    <h3 class="flow-text indigo-text text-darken-4">Mis Cursos</h3>
                    <div class="divider"></div>



                    <% List<Curso> cursos = (List<Curso>) request.getAttribute("UserCur");
                        if (cursos != null) {
                            for (Curso cur : cursos) {%>


                    <div class="col s12 m4 l4">
                        <div class="card">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img class="activator" src="<%=request.getContextPath()%>/Desc/<%=cur.getUrlFoto()%>" height="200">
                            </div>
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4"><%=cur.getTitulo()%><i class="material-icons right">expand_less</i></span>

                            </div>
                            <div class="card-action">
                                <a href="Curso?curso=<%=cur.getId()%>">Ver</a>
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

            </div>

            <!--========================== Activar =====================-->
            <div class="col s12" id="activar">
                <h3 class="flow-text indigo-text text-darken-4">No Activos</h3>
                <div class="divider"></div>


                <% List<Curso> cursoss = (List<Curso>) request.getAttribute("UserCurNop");
                    if (cursoss != null) {
                        for (Curso cur : cursoss) {%>


                <div class="col s12 m4 l4">
                    <div class="card">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="<%=request.getContextPath()%>/Desc/<%=cur.getUrlFoto()%>" height="200">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4"><%=cur.getTitulo()%><i class="material-icons right">expand_less</i></span>

                        </div>
                        <div class="card-action">
                            <a href="Curso?curso=<%=cur.getId()%>">Ver</a>
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
        </div>
    </div>
    <div class="col s12 m4 l2"></div>
</div>


<style>
    .tabs .tab a{
        color:#000;
    } /*Black color to the text*/

    .tabs .tab a:hover {
        background-color:#eee;
        color:#000;
    } /*Text color on hover*/

    .tabs .tab a.active {
        background-color:#40c4ff;
        color:#40c4ff;
    } /*Background and text color when a tab is active*/

    .tabs .indicator {
        background-color: grey;
        padding:  2px;
    } /*Color of underline*/
</style>