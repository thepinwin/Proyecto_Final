/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.servletClientes;

import com.mycompany.campus.datamodel.crud.CrudCliente;
import com.mycompany.campus.datamodel.entities.Cliente;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.time.Instant.now;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
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
@WebServlet(name = "ServletAddCurso", urlPatterns = {"/ServletAddCurso"})
public class ServletAddCurso extends HttpServlet {

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

//        String cursoId = request.getParameter("ids");
//        HttpSession session = request.getSession();
//
//        Cliente cli = (Cliente) session.getAttribute("logClien");
//
//        if (cursoId != null) {
//
//            if (cli != null) {
//
//                CrudCliente crud = new CrudCliente();
//                Date fecha = new Date();
//                String idFactura = cli.getId().toString() + cursoId + String.valueOf(fecha.getTime()).substring(7);
//
//                com.mycompany.campus.datamodel.entities.Curso curso = crud.oneCurso(Integer.parseInt(cursoId));
//
//                BigDecimal precio, precioBase, iva;
//
//                precio = curso.getPrecio();
//
//                precioBase = precio.divide(new BigDecimal(1.21), 2, RoundingMode.CEILING);
//
//                iva = precio.subtract(precioBase);
//
//                crud.newRegistro(cli.getId(), Integer.parseInt(cursoId), Integer.parseInt(idFactura), precioBase, iva, precio);
//
//               // crud.newCursoAdd(Integer.parseInt(cursoId), cli.getId());
//                RequestDispatcher rs = request.getRequestDispatcher("ServletMisCursos");
//                rs.forward(request, response);
//
//            }
//        } else {
//            String cursoIds = request.getParameter("id");
//            String[] temas = request.getParameterValues("temas");
//            List list = Arrays.asList(temas);
//            CrudCliente crud = new CrudCliente();
//
//            Date fecha = new Date();
//            String idFactura = cli.getId().toString() + cursoIds + String.valueOf(fecha.getTime()).substring(7);
//
//            for (int i = 0; i < list.size(); i++) {
//
//                com.mycompany.campus.datamodel.entities.Curso curso = crud.oneCurso(Integer.parseInt(cursoIds));
//
//                BigDecimal precio, precioBase, iva;
//
//                precio = curso.getPrecio();
//
//                precioBase = precio.divide(new BigDecimal(1.21), 2, RoundingMode.CEILING);
//
//                iva = precio.subtract(precioBase);
//
//                crud.newRegistros(cli.getId(), Integer.parseInt(cursoIds), Integer.parseInt(idFactura), Integer.parseInt((String) list.get(i)),
//                        precioBase, iva, precio);
//
//                crud.newCursoAddTema(Integer.parseInt(cursoIds), cli.getId(), Integer.parseInt((String) list.get(i)));
//
//            }
//            RequestDispatcher rs = request.getRequestDispatcher("ServletMisCursos");
//            rs.forward(request, response);
//
//        }
//        /*
//         }
//         else {
//         RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
//
//         request.setAttribute("pagina", "Signup");
//
//         rs.forward(request, response);
//         }
//         */
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
