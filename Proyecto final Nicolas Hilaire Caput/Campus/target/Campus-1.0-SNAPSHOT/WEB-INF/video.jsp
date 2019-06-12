<%-- 
    Document   : video
    Created on : 03-abr-2019, 10:51:44
    Author     : WEB 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div style="margin-top: 1%">
    <video class="responsive-video" controls>
        <source src="<%=request.getContextPath()%>/Desc/<%= (String) request.getAttribute("url")%>" type="video/mp4" codecs="" >
        Su navegador no soporta contenido multimedia.
    </video>
</div>