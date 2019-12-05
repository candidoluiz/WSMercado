package gerenciador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.MercadoDao;

public class Login implements Acao
{
	MercadoDao mercadoDao = new MercadoDao();

	public String executa(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException
	{
		String login= request.getParameter("txtLogin");
	    String senha=request.getParameter("txtSenha");
	    
	    if( login.equals("admin") && senha.equals("admin"))
	       {
	    	return Direcionamento.mRedirect.getDescricao();
	    	
	       }else
	       {
	    	   return "index:login";
	       }
	    
	}
	
}
