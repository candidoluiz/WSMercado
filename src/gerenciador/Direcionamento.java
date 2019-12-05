package gerenciador;

public enum Direcionamento
{
	mForward("forward:mercado/cadMercado.jsp"),
	mRedirect("redirect:Controller?acao=acao.mercado.ListaMercado"),
	pForward("forward:produto/cadProduto.jsp"),
	pRedirect("redirect:Controller?acao=acao.produto.ListaProduto"),
	mpForward("forward:mercadoProduto/cadMercadoProduto.jsp"),
	mpRedirect("redirect:Controller?acao=acao.mercadoProduto.ListaMercadoProduto"),
	lLogin("");
	
	private String descricao;
	
	Direcionamento(String descricao)
	{
		this.descricao=descricao;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
}
