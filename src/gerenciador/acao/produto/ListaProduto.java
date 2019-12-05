package gerenciador.acao.produto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProdutoDao;
import Dto.ProdutoDto;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class ListaProduto implements Acao
{
	ProdutoDao produtoDao = new ProdutoDao();

	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException, Exception
	{
		try
		{
			List<ProdutoDto> listar =produtoDao.Listar();
			request.setAttribute("produtos", listar);
			return Direcionamento.pForward.getDescricao();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
}
