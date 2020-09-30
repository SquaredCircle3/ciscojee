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
import org.cisco.jee.biblioteca.Pais;
import org.cisco.jee.webbiblio.util.Constants;
import org.cisco.jee.webbiblio.util.DBSingleton;

/**
 *
 * @author pablo
 */
@WebServlet(name = "PaisServlet", urlPatterns = {"/PaisServlet"})
public class PaisServlet extends HttpServlet {

    private final Logger log = LogManager.getLogger(PaisServlet.class.getName());
    
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
                String pais = request.getParameter("txtPais");
                
                // Acceder al contexto del Servlet (application context)
                List<Pais> paises = (List<Pais>) getServletContext().getAttribute("paises");
                if (paises == null) {
                    paises = DBSingleton.getInstance().getPaises();
                    getServletContext().setAttribute("paises", paises);
                }
                Pais p = new Pais(pais);
                p.setId(paises.size()+1);
                paises.add(p);
                
                request.setAttribute("success", "Se cargó exitosamente");
                RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_PAISES);
                dispatcher.forward(request, response);
            }
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
