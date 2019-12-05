package gerenciador.acao.mercado;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MercadoDto;
import gerenciador.Acao;
import gerenciador.Direcionamento;
import Dao.MercadoDao;

public class ListaMercado implements Acao
{
	MercadoDao mercadoDao = new MercadoDao();
	
	public  String executa(HttpServletResponse response, HttpServletRequest request) throws Exception 
	{
		try
		{
			
			List<MercadoDto> listar=mercadoDao.Listar();
			request.setAttribute("mercados", listar);
			return Direcionamento.mForward.getDescricao();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
	
}
