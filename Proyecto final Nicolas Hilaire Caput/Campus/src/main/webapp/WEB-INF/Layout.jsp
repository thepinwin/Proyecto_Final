<%-- 
    Document   : Layout
    Created on : 07-ene-2019, 19:31:59
    Author     : thepinguin
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.mycompany.campus.datamodel.entities.*" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Campus Online</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Cormorant+Unicase" rel="stylesheet"> 
        <style>
            body{
                background-color: #353c47;
            }
            .slider .indicators {
                bottom: 60px;
                z-index: 100;
                /* text-align: left; */
            }
            .sub nav {
                height: 40px;
                line-height: 40px;
            }

            .sub nav i,.sub nav [class^="mdi-"],.sub nav [class*="mdi-"],.sub nav i.material-icons {
                height: 30px;
                line-height: 30px;
            }

            .sub nav .button-collapse i {
                height: 40px;
                line-height: 40px;
            }

            .sub nav .brand-logo { 
                font-size: 1.6rem; 
            }

            @media only screen and (min-width: 601px){
                .sub nav,.sub nav .nav-wrapper i,.sub nav a.button-collapse,.sub nav a.button-collapse i {
                    height: 40px;
                    line-height: 40px;
                }
            }
        </style>
    </head>
    <body>

        <div class="row">


            <%List<Categoria> lis = (List<Categoria>) request.getAttribute("cates");%>
            <%if (lis != null) {%>
            <!--Categorias:-->
            <ul id="dropdown1" class="dropdown-content" style="margin-top: 100%">

                <%for (Categoria ca : lis) {%>
                <li><a href="ServletIndex?cat=<%=ca.getId()%>"><%=ca.getCategoria()%></a></li>
                <li class="divider" tabindex="-1"></li>
                    <%}%>
            </ul>
            <%}%>

            <nav class="nav-extended">
                <div class="nav-wrapper" style="background-color: #002147;">



                    <%
                        if (session.getAttribute("logClien") != null) {
                            Cliente cli = (Cliente) session.getAttribute("logClien");
                    %>
                    <div class="left hide-on-med-and-down chip" style="margin: 1%; background-color: #006494">
                        <span class="white-text" ><%=cli.getNombre()%>  <%=cli.getApellidos()%></span>
                    </div>
                    <%}
                        if (session.getAttribute("logProf") != null) {
                            Profesor prof = (Profesor) session.getAttribute("logProf");%>

                    <div class="left hide-on-med-and-down chip" style="margin: 1%; background-color: #006494">
                        <span class="white-text" ><%=prof.getMail()%></span>
                    </div>
                    <%}%>

                    <a href="ServletIndex" class="brand-logo center" style="font-family: 'Cormorant Unicase', serif;"><i class="material-icons">school</i>Campus
                        <span class="hide-on-med-and-down"> Online</span></a>



                    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>

                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <%  if (session.getAttribute("logClien") != null) {
                                out.println("<li><a href=\"ServletMisCursos\">Mis Cursos</a></li>");
                                out.println("<li><a href=\"ServletFactura\">Historial Compra</a></li>");
                                out.println("<li><a href=\"ServletLogOut\">Cerrar sesión</a></li>");
                            } else if (session.getAttribute("logProf") != null) {
                                out.println("<li><a href=\"ServletPrincipal\">Mis Cursos</a></li>");
                                out.println("<li><a href=\"NewNoCurso\">Nuevo Curso</a></li>");
                                out.println("<li><a href=\"ServletLogOut\">Cerrar sesión</a></li>");
                            } else if (session.getAttribute("logEmpre") != null) {

                                out.println("<li><a href=\"ServletDirect?id=log\">Mis Cursos</a></li>");
                                out.println("<li><a href=\"ServletDirect?id=new\">Nuevo Curso</a></li>");
                                out.println("<li><a href=\"#\">LogOut</a></li>");
                            } else if (session.getAttribute("log") == null) {

                                out.println("<li><a href=\"ServletNoLogin\">Iniciar sesión Clientes</a></li>");
                                out.println("<li class='active'><a href=\"ServletNoSignup\" >Registro Clientes</a></li>");
                                out.println("<a href='ServletNoSignupProfe' class='dropdown-trigger btn blue waves-effect waves-light right'"
                                        + " data-target='dropdown2' style='margin-top: 17px;margin-right: 20px;'>Crear curso</a>");
                            }%>

                    </ul>
                </div>



                <!-- Dropdown Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="ServletNoLoginProfe">Iniciar sesión Prof/Empre</a></li>
                    <li class="divider" tabindex="-1"></li>
                    <li><a href="ServletNoSignupProfe">Registro Prof/Empre</a></li>
                </ul>

            </nav>
            <%if (lis != null) {%>                          
            <div class="sub">
                <div class="row" >
                    <nav  style="background-color: #2C5D94">
                        <div class="col l2 s5" >
                            <!--Categorias-->
                            <div class="nav-wrapper " >
                                <ul class="left ">
                                    <li> <a class="dropdown-trigger" href="#!" data-target="dropdown1" style="color: #F2C877">
                                            <i class="material-icons left" style="color: #F2C877">view_comfy</i>
                                            Categorías
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col l10 s6">
                            <div class=" nav-wrapper " >
                                <form class="flow-text">
                                    <div class="input-field">
                                        <input style="height: 40px" id="search" type="search" required>
                                        <label class="label-icon" for="search"><i class="material-icons responsive-img">search</i></label>
                                        <i class="material-icons">close</i>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>

            <%}%>


            <ul class="sidenav" id="mobile-demo">
                <%if (session.getAttribute("logClien") != null) {
                        Cliente cli = (Cliente) session.getAttribute("logClien");
                %>
                <li><div class="user-view" style="background-color: gray">

                        <!--<a href="#user"><img class="circle" src="índice.png"></a>-->
                        <a href="#name"><span class="white-text name"><%=cli.getNombre()%> <%=cli.getApellidos()%></span></a>
                        <a href="#email"><span class="white-text email"><%=cli.getMail()%></span></a>
                    </div></li>
                    <% }
                        if (session.getAttribute("logClien") != null) {
                            out.println("<li><a href=\"ServletMisCursos\">Mis Cursos</a></li><li><div class='divider'></div></li>");
                            out.println("<li><a href=\"ServletLogOut\">LogOut</a></li>");
                        } else if (session.getAttribute("logProf") != null) {
                            out.println("<li><a href=\"ServletPrincipal\">Mis Cursos</a></li>");
                            out.println("<li><a href=\"NewNoCurso\">Nuevo Curso</a></li>");
                            out.println("<li><a href=\"ServletLogOut\">LogOut</a></li>");
                        } else if (session.getAttribute("log") == null) {
                            out.println("<li><h4 class='center'>Clientes</h4></li>"
                                    + "<li><a href=\"ServletNoLogin\">Iniciar sesión Clientes</a></li>");
                            out.println("<li><a href=\"ServletNoSignup\">Registro Clientes</a></li> "
                                    + "<li class='divider' tabindex='-1'></li>");
                            out.println("<li><h4 class='center'>Crear Curso</h4></li>"
                                    + "<li><a href=\"ServletNoLoginProfe\">Iniciar sesión Profesores</a></li>");
                            out.println("<li><a href=\"ServletNoSignupProfe\">Registro Profesores</a></li>");

                        }%>
            </ul>

        </div>




            <div class="row"  >
            <jsp:include page="<%= ((String) request.getAttribute("pagina")) + ".jsp"%>"/>
        </div>



        <footer class="page-footer " style="background-color: #002147;">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h3 class="white-text">Campus Online</h3>
                        <h5 class="grey-text text-lighten-4">Siempre se puede ser mejor.</h5>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text">Empresas</h5>
                        <ul>
                            <li><a class="grey-text text-lighten-3" href="#!">- Sprinde</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">- Cen Coworking</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">- Coworking Valencia</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">- Druus Project</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2019 Copyright Disegned by Druud Project
                    <a class="grey-text text-lighten-4 right" href="#!"> Todos los derechos reservados</a>
                </div>
            </div>
        </footer>

        <script type="text/javascript">

            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.sidenav');
                var instances = M.Sidenav.init(elems);
            });

            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('select');
                var instances = M.FormSelect.init(elems);
            });

            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.dropdown-trigger');
                var instances = M.Dropdown.init(elems);
            });

            $(document).ready(function () {
                $(".dropdown-trigger").dropdown();
            });

        </script>
</html>
