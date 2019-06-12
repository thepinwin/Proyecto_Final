/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.servletProfesor;

import com.mycompany.campus.datamodel.crud.CrudInfo;
import com.mycompany.campus.datamodel.crud.CrudTema;
import com.mycompany.campus.datamodel.entities.Curso;
import com.mycompany.campus.datamodel.entities.CursoInfo;
import com.mycompany.campus.datamodel.entities.CursoTema;
import com.mycompany.campus.datamodel.entities.Tema;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DropCurso", urlPatterns = {"/DropCurso"})
public class DropCurso extends HttpServlet {

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
        String ruta = getServletContext().getRealPath("") + File.separator + "Desc";

        CrudTema crud = new CrudTema();

        List<Tema> temas = crud.getTema(Integer.parseInt(cursoId));
        boolean error = true;

        if (temas != null) {

            for (Tema tema : temas) {
                if (!crud.deleteFile(new File(ruta + File.separator + tema.getUrl()))) {
                    error = false;
                    break;
                }

            }
        }
        if (error) {
            List<CursoTema> je = crud.allTemas(Integer.parseInt(cursoId));

            if (je != null) {
                for (CursoTema a : je) {
                    crud.dropTema(a);
                }
            }

        }
        
        CrudInfo crudInfo = new CrudInfo();

        CursoInfo inf = crudInfo.oneInfo("info",Integer.parseInt(cursoId));
        CursoInfo infs = crudInfo.oneInfo("apre", Integer.parseInt(cursoId));
        
        crudInfo.dropInfoCur(inf);
        crudInfo.dropInfoCur(infs);
        
        Curso cur = crud.oneCurso(Integer.parseInt(cursoId));
        crud.deleteFile(new File(ruta + File.separator + cur.getUrlFoto()));
        crud.deleteFile(new File(ruta + File.separator + cur.getUrlPdf()));
        crud.deleteFile(new File(ruta + File.separator + cur.getUrlVideo()));

        crud.dropCurso(Integer.parseInt(cursoId));
//        RequestDispatcher rs = request.getRequestDispatcher("ServletPrincipal");
//
//        rs.forward(request, response);
        
        response.sendRedirect("ServletPrincipal");

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
