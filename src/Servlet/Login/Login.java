
package Servlet.Login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MercadoDao;
import Dto.MercadoDto;


//@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
MercadoDto mercadoDto = new MercadoDto();
MercadoDao mercadoDao = new MercadoDao();
   
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //A sessão deve ser colocado no começo para poder ner nula
       HttpSession session=request.getSession(false);
       
       String login= request.getParameter("txtLogin");
       String senha=request.getParameter("txtSenha");
       
       if( login.equals("admin") && senha.equals("admin"))
       {
    	   try
		{
			List<MercadoDto> lista=mercadoDao.Listar();
			request.setAttribute("lista", lista);
			 session=request.getSession(true);
	           session.setMaxInactiveInterval(300);
	           request.getRequestDispatcher("/Mercado/cadMercado.jsp").forward(request, response);
	          //response.sendRedirect("/Mercado/Mercado/cadMercado.jsp");
		} catch (Exception e)
		{
			
			request.setAttribute("error",e.getMessage());
			request.getRequestDispatcher("/Erro/error.jsp").forward(request, response);
		}
          
       }else
       {
            response.sendRedirect("index.html");
           
       }
    }

   

}
