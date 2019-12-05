package Servlet.Imagem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MercadoDao;


@WebServlet("/Imagem")
public class Imagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
     MercadoDao mercadoDao = new MercadoDao();  
   
    public Imagem() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id=Integer.parseInt(request.getParameter("id"));
		/*
		try
		{
			mercadoDao.listarImg(id, response);
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}

	*/
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
