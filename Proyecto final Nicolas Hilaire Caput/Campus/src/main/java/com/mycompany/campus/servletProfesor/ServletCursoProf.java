/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.servletProfesor;

import com.mycompany.campus.datamodel.crud.CrudCliente;
import com.mycompany.campus.datamodel.crud.CrudInfo;
import com.mycompany.campus.datamodel.crud.CrudTema;
import com.mycompany.campus.datamodel.entities.Curso;
import com.mycompany.campus.datamodel.entities.CursoInfo;
import com.mycompany.campus.datamodel.entities.CursoTema;
import com.mycompany.campus.datamodel.entities.Info;
import com.mycompany.campus.datamodel.entities.Tema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WEB 2
 */
@WebServlet(name = "ServletCursoProf", urlPatterns = {"/ServletCursoProf"})
public class ServletCursoProf extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String cursoId = request.getParameter("curso");

        //Sacar entidad curso
        CrudCliente crud = new CrudCliente();
        Curso curso = crud.oneCurso(Integer.parseInt(cursoId));

        request.setAttribute("cursoProf", curso);

        // Sacar temas
        CrudTema crudTema = new CrudTema();

        List<CursoTema> tema = crudTema.allTemas(Integer.parseInt(cursoId));

        ArrayList map = new ArrayList();
        if (tema != null) {
            for (CursoTema guay : tema) {
                map.add(guay);
                map.add(crudTema.getTemas(guay.getIdCurso(), guay.getId()));
            }
        }
        request.setAttribute("temas", map);

        // Sacar Info
        CrudInfo crudInfo = new CrudInfo();

        CursoInfo inf = crudInfo.oneInfo("info", curso.getId());

        List<Info> fo = crudInfo.getInfo(curso.getId(), inf.getId());
        
        request.setAttribute("info", fo);
        
        CursoInfo infs = crudInfo.oneInfo("apre", curso.getId());

        List<Info> fos = crudInfo.getInfo(curso.getId(), infs.getId());
        
        request.setAttribute("apre", fos);

        RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");

        request.setAttribute("pagina", "prof/CursoProf");

        rs.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
