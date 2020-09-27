/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cisco.jee.webbiblio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.cisco.jee.webbiblio.util.Constants;

/**
 *
 * @author pablo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final static String EMPTY_USER = "Usuario vacío";
    private final static String EMPTY_PASS = "Password vacío";
    
    private final static Logger log = LogManager.getLogger(LoginServlet.class.getName());
    
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
        // Procesa un usuario y contraseña
        String user = request.getParameter("txtUsuario");
        String pass = request.getParameter("pwdPassword");
        
        if (StringUtils.isBlank(user)) {
            log.error(EMPTY_USER);
            showErrorPage(request, response, EMPTY_USER);
            return;
        }
        
        if (StringUtils.isBlank(pass)) {
            log.error(EMPTY_PASS);
            showErrorPage(request, response, EMPTY_PASS);
            return;
        }
                
        // TODO: validar contra un repositorio de datos externo
        // Asumimos user/pass correctos
        HttpSession session = request.getSession();
        session.setAttribute(Constants.SESSION_AUTH, true);
        
        // Redirect to menu
        log.debug("Redirecting to menu");
        request.getRequestDispatcher(Constants.JSP_MENU).forward(request, response);
    }
    
    private void showErrorPage(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.JSP_LOGIN);
        dispatcher.forward(request, response);        
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
