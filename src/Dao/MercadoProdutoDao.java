package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dto.MercadoDto;
import Dto.MercadoProdutoDto;
import Dto.ProdutoDto;

public class MercadoProdutoDao
{
	private Connection con = null;
    private ResultSet rs;
    private PreparedStatement pst;
    private String sql = "";   
    private MercadoDao mercadoDao = new MercadoDao();
    private ProdutoDao produtoDao = new ProdutoDao();
    
  
    
	 public Boolean VerifiqueConexao() throws Exception {
			try
			{
				con = ConnectionFactory.getConnection();
				if(con == null)
					return false;
			}
			catch(Exception e)
			{
				throw new Exception(e.getMessage());
			}

			return true;
		}
	 
	 public Boolean Salvar(MercadoProdutoDto mpDto) throws Exception
	 {
		 try
		{
			 if(!VerifiqueConexao())
					return false;
			 
			 sql="insert into mercadoproduto(mercadoId,produtoId,preco) values(?,?,?)";
			 pst=con.prepareStatement(sql);
			 
			 pst.setInt(1, mpDto.getMercadoDto().getMercadoId());
			 pst.setInt(2, mpDto.getProdutoDto().getProdutoId());
			 pst.setDouble(3, mpDto.getPreco());
			 return pst.executeUpdate() > 0? true:false;
			 
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	 }
	 
	 public Boolean Editar(MercadoProdutoDto mpDto) throws Exception
	 {
		 try
		{
			 if(!VerifiqueConexao())
					return false;
			 
			 sql="update mercadoProduto set mercadoId=?, produtoId=?, preco=? where mercadoProdutoId=?";
			 
			 pst=con.prepareStatement(sql);
			 pst.setInt(1, mpDto.getMercadoDto().getMercadoId());
			 pst.setInt(2, mpDto.getProdutoDto().getProdutoId());
			 pst.setDouble(3, mpDto.getPreco());
			 pst.setInt(4, mpDto.getMercadoProdutoId());
			 
			 return pst.executeUpdate() > 0? true:false;
			 
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	 }
	 
	 public Boolean ExcluirMercado(int id) throws Exception
	 {
		 try
		{
			 if(!VerifiqueConexao())
					return false;
			 
			 sql="delete from mercadoproduto where mercadoId = ?";
			 pst=con.prepareStatement(sql);
			 pst.setInt(1, id);
			 return pst.executeUpdate() > 0? true:false;
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	 }
	 
	 public Boolean ExcluirMercadoProduto(int id) throws Exception
	 {
		 try
		{
			 if(!VerifiqueConexao())
					return false;
			 
			 sql="delete from mercadoproduto where mercadoProdutoId = ?";
			 pst=con.prepareStatement(sql);
			 pst.setInt(1, id);
			 return pst.executeUpdate() > 0? true:false;
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	 }
	 
	 public Boolean ExcluirProduto(int id) throws Exception
	 {
		 try
		{
			 if(!VerifiqueConexao())
					return false;
			 
			 sql="delete from mercadoproduto where produtoId = ?";
			 pst=con.prepareStatement(sql);
			 pst.setInt(1, id);
			 return pst.executeUpdate() > 0? true:false;
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	 }
	 
	 public List<MercadoProdutoDto> Listar() throws Exception
	 {
		 List<MercadoProdutoDto> lista= new ArrayList<MercadoProdutoDto>();
		 MercadoDto mercadoDto=null;
		 ProdutoDto produtoDto=null;
		 MercadoProdutoDto mpDto=null;
		
		
		 try
		{
			 if(!VerifiqueConexao())
					return lista;
			 sql="select m.*, p.*, mp.* from mercado m "
			 		+ "inner join mercadoproduto mp on m.mercadoId=mp.mercadoId "
			 		+ "inner join produto p on p.produtoId=mp.produtoId";
			 pst=con.prepareStatement(sql);
			 rs=pst.executeQuery();
			 
			 while(rs.next())
			 {
				 mpDto = new MercadoProdutoDto();
				 mercadoDto=mercadoDao.RetornaRegistro(rs.getInt("mercadoId"));
				 produtoDto=produtoDao.RetornaRegistro(rs.getInt("produtoId"));
				 mpDto.setMercadoDto(mercadoDto);
				 mpDto.setProdutoDto(produtoDto);
				 mpDto.setPreco(rs.getDouble("preco"));
				 mpDto.setMercadoProdutoId(rs.getInt("mercadoprodutoId"));
				 lista.add(mpDto);
				 
			 }
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		 return lista;
	 }
	 
	 public List<MercadoProdutoDto> ListarCodBarra(long codBarra) throws Exception
	 {
		 List<MercadoProdutoDto> lista= new ArrayList<MercadoProdutoDto>();
		 MercadoDto mercadoDto=null;
		 ProdutoDto produtoDto=null;
		 MercadoProdutoDto mpDto=null;
		
		
		 try
		{
			 if(!VerifiqueConexao())
					return lista;
			 sql="select m.*, p.*, mp.* from mercado m "
			 		+ "inner join mercadoproduto mp on m.mercadoId=mp.mercadoId "
			 		+ "inner join produto p on p.produtoId=mp.produtoId where p.codigoBarra=?";
			 pst=con.prepareStatement(sql);
			 pst.setLong(1, codBarra);
			 rs=pst.executeQuery();
			 
			 while(rs.next())
			 {
				 mpDto = new MercadoProdutoDto();
				 mercadoDto=mercadoDao.RetornaRegistro(rs.getInt("mercadoId"));
				 produtoDto=produtoDao.RetornaRegistro(rs.getInt("produtoId"));
				 mpDto.setMercadoDto(mercadoDto);
				 mpDto.setProdutoDto(produtoDto);
				 mpDto.setPreco(rs.getDouble("preco"));
				 mpDto.setMercadoProdutoId(rs.getInt("mercadoprodutoId"));
				 lista.add(mpDto);
				 
			 }
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		 return lista;
	 }
	 
	 public List<MercadoProdutoDto> ListarProdutosDeMerdcado(int id) throws Exception
	 {
		 List<MercadoProdutoDto> lista= new ArrayList<MercadoProdutoDto>();
		 MercadoDto mercadoDto=null;
		 ProdutoDto produtoDto=null;
		 MercadoProdutoDto mpDto=null;
		
		
		 try
		{
			 if(!VerifiqueConexao())
					return lista;
			 sql="select p.*,mp.preco from produto p inner JOIN mercadoproduto mp on mp.produtoid=p.produtoId where mp.mercadoid=?";
			 pst=con.prepareStatement(sql);
			 pst.setLong(1, id);
			 rs=pst.executeQuery();
			 
			 while(rs.next())
			 {
				 mpDto = new MercadoProdutoDto();
				 //mercadoDto=mercadoDao.RetornaRegistro(rs.getInt("mercadoId"));
				 produtoDto=produtoDao.RetornaRegistro(rs.getInt("produtoId"));
				// mpDto.setMercadoDto(mercadoDto);
				 mpDto.setProdutoDto(produtoDto);
				 mpDto.setPreco(rs.getDouble("preco"));
				 //mpDto.setMercadoProdutoId(rs.getInt("mercadoprodutoId"));
				 lista.add(mpDto);
				 
			 }
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		 return lista;
	 }
	 
	 public List<MercadoProdutoDto> ListarTodosProdutos() throws Exception
	 {
		 List<MercadoProdutoDto> lista= new ArrayList<MercadoProdutoDto>();
		 MercadoDto mercadoDto=null;
		 ProdutoDto produtoDto=null;
		 MercadoProdutoDto mpDto=null;
		 
		 try
			{
				 if(!VerifiqueConexao())
						return lista;
				 sql="select p.*,mp.preco, m.nome,m.mercadoId from produto p "
				 		+ "inner JOIN mercadoproduto mp on mp.produtoid=p.produtoId "
				 		+ "INNER JOIN mercado m ON mp.mercadoid=m.mercadoId";
				 
				 pst=con.prepareStatement(sql);
				 rs=pst.executeQuery();
				 
				 while(rs.next())
				 {
					 mpDto = new MercadoProdutoDto();
					 mercadoDto=mercadoDao.RetornaRegistro(rs.getInt("mercadoId"));
					 produtoDto=produtoDao.RetornaRegistro(rs.getInt("produtoId"));
					 mpDto.setMercadoDto(mercadoDto);
					 mpDto.setProdutoDto(produtoDto);
					 mpDto.setPreco(rs.getDouble("preco"));
					 lista.add(mpDto);
					 
				 }
			} catch (Exception e)
			{
				throw new Exception(e.getMessage());
			}
			 return lista;
	 }
	 //select p.* from produto p inner JOIN mercadoproduto mp on mp.produtoid=p.produtoId where mp.mercadoid=7
}
