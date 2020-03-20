<%-- 
    Document   : land
    Created on : Mar 15, 2020, 9:13:03 PM
    Author     : Pablo de Oliveira
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap E-commerce Templates</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
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
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>				
		<script src="${pageContext.request.contextPath}/themes/js/superfish.js"></script>	
		<script src="${pageContext.request.contextPath}/themes/js/jquery.scrolltotop.js"></script>
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
						<input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt">
					</form>
				</div>
				<div class="span8">
					<div class="account pull-right">
						<ul class="user-menu">				
							<li><a href="#">My Account</a></li>
							<li><a href="#">Your Cart</a></li>
							<li><a href="#">Checkout</a></li>					
							<li><a href="#">Login</a></li>			
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.html" class="logo pull-left"><img src="${pageContext.request.contextPath}/themes/images/logo.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a href="./products.html">Woman</a>					
								<ul>
									<li><a href="#">Lacinia nibh</a></li>									
									<li><a href="#">Eget molestie</a></li>
									<li><a href="#">Varius purus</a></li>									
								</ul>
							</li>															
							<li><a href="#">Man</a></li>			
							<li><a href="#">Sport</a>
								<ul>									
									<li><a href="#">Gifts and Tech</a></li>
									<li><a href="#">Ties and Hats</a></li>
									<li><a href="#">Cold Weather</a></li>
								</ul>
							</li>							
							<li><a href="#">Hangbag</a></li>
							<li><a href="#">Best Seller</a></li>
							<li><a href="#">Top Seller</a></li>
						</ul>
					</nav>
				</div>
			</section>	
			<section class="header_text sub">
			<img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/pageBanner.png" alt="New products" >
				<h4><span>New products</span></h4>
			</section>
			<section class="main-content">
				
				<div class="row">						
					<div class="span9">								<a data-method="get" href="${pageContext.request.contextPath}/land/detalhe-produto?id=${produto.getId()}">
						<ul class="thumbnails listing-products">
                            <c:if test="${not empty produtosAttr}">
                                <c:forEach items="${produtosAttr}" var="produto">
                                    <a data-method="get" href="${pageContext.request.contextPath}/land/detalhe-produto?id=${produto.getId()}"> 
                                        <li class="span3">
                                            <div class="product-box">
                                            <span class="sale_tag"></span>											
                                                <a data-method="get" href="${pageContext.request.contextPath}/land/detalhe-produto?id=${produto.getId()}">
                                                    <c:forEach items="${produto.getImagens()}" var="imagem">
                                                        <img src="${pageContext.request.contextPath}/img/${imagem}" style="width: 250px; height: 250px;">
                                                    </c:forEach>
                                                </a>
                                                <br/> 
                                                <a href="product_detail.html" class="title"><c:out value="${produto.getNome()}"/></a><br/>
                                                <a href="#" class="category">Phasellus consequat</a>
                                                <p class="price"><c:out value="${produto.getPreco()}"/></p>
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
								<li class="nav-header">SUB CATEGORIES</li>
								<li><a href="#">Nullam semper elementum</a></li>
								<li class="active"><a href="products.html">Phasellus ultricies</a></li>
								<li><a href="#">Donec laoreet dui</a></li>
								<li><a href="#">Nullam semper elementum</a></li>
								<li><a href="#">Phasellus ultricies</a></li>
								<li><a href="#">Donec laoreet dui</a></li>
							</ul>
							<br/>
							<ul class="nav nav-list below">
								<li class="nav-header">MANUFACTURES</li>
								<li><a href="#">Adidas</a></li>
								<li><a href="#">Nike</a></li>
								<li><a href="#">Dunlop</a></li>
								<li><a href="#">Yamaha</a></li>
							</ul>
						</div>
						<div class="block">
							<h4 class="title">
								<span class="pull-left"><span class="text">Randomize</span></span>
								<span class="pull-right">
									<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
								</span>
							</h4>
							<div id="myCarousel" class="carousel slide">
								<div class="carousel-inner">
									<div class="active item">
										
									</div>
								</div>
							</div>
						</div>
						<div class="block">								
							<h4 class="title"><strong>Best</strong> Seller</h4>								
							<ul class="small-product">
								
							</ul>
						</div>
					</div>
				</div>
			</section>
			<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="#">Homepage</a></li>  
							<li><a href="#">About Us</a></li>
							<li><a href="#">Contac Us</a></li>
							<li><a href="#">Your Cart</a></li>
							<li><a href="#">Login</a></li>							
						</ul>					
					</div>
					<div class="span4">
						<h4>My Account</h4>
						<ul class="nav">
							<li><a href="#">My Account</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="#">Wish List</a></li>
							<li><a href="#">Newsletter</a></li>
						</ul>
					</div>
					<div class="span5">
						<p class="logo"><img src="${pageContext.request.contextPath}/themes/images/logo.png" class="site_logo" alt=""></p>
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
    </body>
</html>