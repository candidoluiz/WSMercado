package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dto.ProdutoDto;

public class ProdutoDao
{
	private Connection con = null;
    private ResultSet rs;
    private PreparedStatement pst;
    private String sql = "";
    
    private void constroiStatement(ProdutoDto produtoDto, PreparedStatement pst) throws Exception
    {
    	pst.setString(1, produtoDto.getFoto());
    	pst.setString(2, produtoDto.getMarca());
    	pst.setString(3, produtoDto.getMedida());
    	pst.setString(4, produtoDto.getTipo());
    	pst.setLong(5, produtoDto.getCodigoBarra());
    	pst.setString(6, produtoDto.getUnMedida());
    }
    
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
    
    public ProdutoDto RetornaRegistro(int id) throws Exception
    {
    	ProdutoDto produtoDto=null;
    	try
		{
    		if(!VerifiqueConexao())
				return produtoDto;
    		
    		sql="select * from produto where produtoId=?";
    		pst=con.prepareStatement(sql);
    		pst.setInt(1, id);
    		rs=pst.executeQuery();
    		
    		while(rs.next())
    		{
    			produtoDto = new ProdutoDto();
    			
    			produtoDto.setCodigoBarra(rs.getLong("codigoBarra"));
    			produtoDto.setFoto(rs.getString("foto"));
    			produtoDto.setMarca(rs.getString("marca"));
    			produtoDto.setMedida(rs.getString("medida"));
    			produtoDto.setProdutoId(rs.getInt("produtoId"));
    			produtoDto.setTipo(rs.getString("tipo"));
    			produtoDto.setUnMedida(rs.getString("unMedida"));
    		}
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	return produtoDto;
    }
    
    public Boolean Salvar(ProdutoDto produtoDto) throws Exception
    {
    	try
		{
    		if(!VerifiqueConexao())
				return false;
    		sql="insert into produto(foto,marca,medida,tipo,codigoBarra,unMedida) values(?,?,?,?,?,?)";
    		pst=con.prepareStatement(sql);
    		constroiStatement(produtoDto, pst);
    		
    		return pst.executeUpdate() > 0? true:false;
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    }
    
    public List<ProdutoDto> Listar() throws Exception
    {
    	List<ProdutoDto> lista=new ArrayList<ProdutoDto>();
    	ProdutoDto produtoDto;
    	
    	try
		{
    		if(!VerifiqueConexao())
    			return lista;
    		
    		sql="select * from produto";
    		pst=con.prepareStatement(sql);
    		rs=pst.executeQuery();
    		
    		while(rs.next())
    		{
    			produtoDto = new ProdutoDto();
    			produtoDto.setCodigoBarra(rs.getLong("codigoBarra"));
    			produtoDto.setFoto(rs.getString("foto"));
    			produtoDto.setMarca(rs.getString("marca"));
    			produtoDto.setMedida(rs.getString("medida"));
    			produtoDto.setProdutoId(rs.getInt("produtoId"));
    			produtoDto.setTipo(rs.getString("tipo"));
    			produtoDto.setUnMedida(rs.getString("unMedida"));
    			lista.add(produtoDto);
    		}
    		
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	return lista;
    }
    
    public Boolean Atualizar(ProdutoDto produtoDto) throws Exception
    {
    	try
		{
    		if(!VerifiqueConexao())
    			return false;
    		
    		sql="update produto set foto=?, marca=?, medida=?, tipo=?, codigoBarra=?, unMedida=? where produtoId=?";
    		pst=con.prepareStatement(sql);
    		constroiStatement(produtoDto, pst);
    		pst.setInt(7, produtoDto.getProdutoId());
    		return pst.executeUpdate() > 0? true: false;
    		
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    }
    
    public Boolean Excluir(int id) throws Exception
    {
    	 MercadoProdutoDao mpDao = new MercadoProdutoDao();
    	try
		{
    		if(!VerifiqueConexao())
		          return false;
    		
			sql="delete from produto where produtoId=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			mpDao.ExcluirProduto(id);
			return pst.executeUpdate() > 0? true: false;
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    }
    
    public ProdutoDto ListarCodigoBarra(long codigoBarra) throws Exception
    {
    	ProdutoDto produtoDto=null;
    	try
		{
    		if(!VerifiqueConexao())
    			return produtoDto;
    		
			sql="select * from produto where codigoBarra=?";
			pst=con.prepareStatement(sql);
			pst.setLong(1, codigoBarra);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				produtoDto = new ProdutoDto();
    			produtoDto.setCodigoBarra(rs.getLong("codigoBarra"));
    			produtoDto.setFoto(rs.getString("foto"));
    			produtoDto.setMarca(rs.getString("marca"));
    			produtoDto.setMedida(rs.getString("medida"));
    			produtoDto.setProdutoId(rs.getInt("produtoId"));
    			produtoDto.setTipo(rs.getString("tipo"));
    			produtoDto.setUnMedida(rs.getString("unMedida"));
			}
					
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	return produtoDto;
    }
    
    public ProdutoDto ListarNome(String tipo) throws Exception
    {
    	ProdutoDto produtoDto=null;
    	try
		{
    		if(!VerifiqueConexao())
    			return produtoDto;
    		
			sql="select * from produto where tipo like %?% or marca like %?%";
			pst=con.prepareStatement(sql);
			pst.setString(1, tipo);
			pst.setString(2, tipo);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				produtoDto = new ProdutoDto();
    			produtoDto.setCodigoBarra(rs.getLong("codigoBarra"));
    			produtoDto.setFoto(rs.getString("foto"));
    			produtoDto.setMarca(rs.getString("marca"));
    			produtoDto.setMedida(rs.getString("medida"));
    			produtoDto.setProdutoId(rs.getInt("produtoId"));
    			produtoDto.setTipo(rs.getString("tipo"));
    			produtoDto.setUnMedida(rs.getString("unMedida"));
			}
					
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	return produtoDto;
    }

}
