package Dto;

public class MercadoProdutoDto
{
	int mercadoProdutoId;
	MercadoDto mercadoDto;
	ProdutoDto produtoDto;
	double preco;
	
	public int getMercadoProdutoId()
	{
		return mercadoProdutoId;
	}
	public void setMercadoProdutoId(int mercadoProdutoId)
	{
		this.mercadoProdutoId = mercadoProdutoId;
	}
	public MercadoDto getMercadoDto()
	{
		return mercadoDto;
	}
	public void setMercadoDto(MercadoDto mercadoDto)
	{
		this.mercadoDto = mercadoDto;
	}
	public ProdutoDto getProdutoDto()
	{
		return produtoDto;
	}
	public void setProdutoDto(ProdutoDto produtoDto)
	{
		this.produtoDto = produtoDto;
	}
	public double getPreco()
	{
		return preco;
	}
	public void setPreco(double preco)
	{
		this.preco = preco;
	}
	
	

}
