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

public class EditaProduto implements Acao
{
	ProdutoDto produtoDto = new ProdutoDto();
	ProdutoDao produtoDao = new ProdutoDao();
	
	@Override
	public String executa(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException, Exception
	{
		String tipo=request.getParameter("mTipo").toUpperCase();
		String marca=request.getParameter("mMarca").toUpperCase();
		long codigoBarra=Long.parseLong(request.getParameter("mCodBarra"));
		String foto="./Resources/imagem/produto/"+request.getParameter("mFile");
		String medida=request.getParameter("mMedida");
		String unMedida=request.getParameter("mUnMedida");
		int produtoId=Integer.parseInt(request.getParameter("txtId"));
		
		produtoDto.setCodigoBarra(codigoBarra);
		produtoDto.setFoto(foto);
		produtoDto.setMarca(marca);
		produtoDto.setMedida(medida);
		produtoDto.setTipo(tipo);
		produtoDto.setUnMedida(unMedida);
		produtoDto.setProdutoId(produtoId);
		
		try
		{
			produtoDao.Atualizar(produtoDto);
			List<ProdutoDto> listar =produtoDao.Listar();
			request.setAttribute("produtos", listar);
			return Direcionamento.pForward.getDescricao();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
}
