/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.proyectoPruebaEjb.servlets;

import co.edu.uniminuto.proyectoPruebaEjb.entities.Usuario;
import co.edu.uniminuto.proyectoPruebaEjb.sessions.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class ServletPrueba extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrueba</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrueba at " + request.getContextPath() + "</h1>");
            List<Usuario> misPersonas = usuarioFacade.findAll();

            out.println("<TABLE style='border: 1px solid; border-collapse: collapse;'>");
            out.println("<TR>");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>Usuario</TD> ");
                out.println(" <TD style='border: 1px solid; border-collapse: collapse;'>Nombre</TD>");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>Contrasena</TD>");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>Correo</TD>");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>Rol</TD>");
                out.println("</TR>");
            for (Usuario p:misPersonas) {               
                out.println("<TR>");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>"+ p.getUsuario() +"</TD> ");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>"+ p.getNombre() +"</TD> ");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>" + p.getContrasena()+ "</TD> ");
                out.println(" <TD style='border: 1px solid; border-collapse: collapse;'>" + p.getCorreo()+ "</TD>");
                out.println("<TD style='border: 1px solid; border-collapse: collapse;'>" + p.getTipo()+ "</TD>");
                out.println("</TR>");
            }
            out.println("</TABLE>");
            out.println("</body>");
            out.println("</html>");
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
