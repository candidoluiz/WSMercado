package gerenciador.acao.mercado;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.MercadoDao;
import Dto.MercadoDto;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class EditaMercado implements Acao
{
	
	MercadoDto mercadoDto = new MercadoDto();
	MercadoDao mercadoDao = new MercadoDao();
	
	public String executa(HttpServletResponse response, HttpServletRequest request) throws Exception
	{
		//Part foto = request.getPart("txtFile");
		//InputStream fotoStream = foto.getInputStream();
		String nome = request.getParameter("mNome");
		String rua= request.getParameter("mRua");
		String numero=request.getParameter("mNumero");
		String bairro=request.getParameter("mBairro");
		String UF=request.getParameter("mUf");
		String cidade=request.getParameter("mCidade");
		String logo = "./Resources/imagem/mercado/"+request.getParameter("mFile");
		int mercadoId= Integer.parseInt(request.getParameter("txtId"));
		
		//mercadoDto.setImagem(fotoStream);
		mercadoDto.setBairro(bairro);
		mercadoDto.setNome(nome);
		mercadoDto.setNumero(numero);
		mercadoDto.setRua(rua);
		mercadoDto.setFoto(logo);
		mercadoDto.setCidade(cidade);
		mercadoDto.setUf(UF);
		mercadoDto.setMercadoId(mercadoId);
		
		try
		{
			mercadoDao.Atualizar(mercadoDto);
			List<MercadoDto> listar=mercadoDao.Listar();
			request.setAttribute("mercados", listar);
			//response.sendRedirect("Controller?acao=ListaMercado");
			return Direcionamento.mForward.getDescricao();
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
			
		}
	}
}
