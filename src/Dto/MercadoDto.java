package Dto;


import java.io.InputStream;

public class MercadoDto
{
	private int mercadoId;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    //private InputStream imagem;
    private String foto;
    private String cidade;
    private String uf;
    
    
	
	public String getCidade()
	{
		return cidade;
	}
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
	public String getUf()
	{
		return uf;
	}
	public void setUf(String uf)
	{
		this.uf = uf;
	}
	public String getFoto()
	{
		return foto;
	}
	public void setFoto(String foto)
	{
		this.foto = foto;
	}/*
	public InputStream getImagem()
	{
		return imagem;
	}
	public void setImagem(InputStream imagem)
	{
		this.imagem = imagem;
	}*/
	public int getMercadoId()
	{
		return mercadoId;
	}
	public void setMercadoId(int mercadoId)
	{
		this.mercadoId = mercadoId;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getRua()
	{
		return rua;
	}
	public void setRua(String rua)
	{
		this.rua = rua;
	}
	public String getBairro()
	{
		return bairro;
	}
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}
	public String getNumero()
	{
		return numero;
	}
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
    
    
}
