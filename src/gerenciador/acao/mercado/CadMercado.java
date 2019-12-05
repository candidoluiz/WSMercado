package gerenciador.acao.mercado;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.MercadoDao;
import Dto.MercadoDto;
import gerenciador.Acao;
import gerenciador.Direcionamento;

public class CadMercado implements Acao
{
	MercadoDto mercadoDto = new MercadoDto();
	MercadoDao mercadoDao = new MercadoDao();
	
	public String executa(HttpServletResponse response, HttpServletRequest request) throws Exception
	{
		
		//Part foto = request.getPart("txtFile");
		//InputStream fotoStream = foto.getInputStream();
		String nome = request.getParameter("txtNome");
		String rua= request.getParameter("txtRua");
		String numero=request.getParameter("txtNumero");
		String bairro=request.getParameter("txtBairro");
		String UF=request.getParameter("txtUF");
		String cidade=request.getParameter("txtCidade");
		String logo = "./Resources/imagem/mercado/"+request.getParameter("txtFile");
		
		//mercadoDto.setImagem(fotoStream);
		mercadoDto.setBairro(bairro);
		mercadoDto.setNome(nome);
		mercadoDto.setNumero(numero);
		mercadoDto.setRua(rua);
		mercadoDto.setFoto(logo);
		mercadoDto.setCidade(cidade);
		mercadoDto.setUf(UF);
		
	
		
		try
		{
			mercadoDao.Salvar(mercadoDto);
			List<MercadoDto> listar=mercadoDao.Listar();
			request.setAttribute("mercados", listar);
			request.setAttribute("ok", "cadastrado");
			return Direcionamento.mForward.getDescricao(); 
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
}
