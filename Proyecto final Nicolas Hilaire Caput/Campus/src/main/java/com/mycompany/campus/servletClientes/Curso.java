/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.servletClientes;

import com.mycompany.campus.datamodel.crud.CrudCliente;
import com.mycompany.campus.datamodel.crud.CrudInfo;
import com.mycompany.campus.datamodel.crud.CrudTema;
import com.mycompany.campus.datamodel.entities.Cliente;
import com.mycompany.campus.datamodel.entities.ClienteCurso;
import com.mycompany.campus.datamodel.entities.CursoInfo;
import com.mycompany.campus.datamodel.entities.CursoTema;
import com.mycompany.campus.datamodel.entities.Info;
import com.mycompany.campus.datamodel.entities.Tema;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WEB 2
 */
@WebServlet(name = "Curso", urlPatterns = {"/Curso"})
public class Curso extends HttpServlet {

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

        HttpSession session = request.getSession();

        Cliente cli = (Cliente) session.getAttribute("logClien");

        CrudCliente crud = new CrudCliente();

        //
        com.mycompany.campus.datamodel.entities.Curso curso = crud.oneCurso(Integer.parseInt(cursoId));

        request.setAttribute("curso", curso);

        // Sacar autor
        String autor = crud.profCurso(curso.getId());

        request.setAttribute("autor", autor);

        // Sacar Info
        CursoInfo inf = crud.oneInfo("info", curso.getId());

        List<Info> fo = crud.getInfo(curso.getId(), inf.getId());

        request.setAttribute("info", fo);

        CursoInfo infs = crud.oneInfo("apre", curso.getId());

        List<Info> fos = crud.getInfo(curso.getId(), infs.getId());

        request.setAttribute("apre", fos);

        if (cli != null) {
            request.setAttribute("ok", crud.haveCurso(Integer.parseInt(cursoId), cli.getId()));

        }

        // Sacar Temas
        CrudTema crudTema = new CrudTema();

        List<CursoTema> tema = crudTema.allTemas(Integer.parseInt(cursoId));
        List<ClienteCurso> clien = crudTema.misTemas(Integer.parseInt(cursoId), cli.getId());

        if (clien.get(0).getActive() != null) {

            boolean tot = true;
            boolean sino = true;
            BigDecimal pri = new BigDecimal(0);

            ArrayList map = new ArrayList();
            if (tema != null) {

                for (CursoTema guay : tema) {

                    boolean si = true;

                    if (clien.get(0).getIdTema() == null) {
                        map.add(guay);

                        List<Tema> list = crudTema.getTemas(guay.getIdCurso(), guay.getId());
                        map.add(list);
                    } else {

                        for (int i = 0; i < clien.size(); i++) {

                            if (clien.get(i).getIdTema() == guay.getId()) {
                                map.add(guay);
                                map.add(crudTema.getTemas(guay.getIdCurso(), guay.getId()));
                                break;
                            }
                            if (i == clien.size() - 1) {
                                map.add(guay);
                                map.add(null);
                                tot = false;
                                pri = pri.add(guay.getPrecio());
                            }
                        }
                    }
                }
            }

            request.setAttribute("tot", tot);
            request.setAttribute("temas", map);
            request.setAttribute("price", pri);

            RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");

            request.setAttribute("pagina", "clien/CursoClien");

            rs.forward(request, response);

        } else {

            ArrayList map = new ArrayList();
            if (tema != null) {
                for (CursoTema guay : tema) {
                    map.add(guay);
                }
            }
            request.setAttribute("temas", map);

            RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");

            request.setAttribute("pagina", "clien/CursoPre");

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
