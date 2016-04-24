package Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BD.CtrlBancoDeDados;
import Models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 0084158
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        HttpSession session = request.getSession();
        
        List<Usuario> usuarios = CtrlBancoDeDados.getUsuarios();
        
        for( Usuario u: usuarios ) {
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                session.setAttribute("usuario.logado", u);
                System.out.printf("Usuario %s logado", u.getLogin());
                response.sendRedirect("/clinica/sistema/MarcarExame");
            }
        }
        
        /*System.out.println("login e/ou senhas incorreto");
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp?msg=loginerror");
        rd.forward(request, response);*/

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
