<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Carrinho de Compra</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
        <!-- bootstrap -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="themes/css/bootstrappage.css" rel="stylesheet" />

        <!-- global styles -->
        <link href="themes/css/flexslider.css" rel="stylesheet" />
        <link href="themes/css/main.css" rel="stylesheet" />

        <!-- scripts -->
        <script src="themes/js/jquery-1.7.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="themes/js/superfish.js"></script>
        <script src="themes/js/jquery.scrolltotop.js"></script>
        <!--[if lt IE 9]>			
                    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                    <script src="themes/js/respond.min.js"></script>
            <![endif]-->
    </head>

    <body>
        <div id="top-bar" class="container">
            <div class="row">
                <div class="span4">
                    <form method="POST" class="search_form">
                        <input type="text" class="input-block-level search-query" Placeholder="O que você está procurando?">
                    </form>
                </div>
                <div class="span8">
                    <div class="account pull-right">
                        <ul class="user-menu">				
                            <li><a href="${pageContext.request.contextPath}/carrinho">Carrinho</a></li>
                            <li><a href="${pageContext.request.contextPath}/meus-pedidos">Meus Pedidos</a></li>
                                <c:if test="${nLogadoAttr}">
                                <li><a href="${pageContext.request.contextPath}/login-cliente">Login</a></li>
                                </c:if>
                                <c:if test="${LogadoAttr}">
                                <li><a href="${pageContext.request.contextPath}/editar-cliente">Meu Cadastro</a></li>
                                <li><a href="${pageContext.request.contextPath}/logout-cliente">Logout</a></li>
                                </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="wrapper" class="container">
            <section class="navbar main-menu">
                <div class="navbar-inner main-menu">
                    <a href="${pageContext.request.contextPath}/land" class="logo pull-left logo-size"><i
                            class="fas fa-shopping-cart"></i> Sports TADS</a>
                    <nav id="menu" class="pull-right">
                        <ul>
                            <li><a href="./products.html">Masculino</a>
                                <ul>
                                    <li><a href="#">Camisetas</a></li>
                                    <li><a href="#">Tênis</a></li>
                                    <li><a href="#">Bermudas</a></li>
                                </ul>
                            </li>
                            <li><a href="./products.html">Feminino</a>
                                <ul>
                                    <li><a href="#">Camisetas</a></li>
                                    <li><a href="#">Tênis</a></li>
                                    <li><a href="#">Bermudas</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Equipamentos</a>
                                <ul>
                                    <li><a href="#">Academia</a></li>
                                    <li><a href="#">Esportes</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Mais Vendidos</a></li>
                        </ul>
                    </nav>
                </div>
            </section>
            <section class="header_text sub">
                <img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/banner1.jpg"
                     alt="New products">
                <br>
            </section>
            <section class="main-content">
                <div class="row">
                    <div class="span9">
                        <h4 class="title"><span class="text"><strong>Meu</strong> Carrinho</span></h4>
                        <c:if test="${not empty produtosAttr}">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Retirar Produto</th>
                                        <th>Atualizar Quantidade </th>
                                        <th>Nome do Produto</th>
                                        <th>Quantidade</th>
                                        <th>Valor Unitário</th>
                                        <th>Valor Total</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${produtosAttr}" var="produto">

                                        <tr>
                                            <td><button type="button" class="btn btn-primary" data-toggle="modal"
                                                        data-target="#p${produto.getProduto().getId()}">Excluir</button></td>

                                    <form class="form-inline" method="post" action="${pageContext.request.contextPath}/continuar-comprando">
                                        <td>
                                            <input type="hidden" name="id" value="${produto.getProduto().getId()}">

                                            <button class="btn btn-primary" type="submit" id="checkout">Atualizar</button>
                                        </td>

                                        <td>
                                            <c:out value="${produto.getProduto().getNome()}" />
                                        </td>
                                        <td><input name="qtdProduto_${produto.getProduto().getId()}" type="number" placeholder="1" class="input-mini" id="qtdProduto_${produto.getProduto().getId()}"
                                                   min="0" data-bind="qtdProduto_${produto.getProduto().getId()}" value="${produto.getQuantidade()}" onClick="teste('qtdProduto_${produto.getProduto().getId()}', 'preco_${produto.getProduto().getId()}', 'totalProd_${produto.getProduto().getId()}')"></td>
                                        <td> <input type="text" class="input-mini " id="preco_${produto.getProduto().getId()}" data-bind="preco_${produto.getProduto().getId()}" value="${produto.getProduto().getPreco()}">
                                        </td>
                                        <td><input type="text" class="input-mini totalProd" id="totalProd_${produto.getProduto().getId()}" data-bind="totalProd_${produto.getProduto().getId()}" value="${produto.vlrTotalItem()}" />
                                        </td>
                                        </tr>
                                    </form>
                                    <div class="modal fade" id="p${produto.getProduto().getId()}" tabindex="-1"
                                         role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-body">
                                                    Tem certeza que deseja excluir o produto
                                                    <c:out value="${produto.getProduto().getNome()}" />
                                                </div>
                                                <div class="modal-footer">
                                                    <form action="${pageContext.request.contextPath}/excluirItem"
                                                          method="post">
                                                        <button class="btn btn-success" type="submit" name="id"
                                                                id="confirmDeleteButton"
                                                                value="${produto.getProduto().getId()}">Confirmar</button>
                                                    </form>

                                                    <button type="button" class="btn btn-danger"
                                                            data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty produtosAttr}">
                                <h2 style=" text-align: center;">Carrinho vazio</h2>
                            </c:if>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td><strong>R$
                                        <input type="text" placeholder="1" class="input-mini" id="total"
                                               min="0" data-bind="total" value="${totalAttr}" /></strong></td>
                            </tr>
                            </tbody>
                        </table>

                        <c:if test="${not empty produtosAttr}">

                            <div class="button-group" style="display: -webkit-inline-box;">


                                <form class="form-inline" method="get" action="${pageContext.request.contextPath}/listar-enderecos">
                                    <button class="btn btn-inverse" type="submit" id="checkout">Finalizar compra</button>
                                </form>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                <a class="btn btn-inverse" href="${pageContext.request.contextPath}/land">Continuar comprando</a>

                            </div>
                        </c:if>
                    </div>
                    <div class="span3 col">
                        <div class="block">
                            <ul class="nav nav-list">
                                <li class="nav-header">Melhores Marcas</li>
                                <li><a href="#">Nike</a></li>
                                <li class="active"><a href="products.html">Adidas</a></li>
                                <li><a href="#">Puma</a></li>
                                <li><a href="#">Olympikus</a></li>
                                <li><a href="#">Mizuno</a></li>
                            </ul>
                        </div>
                        <div class="block">
                            <h4 class="title"><strong>Mais</strong> Vendido</h4>
                            <li class="active"><a href="products.html"></a> </li>
                            <ul class="small-product">
                            </ul>
                        </div>
                    </div>

                </div>

            </section>
            <section id="footer-bar">
                <div class="row">
                    <div class="span3">
                        <h4>Navegação</h4>
                        <ul class="nav">
                            <li><a href="#">Principal</a></li>
                            <li><a href="#">Sobre nós</a></li>
                            <li><a href="#">Seu carrinho</a></li>
                            <li><a href="#">Login</a></li>
                        </ul>
                    </div>
                    <div class="span4">
                        <h4>Minha conta</h4>
                        <ul class="nav">
                            <li><a href="#">Minha conta</a></li>
                            <li><a href="#">Meus pedidos</a></li>
                        </ul>
                    </div>
                    <div class="span5">
                        <p class="logo logo-size-endpage"><i class="fas fa-shopping-cart"></i> Sports TADS</a>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. the Lorem Ipsum has
                            been the industry's standard dummy text ever since the you.</p>
                        <br />
                        <span class="social_icons">
                            <a class="facebook" href="#">Facebook</a>
                            <a class="twitter" href="#">Twitter</a>
                            <a class="skype" href="#">Skype</a>
                            <a class="vimeo" href="#">Vimeo</a>
                        </span>
                    </div>
                </div>
            </section>

            <section id="copyright">
                <span>Copyright 2013 bootstrappage template All right reserved.</span>
            </section>
        </div>
        <script src="${pageContext.request.contextPath}/themes/js/common.js"></script>
        <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>


        <script>
            function teste(qtd, preco, total) {
                var quant = document.getElementById(qtd).value;
                var prec = document.getElementById(preco).value;
                var tot = document.getElementById(total).value;

                tot = quant * prec

                document.getElementById(total).value = tot;
                soma();
            }

            function soma() {
                var valores = document.getElementsByClassName('totalProd');
                var total = 0;

                for (var i = 0; i < valores.length; i++) {
                    valor = document.getElementById(valores[i].id).value
                    total = parseInt(total) + parseInt(valor);
                }

                document.getElementById('total').value = total;
            }
        </script>

    </body>

</html>
