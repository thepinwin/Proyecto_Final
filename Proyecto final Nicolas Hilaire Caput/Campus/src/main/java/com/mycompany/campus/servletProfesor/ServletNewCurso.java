    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.servletProfesor;

import com.mycompany.campus.datamodel.crud.CrudInfo;
import com.mycompany.campus.datamodel.crud.CrudProfesor;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.mycompany.campus.datamodel.entities.Profesor;
import java.math.BigDecimal;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
//import org.apache.commons.fileupload.disk.*;

/**
 *
 * @author Nicolas H. Caput
 */
@WebServlet(name = "ServletNewCurso", urlPatterns = {"/ServletNewCurso"})
@MultipartConfig
public class ServletNewCurso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;

  //  private static final String DATA_DIRECTORY = "C:\\Users\\WEB 2\\Documents\\NetBeansProjects\\Campus\\Campus\\src\\main\\webapp\\Desc";

    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        // =============== File =============
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }
        HttpSession session = request.getSession();
        Profesor prof = (Profesor) session.getAttribute("logProf");
        Date date = new Date();
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("") + File.separator + "Desc";

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        // Set overall request size constraint
        //  upload.setSizeMax(MAX_REQUEST_SIZE);
        try {

            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            ArrayList list = new ArrayList();

            // Todos los valores
            for (FileItem item : items) {

                if (!item.isFormField()) {
                    if (item.getName().equals("")) {
                        list.add(null);
                    } else {
                        String nombre = new File(item.getName()).getName();
                        String fileName = prof.getId().toString() + String.valueOf(date.getTime() + nombre.replace(" ", ""));
                        String filePath = uploadFolder + File.separator + fileName;
                        File uploadedFile = new File(filePath);
                        list.add(fileName);
                        // saves the file to upload directory
                        item.write(uploadedFile);
                    }
                } else {

                    list.add(new String(item.getString().getBytes(ISO_8859_1), UTF_8));
                }
            }

            Thread.sleep(2500);
            CrudProfesor crud = new CrudProfesor();

            int id = crud.newCurso((String) list.get(0), (String) list.get(1),
                    (String) list.get(3), (String) list.get(4), (String) list.get(5), prof, new BigDecimal((String) list.get(7)),
                   Integer.parseInt((String) list.get(6)));

            crud.oneCurso(id);
            CrudInfo crudIn = new CrudInfo();

            crudIn.creatInfo(id);

                // Con PDF y sin video
            // displays done.jsp page after upload finished
//            RequestDispatcher rs = request.getRequestDispatcher("ServletPrincipal");
//            rs.forward(request, response);
            
            response.sendRedirect("ServletPrincipal");

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletNewCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletNewCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
