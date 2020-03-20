<%-- 
    Document   : land-produto-detalhe
    Created on : Mar 20, 2020, 12:07:23 AM
    Author     : Pablo de Oliveira
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
        <link href="${pageContext.request.contextPath}/themes/css/bootstrappage.css" rel="stylesheet"/>

        <!-- global styles -->
        <link href="${pageContext.request.contextPath}/themes/css/main.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/themes/css/jquery.fancybox.css" rel="stylesheet"/>

        <!-- scripts -->
        <script src="${pageContext.request.contextPath}/themes/js/jquery-1.7.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>				
        <script src="${pageContext.request.contextPath}/themes/js/superfish.js"></script>	
        <script src="${pageContext.request.contextPath}/themes/js/jquery.scrolltotop.js"></script>
        <script src="${pageContext.request.contextPath}/themes/js/jquery.fancybox.js"></script>
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
                            <li><a href="cart.html">Your Cart</a></li>
                            <li><a href="checkout.html">Checkout</a></li>					
                            <li><a href="register.html">Login</a></li>		
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
                                    <li><a href="./products.html">Lacinia nibh</a></li>									
                                    <li><a href="./products.html">Eget molestie</a></li>
                                    <li><a href="./products.html">Varius purus</a></li>									
                                </ul>       
                            </li>															
                            <li><a href="./products.html">Man</a></li>			
                            <li><a href="./products.html">Sport</a>
                                <ul>									
                                    <li><a href="./products.html">Gifts and Tech</a></li>
                                    <li><a href="./products.html">Ties and Hats</a></li>
                                    <li><a href="./products.html">Cold Weather</a></li>
                                </ul>
                            </li>							
                            <li><a href="./products.html">Hangbag</a></li>
                            <li><a href="./products.html">Best Seller</a></li>
                            <li><a href="./products.html">Top Seller</a></li>
                        </ul>
                    </nav>
                </div>
            </section>
            <section class="header_text sub">
                <img class="pageBanner" src="${pageContext.request.contextPath}/themes/images/pageBanner.png" alt="New products" >
                <h4><span>Product Detail</span></h4>
            </section>
            <section class="main-content">				
                <div class="row">						
                    <div class="span9">
                        <div class="row">
						 <c:if test="${not empty produtosAttr}">
                            <div class="span4">
                                <c:forEach items="${produtosAttr.getImagens()}" var="imagem">
                                        <a href="${pageContext.request.contextPath}/img/${imagem}" class="thumbnail" data-fancybox-group="group1" title="Description 1"><img alt="" src="${pageContext.request.contextPath}/img/${imagem}"></a>												
                                    </c:forEach>

                                    <!--<ul class="thumbnails small">								
                                            <li class="span1">
                                                    <a href="${pageContext.request.contextPath}/themes/images/ladies/2.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 2"><img src="themes/images/ladies/2.jpg" alt=""></a>
                                            </li>								
                                            <li class="span1">
                                                    <a href="${pageContext.request.contextPath}/themes/images/ladies/3.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 3"><img src="themes/images/ladies/3.jpg" alt=""></a>
                                            </li>													
                                            <li class="span1">
                                                    <a href="${pageContext.request.contextPath}/themes/images/ladies/4.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 4"><img src="themes/images/ladies/4.jpg" alt=""></a>
                                            </li>
                                            <li class="span1">
                                                    <a href="${pageContext.request.contextPath}/themes/images/ladies/5.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 5"><img src="themes/images/ladies/5.jpg" alt=""></a>
                                            </li>
                                    </ul> -->
                            </div>
                            <div class="span5">
                                <address>
                                    <!--<strong>Brand:</strong> <span>Apple</span><br> -->
                                    <strong>Nome do Produto:</strong> <span><c:out value="${produtosAttr.getNome()}"/></span><br>
                                    <strong>Reward Points:</strong> <span>0</span><br>
                                    <strong>Availability:</strong> <span>Out Of Stock</span><br>								
                                </address>									
                                <h4><strong>Price: <c:out value="${produtosAttr.getPreco()}"/></strong></h4>
                            </div>
                            <div class="span5">
                                <form class="form-inline">
                                    <!--<label class="checkbox">
                                            <input type="checkbox" value=""> Option one is this and that
                                    </label>
                                    <br/>
                                    <label class="checkbox">
                                      <input type="checkbox" value=""> Be sure to include why it's great
                                    </label> -->
                                    <p>&nbsp;</p>
                                    <label>Qty:</label>
                                    <input type="text" class="span1" placeholder="1">
                                    <button class="btn btn-inverse" type="submit">Add to cart</button>
                                </form>
                            </div>							
                        </div>
                        <div class="row">
                            <div class="span9">
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#home">Description</a></li>
                                    <li class=""><a href="#profile">Additional Information</a></li>
                                </ul>							 
                                <div class="tab-content">
                                    <div class="tab-pane active" id="home"><c:out value="${produtosAttr.getDescricao()}"/></div>
                                    <div class="tab-pane" id="profile">
                                        <table class="table table-striped shop_attributes">	
                                            <tbody>
                                                <tr class="">
                                                    <th>Size</th>
                                                    <td>Large, Medium, Small, X-Large</td>
                                                </tr>		
                                                <tr class="alt">
                                                    <th>Colour</th>
                                                    <td>Orange, Yellow</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>							
                            </div>	
                            </c:if>				
                            <div class="span9">	
                                <br>
                                <h4 class="title">
                                    <span class="pull-left"><span class="text"><strong>Related</strong> Products</span></span>
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
                                <li class="nav-header">SUB CATEGORIES</li>
                                <li><a href="products.html">Nullam semper elementum</a></li>
                                <li class="active"><a href="products.html">Phasellus ultricies</a></li>
                                <li><a href="products.html">Donec laoreet dui</a></li>
                                <li><a href="products.html">Nullam semper elementum</a></li>
                                <li><a href="products.html">Phasellus ultricies</a></li>
                                <li><a href="products.html">Donec laoreet dui</a></li>
                            </ul>
                            <br/>
                            <ul class="nav nav-list below">
                                <li class="nav-header">MANUFACTURES</li>
                                <li><a href="products.html">Adidas</a></li>
                                <li><a href="products.html">Nike</a></li>
                                <li><a href="products.html">Dunlop</a></li>
                                <li><a href="products.html">Yamaha</a></li>
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
            </section>			
            <section id="footer-bar">
                <div class="row">
                    <div class="span3">
                        <h4>Navigation</h4>
                        <ul class="nav">
                            <li><a href="./index.html">Homepage</a></li>  
                            <li><a href="./about.html">About Us</a></li>
                            <li><a href="./contact.html">Contac Us</a></li>
                            <li><a href="./cart.html">Your Cart</a></li>
                            <li><a href="./register.html">Login</a></li>							
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
        <script src="themes/js/common.js"></script>
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
