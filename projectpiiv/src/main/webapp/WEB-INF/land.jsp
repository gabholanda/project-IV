<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Sports TADS </title>
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

        <!-- scripts -->
        <script src="${pageContext.request.contextPath}/themes/js/jquery-1.7.2.min.js"></script>				
        <script src="${pageContext.request.contextPath}/themes/js/superfish.js"></script>	
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
                            <li><a href="${pageContext.request.contextPath}/carrinho">Carrinho</a></li>
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
                <h3><span>Novos Produtos</span></h3>
                <c:if test="${sessionScope.msg != null}">
                    <div class="alert alert-success">
                        <c:out value="${sessionScope.msg}" />
                    </div>
                    <c:remove scope="session" var="msg" />
                </c:if>

                <c:if test="${alteradoAttr}">
                    <div class="alert alert-success">
                        Cadastro alterado com sucesso!
                    </div>
                </c:if>
            </section>
            <section class="main-content">
                <div class="row">						
                    <div class="span9">
                        <ul class="thumbnails listing-products">
                            <c:if test="${not empty produtosAttr}">
                                <c:forEach items="${produtosAttr}" var="produto">

                                    <li class="span3">
                                        <div class="product-box">
                                            <span class="sale_tag"></span>											
                                            <a data-method="get" href="${pageContext.request.contextPath}/land/detalhe-produto?id=${produto.getId()}">
                                                <div id="myCarousel${produto.getId()}" class="carousel slide">
                                                    <div class="carousel-inner">
                                                        <div class="active item">
                                                            <img src="${pageContext.request.contextPath}/img/${produto.getImagens()[0]}" style="width: 250px; height: 250px;">
                                                        </div>
                                                        <c:forEach items="${produto.getImagens()}" var="imagem" begin="1">
                                                            <div class="item">
                                                                <img src="${pageContext.request.contextPath}/img/${imagem}" style="width: 250px; height: 250px;">
                                                            </div>
                                                        </c:forEach>
                                                    </div>
                                                    <a class="carousel-control left" href="#myCarousel${produto.getId()}" data-slide="prev">&lsaquo;</a>
                                                    <a class="carousel-control right" href="#myCarousel${produto.getId()}" data-slide="next">&rsaquo;</a>
                                                </div>

                                                <br/> 
                                                <a data-method="get" href="${pageContext.request.contextPath}/land/detalhe-produto?id=${produto.getId()}"> 
                                                    <p class="product-name"><c:out value="${produto.getNome()}"/></p><br/>
                                                    <a href="#" class="category"><c:out value="${produto.getTipo()}"/></a>
                                                    <p class="price"><strong>R$ <c:out value="${produto.getPreco()}"/></strong></p>
                                                </a>
                                        </div>
                                    </li>  
                                    </a> 
                                </c:forEach>  
                            </c:if>
                        </ul>					
                        <hr>
                        <div class="pagination pagination-small pagination-centered">
                            <ul>
                                <li><a href="#">Prev</a></li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">Next</a></li>
                            </ul>
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
    </body>
</html>