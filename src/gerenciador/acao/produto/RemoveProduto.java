package gerenciador.acao.produto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProdutoDao;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class RemoveProduto implements Acao
{
	ProdutoDao produtoDao = new ProdutoDao();

	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException, Exception
	{
		int produtoId = Integer.parseInt(request.getParameter("txtId"));
		
		try
		{
			produtoDao.Excluir(produtoId);
			return Direcionamento.pRedirect.getDescricao();
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}

}
