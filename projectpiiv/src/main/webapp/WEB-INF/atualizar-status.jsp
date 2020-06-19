<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
        <!-- bootstrap -->
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
        <link href="${pageContext.request.contextPath}}/themes/css/bootstrappage.css" rel="stylesheet"/>

        <!-- global styles -->
        <link href="${pageContext.request.contextPath}/themes/css/flexslider.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/themes/css/main.css" rel="stylesheet"/>

        <!-- scripts -->
        <script src="${pageContext.request.contextPath}/themes/js/jquery-1.7.2.min.js"></script>				
        <script src="${pageContext.request.contextPath}/themes/js/superfish.js"></script>	
        <script src="${pageContext.request.contextPath}/themes/js/jquery.scrolltotop.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>


        <title>Loja de Artigos Esportivos</title>
    </head>
    <header>

        <nav class="navbar navbar-expand-lg navbar-light nav-color">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/estoquista">Loja Esportiva</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/estoquista/listar-produtos-estoquista">Listar Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/estoquista/listar-pedidos">Listar Pedidos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Pedidos</h1>
        </div>
        <c:if test="${excluidoAttr}">
            <div class="alert alert-success">
                Produto excluído com sucesso!
            </div>
        </c:if>
        <div id="wrapper" class="container" style="width: 951px;">
            <section class="main-content">

                <div class="span9">
                    <c:if test="${not empty vendaAttr}">
                        <div class="block">	
                            <h3 style="font-size: 25px;">Pedido</h3>
                            <table class="table table-sm offset-md-2"  style="margin-left: 0;">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Data Pedido</th>
                                        <th scope="col">Status</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td> <c:out value="${vendaAttr.getId()}"/></td>
                                        <td ><c:out value="${vendaAttr.getDataVenda()}"/></td>
                                <form action="${pageContext.request.contextPath}/estoquista/atualizar-status" method="post" class="form-stacked">
                                    <input type="hidden" value="${vendaAttr.getId()}" name="idVenda" id="idVenda">
                                    <td>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Status:</label>
                                            <select class="form-control form-control-sm col-sm-8" name="status" id="status">
                                                <c:choose>
                                                    <c:when test="${vendaAttr.getStatusCompra() == 'Aguardando Confirmação de Pagamento'}">
                                                        <option selected>Aguardando Confirmação de Pagamento</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>Aguardando Confirmação de Pagamento</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                        
                                                <c:choose>
                                                    <c:when test="${vendaAttr.getStatusCompra() == 'Pagamento Confirmado'}">
                                                         <option selected>Pagamento Confirmado</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                         <option>Pagamento Confirmado</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                        
                                                <c:choose>
                                                    <c:when test="${vendaAttr.getStatusCompra() == 'Pedido Enviado'}">
                                                        <option selected>Pedido Enviado</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>Pedido Enviado</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                        
                                                <c:choose>
                                                    <c:when test="${vendaAttr.getStatusCompra() == 'Pedido Entregue'}">
                                                        <option selected>Pedido Entregue</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>Pedido Entregue</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </select>
                                        </div>
                                    </td>
                                    <td><button type="submit" class="btn btn-inverse large">Alterar</button></td>
                                </form>

                                </tr>
                            </table>
                        </div>
                        <div class="block" style="border-top: none;">	
                            <h3 style="font-size: 25px;">Produtos</h3>
                            <table class="table table-sm offset-md-2" style="margin-left: 0;">
                                <thead>
                                    <tr>
                                        <th scope="col">Produto</th>
                                        <th scope="col">Quantidade</th>
                                        <th scope="col">Preço Unitário</th>
                                        <th scope="col">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${vendaAttr.getItensVenda()}" var="item">
                                        <tr>
                                            <td><c:out value="${item.getProduto().getNome()}"/></td>
                                            <td><c:out value="${item.getQuantidade()}"/></td>
                                            <td><c:out value="${item.getProduto().getPreco()}"/></td>
                                            <td><c:out value="${item.vlrTotalItemF()}"/></td>
                                        </tr>
                                    </c:forEach>
                            </table>
                        </div>
                        <div class="block" style="border-top: none;">
                            <h3 style="float: left; clear: both; margin-left: 80px;"><strong style="color: red;">Total</strong> Venda: R$ <c:out value="${vendaAttr.getValorTotal()}"/></h3>
                            <h3><strong style="color: red;">Forma</strong> de Pagamento: <c:out value="${vendaAttr.getMetodoPagamento()}"/></h3>
                        </div>
                        <div class="block" style="border-top: none;">	
                            <h3 style="font-size: 25px;">Endereço de Entrega</h3>
                            <table class="table table-sm offset-md-2">
                                <thead>
                                    <tr>
                                        <th scope="col">Rua</th>
                                        <th scope="col">Número</th>
                                        <th scope="col">Complemento</th>
                                        <th scope="col">CEP</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>

                                        <td> <c:out value="${vendaAttr.getEndereco().getRua()}"/></td>
                                        <td> <c:out value="${vendaAttr.getEndereco().getNumero()}"/></td>
                                        <td> <c:out value="${vendaAttr.getEndereco().getComplemento()}"/></td>
                                        <td> <c:out value="${vendaAttr.getEndereco().getCep()}"/></td>
                                    </tr>
                            </table>

                            <table class="table table-sm offset-md-2">
                                <thead>
                                    <tr>
                                        <th scope="col">Bairro</th>
                                        <th scope="col">Cidade</th>
                                        <th scope="col">Estado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td> <c:out value="${vendaAttr.getEndereco().getBairro()}"/></td>
                                        <td> <c:out value="${vendaAttr.getEndereco().getCidade()}"/></td>
                                        <td> <c:out value="${vendaAttr.getEndereco().getEstado()}"/></td>
                                    </tr>
                            </table>
                            <hr style="background-color: red; height: 1px;">
                            <h3 style="font-size: 25px;"><strong style="color: red;">Valor</strong> Frete: R$ <c:out value="${vendaAttr.getValorFrete()}"/></h3>
                        </div>
                    </c:if>
                </div>


            </section>
        </div>

    </body>

    <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>
