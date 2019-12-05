package gerenciador.acao.mercadoProduto;

import java.io.IOException;

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

public class EditaMercadoProduto implements Acao
{
	MercadoProdutoDto mpDto = new MercadoProdutoDto();
	MercadoDto mercadoDto = new MercadoDto();
	ProdutoDto produtoDto = new ProdutoDto();
	MercadoDao mercadoDao = new MercadoDao();
	ProdutoDao produtoDao = new ProdutoDao();
	MercadoProdutoDao mpDao = new MercadoProdutoDao();

	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, Exception
	{
		
		int mercadoId=Integer.parseInt(request.getParameter("mMercado"));
		int produtoId=Integer.parseInt(request.getParameter("mProduto"));
		String vigula=request.getParameter("mPreco");
		String troca=vigula.replace(',', '.');
		double preco= Double.parseDouble(troca);
		int mpId=Integer.parseInt(request.getParameter("txtId"));
		
		mercadoDto=mercadoDao.RetornaRegistro(mercadoId);
		produtoDto=produtoDao.RetornaRegistro(produtoId);
		
		mpDto.setPreco(preco);
		mpDto.setMercadoDto(mercadoDto);
		mpDto.setProdutoDto(produtoDto);
		mpDto.setMercadoProdutoId(mpId);
		
		mpDao.Editar(mpDto);
		
		return Direcionamento.mpRedirect.getDescricao();
	}

}
