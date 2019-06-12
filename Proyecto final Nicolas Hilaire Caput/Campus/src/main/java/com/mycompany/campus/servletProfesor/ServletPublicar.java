/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.servletProfesor;

import com.mycompany.campus.datamodel.crud.CrudInfo;
import com.mycompany.campus.datamodel.crud.CrudProfesor;
import com.mycompany.campus.datamodel.crud.CrudPubliCurso;
import com.mycompany.campus.datamodel.crud.CrudTema;
import com.mycompany.campus.datamodel.entities.CursoInfo;
import com.mycompany.campus.datamodel.entities.CursoTema;
import com.mycompany.campus.datamodel.entities.Info;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ServletPublicar", urlPatterns = {"/ServletPublicar"})
public class ServletPublicar extends HttpServlet {

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

        int cursoId = Integer.parseInt(request.getParameter("curso"));

        // Sacar temas
        CrudTema crudTema = new CrudTema();

        List<CursoTema> tema = crudTema.allTemas(cursoId);
        boolean sabee = true;
        ArrayList map = new ArrayList();
        if (tema != null) {
            for (CursoTema guay : tema) {
                if (crudTema.getTemas(guay.getIdCurso(), guay.getId()) == null) {
                    sabee = false;
                    break;
                }
            }
        } else {
            sabee = false;
        }

        // Sacar Info
        CrudInfo crudInfo = new CrudInfo();

        CursoInfo inf = crudInfo.oneInfo("info", cursoId);

        List<Info> fo = crudInfo.getInfo(cursoId, inf.getId());

        if (fo == null) {
            sabee = false;
        }

        CursoInfo infs = crudInfo.oneInfo("apre", cursoId);

        List<Info> fos = crudInfo.getInfo(cursoId, infs.getId());

        if (fos == null) {
            sabee = false;
        }

        if (sabee) {

            CrudPubliCurso cru = new CrudPubliCurso();
            cru.publicar(cursoId);

            RequestDispatcher rs = request.getRequestDispatcher("ServletCursoProf?curso="+cursoId);

            rs.forward(request, response);

        }else{
            RequestDispatcher rs = request.getRequestDispatcher("ServletCursoProf?curso="+cursoId);

            rs.forward(request, response);
        }

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
