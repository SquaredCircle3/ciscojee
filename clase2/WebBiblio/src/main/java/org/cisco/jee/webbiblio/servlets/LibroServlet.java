/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.webbiblio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.cisco.jee.biblioteca.Libro;
import org.cisco.jee.webbiblio.util.Constants;

/**
 *
 * @author pablo
 */
@WebServlet(name = "LibroServlet", urlPatterns = {"/LibroServlet"})
public class LibroServlet extends HttpServlet {

    private final Logger log = LogManager.getLogger(LibroServlet.class.getName());
    
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
        
        if(validarUsuario(request, response)) {
            if (validarEntrada(request, response)) {
                log.info("Cargando un libro");

                Libro libro = new Libro();
                libro.setAnioEdicion(Integer.valueOf(request.getParameter("txtAnioEdicion")));
                libro.setTitulo(request.getParameter("txtTitulo"));
    //            libro.setAutor(request.getParameter("txtAutor"));
                libro.setIsbn(request.getParameter("txtISBN"));
                libro.setEditorial(request.getParameter("txtEditorial"));
                
                HttpSession session = request.getSession();
                List<Libro> libros = (List<Libro>) session.getAttribute(LIBROS);
                if(libros == null) {
                    log.debug("Creando lista de libros desde sesión");
                    libros = new ArrayList<Libro>();
                    session.setAttribute(LIBROS, libros);
                }
                libros.add(libro);
                
                request.setAttribute("success", "Se cargó exitosamente");
                RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_LIBROS);
                dispatcher.forward(request, response);
            }
        }
    }
    private static final String LIBROS = "libros";

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

    private boolean validarEntrada(HttpServletRequest request, HttpServletResponse response) {
        
        //TODO: a cargo del alumno
        return true;
    }

    private boolean validarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute(Constants.SESSION_AUTH) == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_LOGIN);
            dispatcher.forward(request, response); 
            return false;
        }
        return true;
    }

}
