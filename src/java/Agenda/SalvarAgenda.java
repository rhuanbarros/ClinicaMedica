/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import BD.CtrlBancoDeDados;
import Models.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rhuanbarros
 */
@WebServlet(name = "SalvarAgenda", urlPatterns = {"/sistema/SalvarAgenda"})
public class SalvarAgenda extends HttpServlet {

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
        System.out.println("executando salvar_agenda");

        String exame = request.getParameter("exame");
        String medico = request.getParameter("medico");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");

        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
        Exame e = CtrlBancoDeDados.getExameById(Integer.parseInt(exame));
        Medico m = CtrlBancoDeDados.getMedicoById(Integer.parseInt(medico));

        Agenda agenda = CtrlBancoDeDados.getAgendaByDataEHora(data, hora);
        if (agenda == null) {
            Agenda agendaNova = new Agenda(usuarioLogado, e, m, data, hora);
            CtrlBancoDeDados.addAgenda(agendaNova);
            System.out.println("salvou agenda");
        } else {
            //ja existe exame marcado para esta data e horario
            //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sistema/marcar_agenda.jsp?msg=datahoraocupada");
            //rd.forward(request, response);
            System.out.println("data ocupada");
            response.sendRedirect("/clinica/sistema/MarcarAgenda?msg=datahoraocupada");
            return;
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
