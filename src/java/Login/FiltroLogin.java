package Login;


import Models.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 0084158
 */
@WebFilter(urlPatterns = "/sistema/*")
public class FiltroLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Usuario acessando a URI " + req.getRequestURI());
        
        HttpSession session = req.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
        
        if( usuarioLogado != null ) { //usuario logado
            System.out.println("Usuario já logado: "+usuarioLogado.getLogin());
        } else {    //usuario nao logado
            System.out.println("ACESSO RESTRITO - Faça login.");
            /*RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;*/
            res.sendRedirect("/clinica/index.jsp");
            return;
        }        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    
    @Override
    public void destroy() {

    }

}
