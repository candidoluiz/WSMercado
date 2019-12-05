package Servlet.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gerenciador.Acao;



@WebServlet("/Controller")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao=request.getParameter("acao");
		String nome;
		String nomeDaClasse="gerenciador." + paramAcao;
		
			try
			{
				Class classe = Class.forName(nomeDaClasse);//carrega a classe com nome
				Acao acao = (Acao) classe.newInstance();
				nome=acao.executa(response, request);
			} catch (Exception e1)
			{
				throw new ServletException(e1);
			}

		
		String[] tipoEndereco = nome.split(":");				
		
		if(tipoEndereco[0].equals("forward"))
		{
			RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);
			rd.forward(request, response);
		}else if(tipoEndereco[0].equals("redirect"))
		{
			response.sendRedirect(tipoEndereco[1]);//redirect
		}
		else {
			response.sendRedirect("index.html");
		}
					
	}

}
