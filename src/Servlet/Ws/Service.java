package Servlet.Ws;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import Dao.MercadoDao;
import Dao.MercadoProdutoDao;
import Dao.ProdutoDao;
import Dto.MercadoDto;
import Dto.MercadoProdutoDto;
import Dto.ProdutoDto;

@Path("/ws")
public class Service {
	Gson g = new Gson();

	//http://localhost:8080/Mercado/rest/ws/listarMercados
	//http://localhost:8080/Mercado/rest/ws/listarCidades
	//http://localhost:8080/Mercado/rest/ws/listarProdutos
	//http://localhost:8080/Mercado/rest/ws/listarTodosProdutos
	//http://localhost:8080/Mercado/rest/ws/listarCodBarra/99877
	//http://localhost:8080/Mercado/rest/ws/listarProdutoDeMercado/id do mercado
  
  @GET
  @Produces("application/json")
  @Path("listarMercados")
  public String getMercado() {
   MercadoDao mDao = new MercadoDao();
   
   try
{
	List<MercadoDto> lista = mDao.Listar();
	return g.toJson(lista);
} catch (Exception e)
{
	return e.getMessage();
}
  }
  
  @GET
  @Produces("application/json")
  @Path("listarCidades")
  public String getCidades() {
   MercadoDao mDao = new MercadoDao();
   
   try
{
	List<MercadoDto> lista = mDao.ListarCidade();
	return g.toJson(lista);
} catch (Exception e)
{
	return e.getMessage();
}
  }
  
  @GET
  @Produces("application/json")
  @Path("listarProdutos")
  public String getProdutos() {
  ProdutoDao produtoDao = new ProdutoDao();
   
   try
{
	List<ProdutoDto> lista = produtoDao.Listar();
	return g.toJson(lista);
} catch (Exception e)
{
	return e.getMessage();
}
  }
  
  @GET
  @Produces("application/json")
  @Path("listarCodBarra/{codigoBarra}")
	public String getListaCodBarra(@PathParam("codigoBarra")long codigoBarra) throws Exception
	{
	  MercadoProdutoDao mpDao = new MercadoProdutoDao();
	  List<MercadoProdutoDto> lista= mpDao.ListarCodBarra(codigoBarra);
	  return g.toJson(lista);
	}
  
  @GET
  @Produces("application/json")
  @Path("listarProdutoDeMercado/{id}")
	public String getListaProdutoDeMercado(@PathParam("id")int id) throws Exception
	{
	  MercadoProdutoDao mpDao = new MercadoProdutoDao();
	  List<MercadoProdutoDto> lista= mpDao.ListarProdutosDeMerdcado(id);
	  return g.toJson(lista);
	}
  
  @GET
  @Produces("application/json")
  @Path("listarTodosProdutos")
	public String getListaTudo() throws Exception
	{
	  MercadoProdutoDao mpDao = new MercadoProdutoDao();
	  List<MercadoProdutoDto> lista= mpDao.ListarTodosProdutos();
	  return g.toJson(lista);
	}
   

}
