package Dto;

public class ProdutoDto
{
	private int produtoId;
	private String tipo;
	private String marca;
	private long codigoBarra;
	private String foto;
	private String medida;
	private String unMedida;
	
	
	
	public String getUnMedida()
	{
		return unMedida;
	}
	public void setUnMedida(String unMedida)
	{
		this.unMedida = unMedida;
	}
	public int getProdutoId()
	{
		return produtoId;
	}
	public void setProdutoId(int produtoId)
	{
		this.produtoId = produtoId;
	}
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public String getMarca()
	{
		return marca;
	}
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	public long getCodigoBarra()
	{
		return codigoBarra;
	}
	public void setCodigoBarra(long codigoBarra)
	{
		this.codigoBarra = codigoBarra;
	}
	public String getFoto()
	{
		return foto;
	}
	public void setFoto(String foto)
	{
		this.foto = foto;
	}
	public String getMedida()
	{
		return medida;
	}
	public void setMedida(String medida)
	{
		this.medida = medida;
	}
	
}
