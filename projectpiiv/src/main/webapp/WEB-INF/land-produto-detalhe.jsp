<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Sports TADS - Detalhes do Produto </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
        <!-- bootstrap -->
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
        <link href="${pageContext.request.contextPath}}/themes/css/bootstrappage.css" rel="stylesheet"/>

        <!-- global styles -->
        <link href="${pageContext.request.contextPath}/themes/css/flexslider.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/themes/css/main.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/themes/css/jquery.fancybox.css" rel="stylesheet"/>

        <!-- scripts -->
        <script src="${pageContext.request.contextPath}/themes/js/jquery-1.7.2.min.js"></script>				
        <script src="${pageContext.request.contextPath}/themes/js/superfish.js"></script>	
        <script src="${pageContext.request.contextPath}/themes/js/jquery.fancybox.js"></script>
        <script src="${pageContext.request.contextPath}/themes/js/jquery.scrolltotop.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
        <!--[if lt IE 9]>			
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
                <script src="js/respond.min.js"></script>
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

                            <li><a href="#">Carrinho</a></li>
                            <li><a href="#">Meus Pedidos</a></li>
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
                    <a href="${pageContext.request.contextPath}/land" class="logo pull-left logo-size"><i class="fas fa-shopping-cart"></i> Sports TADS</a>
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
                <img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/banner1.jpg" alt="New products" >
                <br>
                <h3><span>Detalhes do Produto</span></h3>
            </section>
            <section class="main-content">
                <div class="row">						
                    <div class="span9">
                        <div class="row">
                            <c:if test="${not empty produtosAttr}">
                                <div class="span4">
                                    <div id="myCarousel${produto.getId()}" class="carousel slide">
                                        <div class="carousel-inner">
                                            <div class="active item">
                                                <img src="${pageContext.request.contextPath}/img/${produtosAttr.getImagens()[0]}" style="width: 300px; height: 250px;">
                                            </div>
                                            <c:forEach items="${produtosAttr.getImagens()}" var="imagem" begin="1">
                                                <div class="item">
                                                    <img src="${pageContext.request.contextPath}/img/${imagem}" style="width: 300px; height: 250px;">
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <a class="carousel-control left" href="#myCarousel${produto.getId()}" data-slide="prev">&lsaquo;</a>
                                        <a class="carousel-control right" href="#myCarousel${produto.getId()}" data-slide="next">&rsaquo;</a>
                                    </div>
                                </div>
                                <div class="span5">
                                    <address>
                                        <strong>Nome do Produto:</strong> <span><c:out value="${produtosAttr.getNome()}"/></span><br>
                                        <strong>Quantidade em Estoque</strong> <span><c:out value="${produtosAttr.getQuantidade()}"/></span><br>								
                                    </address>	

                                    <h4><strong>Preço: R$ <c:out value="${produtosAttr.getPreco()}"/></strong></h4>
                                </div>
                                <p>&nbsp;</p>
                                <div class="span5">
                                    <form class="form-inline">
                                        <!--<label class="checkbox">
                                                <input type="checkbox" value=""> Option one is this and that
                                        </label>
                                        <br/>
                                        <label class="checkbox">
                                          <input type="checkbox" value=""> Be sure to include why it's great
                                        </label> -->
                                        <label><strong>Tamanho:</strong></label>
                                        <select class="form-control">
                                            <option>36</option>
                                            <option>37</option>
                                            <option>38</option>
                                            <option>39</option>
                                            <option>40</option>
                                            <option>41</option>
                                            <option>42</option>
                                            <option>43</option>
                                            <option>44</option>
                                        </select>
                                        <p>&nbsp;</p>
                                        <label><strong>Qtd:</strong></label>
                                        <input type="text" class="span1" placeholder="1">
                                        <button class="btn btn-inverse" type="submit">Adicionar ao carrinho</button>
                                    </form>
                                </div>							
                            </div>
                            <div class="row">
                                <div class="span9">
                                    <ul class="nav nav-tabs" id="myTab">
                                        <li class="active"><a href="#home">Descrição</a></li>
                                        <li class=""><a href="#profile">Informações Adicionais</a></li>
                                        <li class=""><a href="#question">Perguntas Frequentes</a></li>
                                    </ul>							 
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="home"><c:out value="${produtosAttr.getDescricao()}"/></div>
                                        <div class="tab-pane" id="profile">
                                            <table class="table table-striped shop_attributes">	
                                                <tbody>
                                                    <tr class="">
                                                        <th>Tamanho</th>
                                                        <td>36, 37, 38, 39, 40, 41, 42, 43, 44</td>
                                                    </tr>		
                                                    <tr class="alt">
                                                        <th>Cor</th>
                                                        <td>Preto, Cinza, Branco</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>

                                        <div class="tab-pane" id="question">

                                            <div class="land-questions">
                                                <h4><strong>Formas de Pagamento</strong></h4>
                                                <p>
                                                    <strong>Boleto Bancário</strong>, ao comprar explicaremos como fazer o 
                                                    pagamento em qualquer agência bancária, caixa eletrônico, internet banking ou 
                                                    correspondentes bancários. Pague e será aprovado de 1 a 2 dias úteis.</p>
                                            </div>
                                            <div class="land-questions">
                                                <h4><strong>Frete</strong></h4>
                                                <p><strong>Não oferecemos frete grátis em nossos produtos</strong>
                                                    Estaremos ao seu lado até você receber o que comprou e nos avisar que 
                                                    está tudo correto. Se tiver algum problema, basta nos avisar.</p>
                                            </div>
                                            <div class="land-questions">
                                                <h4><strong>Garantia</strong></h4>
                                                <strong>Compra Garantida</strong>
                                                <p>Se houver algum problema ou se não receber o produto que comprou, devolveremos o dinheiro. 
                                                    <strong>Você sempre terá a nossa ajuda.</strong>
                                                    Estaremos ao seu lado até você receber o que comprou e nos avisar que está 
                                                    tudo correto. Se tiver algum problema, basta nos avisar.</p>
                                            </div>
                                        </div>
                                    </div>

                                </div>	
                            </c:if>				
                            <div class="span9">	
                                <br>
                                <h4 class="title">
                                    <span class="pull-left"><span class="text"><strong>Produtos</strong> Relacionados</span></span>
                                    <span class="pull-right">
                                        <a class="left button" href="#myCarousel-1" data-slide="prev"></a><a class="right button" href="#myCarousel-1" data-slide="next"></a>
                                    </span>
                                </h4>
                            </div>
                        </div>
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
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. the  Lorem Ipsum has been the industry's standard dummy text ever since the you.</p>
                        <br/>
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
                <span>Copyright 2013 bootstrappage template  All right reserved.</span>
            </section>
        </div>
        <script src="${pageContext.request.contextPath}/themes/js/common.js"></script>
        <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
        <script>
            $(function () {
                $('#myTab a:first').tab('show');
                $('#myTab a').click(function (e) {
                    e.preventDefault();
                    $(this).tab('show');
                })
            })
            $(document).ready(function () {
                $('.thumbnail').fancybox({
                    openEffect: 'none',
                    closeEffect: 'none'
                });

                $('#myCarousel-2').carousel({
                    interval: 2500
                });
            });
        </script>
    </body>
</html>