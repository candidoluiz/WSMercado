<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/view/utilitario/cabecalho.jsp" %>

		<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="centro">RELACIONAR PRODUTOS</h1>
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
			
                <form method="Post" action="/Mercado/Controller?acao=acao.mercadoProduto.CadMercadoProduto">
					 

					 <div class="row">
					 
					 
					
					  	
					
					  	<div class="col-md-12">
					  		 <div class="form-group">
					  	<label for="sel1">MERCADO</label><br>
					  	<select class="form-control" id="sel1" name="txtMercado" required>
					  	<c:forEach var="ser" items="${listaMercado}">
					  		<option value="${ser.mercadoId }">${ser.cidade}-${ser.bairro}-${ser.nome}</option>
					  	</c:forEach>
					  	</select>
					  </div>
					  	</div>
					
					
					  	<div class="col-md-8">
					  		<div class="form-group">
					  			<label for="sel1">PRODUTO</label><br>
					  			<select class="form-control" id="sel1" name="txtProduto" required>
					  			<c:forEach var="ser" items="${listaProduto}">
					  				<option value="${ser.produtoId }">${ser.tipo}-${ser.marca} ${ser.medida} ${ser.unMedida}</option>
					  			</c:forEach>
					  			</select>

					  		</div>
					  	</div>


					 </div>

					 <div class="row">
					      
		    
					    <div class="col-md-4">
					  		 <div class="form-group">
					    		<label for="exampleInputPassword1">PREÇO</label>
                                <input name="txtPreco" autocomplete="off" type="text" class="form-control" id="exampleInputPreço" placeholder="Digite o Preço do Produto" required onKeyPress="return(moeda(this,'.',',',event))">
					  		</div>
					  	</div>


					</div>

					<button type="submit" class="btn btn-primary margemBotao" id="upload">Cadastrar</button>
				</form>
			</div>
		</div>
		<hr>
		
		<h1 class="centro">LISTA DE MERCADOS CADASTRADOS</h1>
		<div class="table-responsive table-light fonteP" style="margin-top:50px; margin-bottom:5px">
			<table class="table table-striped table-sm">
					<thead>
						<tr>
							<th>#</th>
							<th>LOGOTIPO</th>
							<th>MERCADO</th>
							<th>ENDEREÇO</th>						
							<th>BAIRRO</th>
							<th>CIDADE</th>
							<th>UF</th>							
							<th>PRODUTO</th>
							
							<th>PREÇO</th>
							

						</tr>
					</thead>

					<tbody>
					<c:forEach var="ser" items="${mercadosProdutos}">
						<tr>
							<td class="print"><b></b>${ser.mercadoProdutoId}</td>
							<td><img class="imagem_logo" src="${ser.mercadoDto.foto}"></td>
							<td><b>${ser.mercadoDto.nome}</b></td>
							<td><b>${ser.mercadoDto.rua}</b></td>
							<td><b>${ser.mercadoDto.bairro}</b></td>
							<td><b>${ser.mercadoDto.cidade}</b></td>
							<td><b>${ser.mercadoDto.uf}</b></td>
							<td>${ser.produtoDto.tipo}-${ser.produtoDto.marca}-${ser.produtoDto.medida} ${ser.produtoDto.unMedida}</td>
							
							<td><b>R$ ${ser.preco}</b></td>
							<td><img class="imagem_logo" src="${ser.produtoDto.foto}"></td>
							
							<td><a onClick=excluirAlerta('${ser.mercadoProdutoId}')><img src="./Resources/imagem/lixo.png" border="1" class="imagem_Icone" data-placement="right" title="Excluir"></a>
								<a  data-toggle="modal"  data-target="#exampleModalCenter" href=""><img src="./Resources/imagem/edit.png" border="1" class="imagem_Icone" style="margin-left:10px" data-placement="right" title="Editar" onClick="setaDadosModal('${ser.mercadoProdutoId}')"></a></td>							
						</tr>
						</c:forEach>
						
						
					</tbody>



				</table>
		</div>
		 <!-- Modal -->
	 				<form action="/Mercado/Controller?acao=acao.mercadoProduto.EditaMercadoProduto" method="post">
						<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
						  <div class="modal-dialog modal-dialog-centered" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLongTitle">Editar Relacionamento</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						      	<div class="row">
						      	<div class="col-md-12">
						        <label for="nome">MERCADO</label>
						        <select class="form-control" id="sel1" name="mMercado" required>
								  	<c:forEach var="ser" items="${listaMercado}">
								  		<option value="${ser.mercadoId }">${ser.cidade}-${ser.bairro}-${ser.nome}</option>
								  	</c:forEach>
								  	</select>
						        </div>
						        <br>
						        <div class="col-md-12">
						        <label for="exampleInputPassword1">PRODUTO</label>
					    		<select class="form-control" id="sel1" name="mProduto" required>
					  			<c:forEach var="ser" items="${listaProduto}">
					  				<option value="${ser.produtoId }">${ser.tipo}-${ser.marca} ${ser.medida} ${ser.unMedida}</option>
					  			</c:forEach>
					  			</select>
					    		</div>
					    		<br>
					    		
					    		<br>
					    		<div class="col-md-4">
					    		<label for="bairro">PREÇO</label>
					    		<input autocomplete="off" type="text" name="mPreco" class="form-control" id="mBairro" placeholder="R$" required onKeyPress="return(moeda(this,'.',',',event))">
					    		</div>
					    		</div>
					    		<br>
					    		<input type="hidden" name="txtId" id="mId">
						      <div class="modal-footer">
						        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
						        <button type="submit"  class="btn btn-primary">Editar</button>
						      </div>
						    </div>
						  </div>
						</div>
						</form>
<!-- fim modal-->
		<script language="javascript">   
		function moeda(a, e, r, t) {
    let n = ""
      , h = j = 0
      , u = tamanho2 = 0
      , l = ajd2 = ""
      , o = window.Event ? t.which : t.keyCode;
    if (13 == o || 8 == o)
        return !0;
    if (n = String.fromCharCode(o),
    -1 == "0123456789".indexOf(n))
        return !1;
    for (u = a.value.length,
    h = 0; h < u && ("0" == a.value.charAt(h) || a.value.charAt(h) == r); h++)
        ;
    for (l = ""; h < u; h++)
        -1 != "0123456789".indexOf(a.value.charAt(h)) && (l += a.value.charAt(h));
    if (l += n,
    0 == (u = l.length) && (a.value = ""),
    1 == u && (a.value = "0" + r + "0" + l),
    2 == u && (a.value = "0" + r + l),
    u > 2) {
        for (ajd2 = "",
        j = 0,
        h = u - 3; h >= 0; h--)
            3 == j && (ajd2 += e,
            j = 0),
            ajd2 += l.charAt(h),
            j++;
        for (a.value = "",
        tamanho2 = ajd2.length,
        h = tamanho2 - 1; h >= 0; h--)
            a.value += ajd2.charAt(h);
        a.value += r + l.substr(u - 2, u)
    }
    return !1
}
		
		
 </script> 
 <script>
		function excluirAlerta(id){
			
			  var r = confirm("Deseja excluir permanentemente a seleção? ");
			  if (r == true) {
			    window.location.href='/Mercado/Controller?acao=acao.mercadoProduto.RemoveMercadoProduto&txtId='+id;
			  } 
		}
		function setaDadosModal(id) {
			document.getElementById('mId').value = id;
		    
		}
	</script>
	
	<c:if test="${!empty ok}">
	<script>

  		alert("Mercado cadastrato com sucesso!");

	</script>
	</c:if>
	</div>