package gerenciador.acao.mercado;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MercadoDao;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class RemoveMercado implements Acao{
	MercadoDao mercadoDao = new MercadoDao();
	
public String executa(HttpServletResponse response, HttpServletRequest request) throws Exception
	{
		int mercadoId=Integer.parseInt(request.getParameter("txtId"));
		
		try
		{
			mercadoDao.Excluir(mercadoId);
			return Direcionamento.mRedirect.getDescricao();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
}
