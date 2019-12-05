package gerenciador.acao.mercadoProduto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MercadoProdutoDao;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class RemoveMercadoProduto implements Acao
{
	MercadoProdutoDao mpDao = new MercadoProdutoDao();
	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, Exception
	{
		int mercadoProdutoId=Integer.parseInt(request.getParameter("txtId"));
		try
		{
			mpDao.ExcluirMercadoProduto(mercadoProdutoId);
			return Direcionamento.mpRedirect.getDescricao();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}

}
