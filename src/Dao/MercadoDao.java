package Dao;


//import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dto.MercadoDto;

public class MercadoDao
{

	private Connection con = null;
    private ResultSet rs;
    private PreparedStatement pst;
    private String sql = "";
    
    
    private void constroiStatement(MercadoDto mercadoDto, PreparedStatement pst) throws Exception
    {
    	
		pst.setString(1, mercadoDto.getNome());
		pst.setString(2, mercadoDto.getRua());
		pst.setString(3, mercadoDto.getNumero());
		pst.setString(4, mercadoDto.getBairro());
		pst.setString(5, mercadoDto.getFoto());
		pst.setString(6, mercadoDto.getCidade());
		pst.setString(7, mercadoDto.getUf());
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
    
    public MercadoDto RetornaRegistro(int id) throws Exception
    {
    	MercadoDto mercadoDto=null;
    	try
		{
    		if(!VerifiqueConexao())
				return mercadoDto;
    		
    		sql="select * from mercado where mercadoId=?";
    		pst=con.prepareStatement(sql);
    		pst.setInt(1, id);
    		rs=pst.executeQuery();
    		
    		while(rs.next())
    		{
    			mercadoDto=new MercadoDto();
    			
    			mercadoDto.setBairro(rs.getString("bairro"));
    			mercadoDto.setMercadoId(rs.getInt("mercadoId"));
    			mercadoDto.setNome(rs.getString("nome"));
    			mercadoDto.setRua(rs.getString("rua"));
    			mercadoDto.setNumero(rs.getString("numero"));
    			mercadoDto.setFoto(rs.getString("foto"));
    			mercadoDto.setCidade(rs.getString("cidade"));
    			mercadoDto.setUf(rs.getString("uf"));
    		}
    		
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	return mercadoDto;
    }
    
    public Boolean Salvar(MercadoDto mercadoDto) throws Exception
    {
    	try
		{
    		if(!VerifiqueConexao())
				return false;
    		
    		sql="insert into mercado(nome,rua,numero,bairro,foto,cidade,uf) values(?,?,?,?,?,?,?)";
    		pst=con.prepareStatement(sql);
    		constroiStatement(mercadoDto, pst);
    		
    		return pst.executeUpdate() > 0? true:false;
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	
    	
    }
    
    public List<MercadoDto> Listar() throws Exception
    {
    	List<MercadoDto> lista=new ArrayList<MercadoDto>();
        MercadoDto mercado;
        try
		{
        	if(!VerifiqueConexao())
		          return lista;
        	
        	sql="select * from mercado";
        	pst=con.prepareStatement(sql);
        	rs=pst.executeQuery();
        	
        	while(rs.next())
        	{
        		mercado = new MercadoDto();
        		//mercado.setImagem(rs.getBinaryStream("foto"));
        		mercado.setBairro(rs.getString("bairro"));
        		mercado.setMercadoId(rs.getInt("mercadoId"));
        		mercado.setNome(rs.getString("nome"));
        		mercado.setRua(rs.getString("rua"));
        		mercado.setNumero(rs.getString("numero"));
        		mercado.setFoto(rs.getString("foto"));
        		mercado.setCidade(rs.getString("cidade"));
        		mercado.setUf(rs.getString("uf"));
        		lista.add(mercado);
        	}
        	
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
        return lista;
    }
    
    public List<MercadoDto> ListarCidade() throws Exception
    {
    	List<MercadoDto> lista=new ArrayList<MercadoDto>();
        MercadoDto mercado;
        try
		{
        	if(!VerifiqueConexao())
		          return lista;
        	
        	sql="select distinct(m.cidade) from mercado m";
        	pst=con.prepareStatement(sql);
        	rs=pst.executeQuery();
        	
        	while(rs.next())
        	{
        		mercado = new MercadoDto();
        		
        		mercado.setCidade(rs.getString("cidade"));
        		lista.add(mercado);
        	}
        	
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
        return lista;
    }
    /*
    public Boolean listarImg(int id, HttpServletResponse response) throws Exception
    {
    	try
		{
    		if(!VerifiqueConexao())
		          return false;
    		
    		sql="select * from mercado where mercadoId=?";
    		InputStream inputStream=null;
    		OutputStream outputStream=null;
    		BufferedInputStream bufferedInputStream=null;
    		BufferedOutputStream bufferedOutputStream=null;
    		response.setContentType("image/*");
    		try
			{
				outputStream=response.getOutputStream();
				pst=con.prepareStatement(sql);
				pst.setInt(1, id);
				rs=pst.executeQuery();
				if(rs.next())
				{
					inputStream=rs.getBinaryStream("foto");
				}
				bufferedInputStream=new BufferedInputStream(inputStream);
				bufferedOutputStream=new BufferedOutputStream(outputStream);
				int i=0;
				while((i=bufferedInputStream.read())!=-1) 
				{
					bufferedOutputStream.write(i);
				}
				
				return true;
			} catch (Exception e)
			{
				throw new Exception(e.getMessage());
			}
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
    	
    }
    */
	public Boolean Atualizar(MercadoDto mercadoDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
		          return false;
			sql="update mercado set  nome=?, rua=?, numero=?, bairro=?,foto=?,cidade=?,uf=? where mercadoId=? ";
			pst=con.prepareStatement(sql);
			constroiStatement(mercadoDto, pst);
			pst.setInt(8, mercadoDto.getMercadoId());
			return pst.executeUpdate() > 0? true: false;
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
	public Boolean Excluir(int mercadoId) throws Exception
	{
		MercadoProdutoDao mpDao = new MercadoProdutoDao();
		try
		{
			if(!VerifiqueConexao())
		          return false;
			
			sql="delete from mercado where mercadoId=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, mercadoId);
			mpDao.ExcluirMercado(mercadoId);
			return pst.executeUpdate() > 0? true: false;
			
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
}
