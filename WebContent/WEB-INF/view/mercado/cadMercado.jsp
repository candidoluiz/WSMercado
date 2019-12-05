<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/view/utilitario/cabecalho.jsp" %>


   	
	
	<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="centro">CADASTRO DE MERCADO</h1>
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
			
                            <form method="Post" action="/Mercado/Controller?acao=acao.mercado.CadMercado">

					<div class="form-group">
					    <label for="exampleInputEmail1">NOME</label>
					    <input name="txtNome" type="text" class="form-control" id="exampleInputEmail1" placeholder="Digite o nome do Mercado" required >
					    
					  </div>
					  <div class="row">
					  	<div class="col-md-6">
					  		 <div class="form-group">
					    		<label for="exampleInputPassword1">RUA/AV.</label>
                                <input name="txtRua" type="text" class="form-control" id="exampleInputPassword1" placeholder="Digite o nome da Rua/Av." required >
					  		</div>
					  	</div>
					  	<div class="col-md-2">
					  		<div class="form-group">
					    		<label for="numero">NUMERO</label>
					    		<input name="txtNumero" type="text" class="form-control" id="numero" required >
					  		</div>
					  	</div>
					  	<div class="col-md-4">
					  		<div class="form-group">
					    		<label for="bairro">BAIRRO</label>
					    		<input name="txtBairro" type="text" class="form-control" id="bairro" placeholder="Digite o bairro" required >
					  		</div>
					  	</div>
					  </div>
					 

					  <div class="row">
					  	<div class="col-md-3">
					  		 <div class="form-group">
					  	<label>UF:</label><br>
					  	<select id="txtUF" name="txtUF" class="form-control">
					  		<option value="SP">SP</option>
					  	</select>
					  </div>
					  	</div>

					  	<div class="col-md-3">
					  		<div class="form-group">
					  			<label>CIDADE</label><br>
					  			
					  			<select id="txtCidade" name="txtCidade" class="form-control">
					  				<option value="Birigui">BIRIGUI</option>
					  				<option value="Araçatuba">ARAÇATUBA</option>
					  			</select>

					  		</div>
					  	</div>

					  	<div class="col-md-3">
					  		<div class="form-group">
					  			<label>LOGOTIPO</label><br>
					  			<input accept="image/*" style="font-size: 15px;"type="file" name="txtFile" class="btn btn-info" id="foto" required="required">

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
							<th>ESTABELECIMENTO</th>
							<th>ENDEREÇO</th>
							<th>NUMERO</th>
							<th>BAIRRO</th>
							<th>CIDADE</th>
							<th>UF</th>
							<th>LOGOTIPO</th>
							

						</tr>
					</thead>

					<tbody>
					<c:forEach var="ser" items="${mercados}">
						<tr>
							<td class="print"><b>${ser.mercadoId}</b></td>
							<td><b>${ser.nome}</b></td>
							<td><b>${ser.rua}</b></td>
							<td><b>${ser.numero }</b></td>
							<td><b>${ser.bairro}</b></td>
							<td><b>${ser.cidade}</b></td>
							<td><b>${ser.uf}</b></td>
							<td><img class="imagem_logo" src="${ser.foto}"></td>
							
							<td><a onClick=excluirAlerta('${ser.mercadoId}','${ser.nome}')><img src="./Resources/imagem/lixo.png" border="1" class="imagem_Icone" data-placement="right" title="Excluir"></a>
								<a data-toggle="modal"  data-target="#exampleModalCenter" href="1"><img src="./Resources/imagem/edit.png" border="1" 
								class="imagem_Icone" style="margin-left:10px" 
								data-placement="right" title="Editar" onClick="setaDadosModal('${ser.mercadoId}','${ser.nome}','${ser.rua}','${ser.numero }','${ser.bairro }','${ser.cidade}','${ser.uf}','${ser.foto}')"></a></td>							
						</tr>
						</c:forEach>
						
						
					</tbody>



				</table>
		</div>
	</div>

	 <!-- Modal -->
	 				<form action="/Mercado/Controller?acao=acao.mercado.EditaMercado" method="post">
						<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
						  <div class="modal-dialog modal-dialog-centered" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLongTitle">Editar Mercado</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						      	<div class="row">
						      	<div class="col-md-12">
						        <label for="nome">NOME</label>
						        <input type="text" name="mNome" class="form-control" id="mNome" placeholder="Digite o nome do Mercado" required>
						        </div>
						        <br>
						        <div class="col-md-12">
						        <label for="exampleInputPassword1">RUA/AV.</label>
					    		<input type="text" name="mRua" class="form-control" id="mRua" placeholder="Digite o nome da Rua/Av." required>
					    		</div>
					    		<br>
					    		<div class="col-md-3">
					    		<label for="numero">NUMERO</label>
					    		<input type="text" name="mNumero" class="form-control" id="mNumero" required>
					    		</div>
					    		<br>
					    		<div class="col-md-12">
					    		<label for="bairro">BAIRRO</label>
					    		<input type="text" name="mBairro" class="form-control" id="mBairro" placeholder="Digite o bairro" required>
					    		</div>
					    		</div>
					    		<br>
					    		<div class="row">
					  	<div class="col-md-6">
					  		 <div class="form-group">
					  	<label>UF:</label><br>
					  	<select name="mUf">
					  		<option value="SP">SP</option>
					  	</select>
					  </div>
					  	</div>

					  	<div class="col-md-6">
					  		<div class="form-group">
					  			<label>CIDADE</label><br>
					  			<select name="mCidade">
					  				<option value="Birigui">BIRIGUI</option>
					  				<option value="Araçatuba">ARAÇATUBA</option>
					  			</select>
					  			
					  			

					  		</div>
					  		<input type="hidden" name="txtId" id="mId">
					  	</div>
					  	<div class="col-md-3">
					  		<div class="form-group">
					  			<label>LOGOTIPO</label><br>
					  			<input accept="image/*" style="font-size: 15px;"type="file" name="mFile" class="btn btn-info" id="foto" required="required">

					  		</div>
					  	</div>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
						        <button type="submit"  class="btn btn-primary">Editar</button>
						      </div>
						    </div>
						  </div>
						</div>
						</form>
<!-- fim modal-->
	<script>
		function excluirAlerta(id,nome){
			
			  var r = confirm("Deseja excluir permanentemente o mercado "+nome);
			  if (r == true) {
			    window.location.href='/Mercado/Controller?acao=acao.mercado.RemoveMercado&txtId='+id;
			  } 
		}
		function setaDadosModal(id,nome,rua,numero,bairro,cidade,uf,foto) {
			document.getElementById('mId').value = id;
		    document.getElementById('mNome').value = nome;	    
		    document.getElementById('mRua').value = rua;
		    document.getElementById('mNumero').value = numero;
		    document.getElementById('mBairro').value = bairro;
		    document.getElementById('mCidade').value = cidade;
		    document.getElementById('mUf').value = uf;
		    document.getElementById('mFile').value = foto;
		}
	</script>
	
	<c:if test="${!empty ok}">
	<script>

  		alert("Mercado cadastrato com sucesso!");

	</script>
	</c:if>
	
</body>
</html>
