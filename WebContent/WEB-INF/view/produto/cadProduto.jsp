<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/view/utilitario/cabecalho.jsp" %>

<div class="container">
  <div class="row">
      <div class="col">
        <h1 class="centro">CADASTRO DE PRODUTO</h1>
        <hr>
      </div>
    </div>
    <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
    
  <form id="formCad" method="post" action="/Mercado/Controller?acao=acao.produto.CadProduto">
   
    <div class="row">
      <div class="col-md-4">
      	<div class="form-group">
        <label for="inputTipo">TIPO</label>
        
        <select id="txtTipo" name="txtTipo" class="form-control">
			<option value="Arroz">ARROZ</option>
			<option value="Feijão">FEIJÃO</option>
			<option value="Extrato_de_Tomate">EXTRATO DE TOMATE</option>
			<option value="Macarrão">MACARRÃO</option>
			<option value="Desinfetante">DESINFETANTE</option>
			<option value="Palmito">PALMITO</option>
			<option value="Açucar-Refinado">AÇUCAR REFINADO</option>
			<option value="Creme_de_leite">CREME DE LEITE</option>
		</select>
		</div>	  			
        
      </div>
      <div class="form-group col-md-4">
        <label for="inputMarca">MARCA</label>
        <select id="txtMarca" name="txtMarca" class="form-control">
			<option value="Anceli">ANCELI</option>
			<option value="Elefante">ELEFANTE</option>
			<option value="Pedretti">PEDRETTI</option>
			<option value="Basilar">BASILAR</option>
			<option value="Veja">VEJA</option>
			<option value="Folquet">FOLQUETE</option>
			<option value="Uniao">UNIÃO</option>
			<option value="Promissao">Promissão</option>
		</select>
      </div>
      <div class="form-group col-md-4">
        <label for="inputCodigo">CÓDIGO DE BARRA</label>
        <input name="txtCodigoBarra" type="number" class="form-control" placeholder="Cod. de Barra do Produto" required >
      </div>
    </div>

    <div class="row">

     <div class="col-md-4">
        <label for="inputMedida">MEDIDA</label>
        <input name="txtMedida" type="number" class="form-control"id="inputMedida" placeholder="Medida do Produto" required >
      </div>
        
      

      <div class="col-md-4">
        <label for="sel1">Un.MEDIDA</label>
        <select class="form-control" id="sel1" name="txtUnMedida">
          <option value="Ml">Ml</option>
          <option VALUE="G">G</option>
          <option VALUE="Kg">Kg</option>
          <option VALUE="L">L</option>
          <option VALUE="Ml">Ml</option>
        </select>
      </div>

      

    </div>

    <div class="row">
      <div class="form-group col-md-4">
        <br>
        <label>LOGO/PRODUTO</label><br>
        <input type="file" name="txtFoto" class="btn btn-info" id="foto" required >
      </div>

      <div class="form-group col-md-10">
 
        <button type="submit" class="btn btn-primary margemBotao">Cadastrar</button>
      </div>
    </div>

  </form>
  </div>
  </div>
  <hr>
  <h1 class="centro">LISTA DE PRODUTOS CADASTRADOS</h1>
		<div class="table-responsive table-light fonteP" style="margin-top:50px; margin-bottom:5px">
			<table class="table table-striped table-sm">
					<thead>
						<tr>
							<th>#</th>
							<th>TIPO</th>
							<th>MARCA</th>
							<th>COD_BARRAS</th>
							<th>MEDIDA</th>
							<th>UN_MEDIDA</th>
							<th>FOTO</th>
							
							

						</tr>
					</thead>

					<tbody>
					<c:forEach var="ser" items="${produtos}">
						<tr>
							<td name="txtId" class="print"><b>${ser.produtoId}</b></td>
							<td><b>${ser.tipo}</b></td>
							<td><b>${ser.marca}</b></td>
							<td><b>${ser.codigoBarra}</b></td>
							<td><b>${ser.medida}</b></td>
							<td><b>${ser.unMedida}</b></td>
							<td><img class="imagem_logo" src="${ser.foto}"></td>
							
							<td><a onClick=excluirAlertas('${ser.produtoId}','${ser.tipo}')><img src="./Resources/imagem/lixo.png" border="1" class="imagem_Icone" data-placement="right" title="Excluir"></a>
								<a data-toggle="modal"  data-target="#exampleModalCenter" href="1">
								<img src="./Resources/imagem/edit.png" border="1" class="imagem_Icone" style="margin-left:10px" data-placement="right" title="Editar" onClick="setaDadosModal('${ser.produtoId}','${ser.codigoBarra}','${ser.medida}')"></a></td>							
						</tr>
						</c:forEach>
						
						
					</tbody>



				</table>
		</div>
</div>
	<!-- Modal -->
	 				<form action="/Mercado/Controller?acao=acao.produto.EditaProduto" method="post">
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
						        <label for="nome">TIPO</label>
						        <select id="txtTipo" name="mTipo" class="form-control">
									<option value="Arroz">ARROZ</option>
									<option value="Feijão">FEIJÃO</option>
									<option value="Extrato_de_Tomate">EXTRATO DE TOMATE</option>
									<option value="Macarrão">MACARRÃO</option>
									<option value="Desinfetante">DESINFETANTE</option>
									<option value="Palmito">PALMITO</option>
								</select>
						        </div>
						        
						        <br>
						        <div class="col-md-12">
						        <label for="exampleInputPassword1">MARCA</label>
					    		<select id="txtMarca" name="mMarca" class="form-control">
									<option value="Anceli">ANCELI</option>
									<option value="Elefante">ELEFANTE</option>
									<option value="Pedretti">PEDRETTI</option>
									<option value="Basilar">BASILAR</option>
									<option value="Veja">VEJA</option>
									<option value="Folquet">FOLQUETE</option>
								</select>
					    		</div>
					    		
					    		<br>
					    		<div class="col-md-5">
					    		<label for="numero">COD.BARRA</label>
					    		<input type="number" name="mCodBarra" class="form-control" id="mCod" required>
					    		</div>
					    		<br>
					    		
					    		<div class="col-md-12">
					    		<label for="bairro">UN.MEDIDA</label>
					    		<select class="form-control" id="sel1" name="mUnMedida">
						          <option value="MILIGRAMAS">MILIGRAMAS</option>
						          <option VALUE="GRAMAS">GRAMAS</option>
						          <option VALUE="KILOGRAMAS">KILOGRAMAS</option>
						          <option VALUE="LITROS">LITROS</option>
						          <option VALUE="MILILITROS">MILILITROS</option>
						        </select>
					    		</div>
					    		
					    		</div>
					    		<br>
					    		<div class="row">
					  	<div class="col-md-6">
					  		 <div class="form-group">
					  			<label for="inputMedida">MEDIDA</label>
       						 	<input name="mMedida" type="number" class="form-control"id="mMedida" placeholder="Medida do Produto" required >
					 		 </div>
					  	</div>

					  	<div class="col-md-6">
					  		
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
		function excluirAlertas(id,nome){
			
			  var r = confirm("Deseja excluir permanentemente o produto "+nome);
			  if (r == true) {
			    window.location.href='/Mercado/Controller?acao=acao.produto.RemoveProduto&txtId='+id;
			  } 
		}
		function setaDadosModal(id,cod,medida) {
			document.getElementById('mId').value = id;
		    document.getElementById('mCod').value = cod;	    
		    document.getElementById('mMedida').value = medida;
		    
		}
	</script>
	<c:if test="${!empty ok}">
	<script>

  		alert("Produto cadastrato com sucesso!");

	</script>
	</c:if>
	
</body>
</html>