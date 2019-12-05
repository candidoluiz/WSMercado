package gerenciador.acao.mercadoProduto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MercadoDao;
import Dao.MercadoProdutoDao;
import Dao.ProdutoDao;
import Dto.MercadoDto;
import Dto.MercadoProdutoDto;
import Dto.ProdutoDto;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class ListaMercadoProduto implements Acao {
	
	MercadoProdutoDao mercadoProdutoDao = new MercadoProdutoDao();
	MercadoDao mercadoDao = new MercadoDao();
	ProdutoDao produtoDao = new ProdutoDao();
	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, Exception {
		try 
		{
			List<MercadoProdutoDto> listar = mercadoProdutoDao.Listar();
			List<MercadoDto> listaMercado = mercadoDao.Listar();
			List<ProdutoDto> listaProduto = produtoDao.Listar();
			
			request.setAttribute("listaProduto", listaProduto);
			request.setAttribute("listaMercado",listaMercado);
			request.setAttribute("mercadosProdutos", listar);
			return Direcionamento.mpForward.getDescricao();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

}
