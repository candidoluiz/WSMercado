package Servlet.Mercado;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.MercadoDao;
import Dto.MercadoDto;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/cadMercado")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MercadoDao mercadoDao = new MercadoDao();
	MercadoDto mercadoDto = new MercadoDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		int id=Integer.parseInt(request.getParameter("id"));
		
		try
		{
			mercadoDao.listarImg(id, response);
			
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	
		/*
		Part foto = request.getPart("txtFile");
		InputStream fotoStream = foto.getInputStream();
		String nome = request.getParameter("txtNome");
		String rua= request.getParameter("txtRua");
		String numero=request.getParameter("txtNumero");
		String bairro=request.getParameter("txtBairro");
		String UF=request.getParameter("txtUF");
		String Cidade=request.getParameter("txtCidade");

		mercadoDto.setImagem(fotoStream);
		mercadoDto.setBairro(bairro);
		mercadoDto.setNome(nome);
		mercadoDto.setNumero(numero);
		mercadoDto.setRua(rua);
		
		//mercadoDto.setImagem(foto);
		try
		{
			mercadoDao.Salvar(mercadoDto);
		} catch (Exception e)
		{
			request.setAttribute("error",e.getMessage());
			request.getRequestDispatcher("/Erro/error.jsp").forward(request, response);
		}
	}
*/
}
