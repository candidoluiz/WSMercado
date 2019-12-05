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

public class CadProduto implements Acao
{
	ProdutoDto produtoDto = new ProdutoDto();
	ProdutoDao produtoDao = new ProdutoDao();

	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException, Exception
	{
		String tipo=request.getParameter("txtTipo").toUpperCase();
		String marca=request.getParameter("txtMarca").toUpperCase();
		long codigoBarra=Long.parseLong(request.getParameter("txtCodigoBarra"));
		String foto="./Resources/imagem/produto/" + request.getParameter("txtFoto");
		String medida=request.getParameter("txtMedida");
		String unMedida=request.getParameter("txtUnMedida");
		
		produtoDto.setCodigoBarra(codigoBarra);
		produtoDto.setFoto(foto);
		produtoDto.setMarca(marca);
		produtoDto.setMedida(medida);
		produtoDto.setTipo(tipo);
		produtoDto.setUnMedida(unMedida);
		
		try
		{
			produtoDao.Salvar(produtoDto);
			List<ProdutoDto> listar =produtoDao.Listar();
			request.setAttribute("produtos", listar);
			request.setAttribute("ok", "cadastrado");
			return Direcionamento.pForward.getDescricao();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
		
		
		
	}

}
