/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.resetpassProfesor;

import com.mycompany.campus.datamodel.crud.CrudCliente;
import com.mycompany.campus.datamodel.crud.CrudProfesor;
import com.mycompany.campus.datamodel.entities.Cliente;
import com.mycompany.campus.servletClientes.ResetPass;
import static com.mycompany.campus.servletClientes.ResetPass.Enviar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.campus.datamodel.entities.Profesor;
import java.math.BigInteger;
/**
 *
 * @author WEB 2
 */
@WebServlet(name = "ServletResetPassProf", urlPatterns = {"/ServletResetPassProf"})
public class ServletResetPassProf extends HttpServlet {

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

        String id = request.getParameter("id");

        if (id != null) {
            RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");

            request.setAttribute("pagina", "prof/ResetPassProf");

            rs.forward(request, response);

        } else {

            String mail = request.getParameter("mail");
            CrudCliente crud = new CrudCliente();

            CrudProfesor crudProfe = new CrudProfesor();

            Profesor cli = crudProfe.oneUser(mail);
            
            String link = toHex(cli.getId() + mail + cli.getNombre());
            
            crud.token(mail,link );

            if (cli != null) {
                String txt = "Hola, " + cli.getNombre()
                        + "\n Parace que estás teniendo problemas para entrar en tu cuenta.\n"
                        + "<a href='http://localhost:8080/Campus/ServletResetProf?id=" + link + "'>Camiar contraseña</a>";

                ResetPass.Enviar(mail, "Restablecer contraseña Campus Online", txt);

                RequestDispatcher rs = request.getRequestDispatcher("ServletNoLoginProfe");
                rs.forward(request, response);
            } else {

                RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");

                request.setAttribute("ok", "nop");

                request.setAttribute("pagina", "prof/ResetPassCliente");

                rs.forward(request, response);
            }

        }

    }
    
    public String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
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
