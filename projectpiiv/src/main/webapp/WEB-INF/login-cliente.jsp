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
                            <li><a href="${pageContext.request.contextPath}/meus-pedidos">Meus Pedidos</a></li>					
                            <li><a href="${pageContext.request.contextPath}/login-cliente">Login</a></li>		
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
            <center>
                <section>	

                    <div class="row">
                        <div class="d-flex justify-content-center">					
                            <h4 class="title"><span class="text"><strong>Login</strong></span></h4>
                            <form action="${pageContext.request.contextPath}/login-cliente" method="post">
                                <input type="hidden" name="next" value="/">
                                <div>
                                    <div class="control-group">
                                        <label class="control-label">Usuário</label>
                                        <div class="controls">
                                            <input type="text" placeholder="Entre com seu Usuário" id="usuario" name="usuario" class="input-xlarge">
                                        </div>
                                    </div>
                                    <div class="control-group">

                                        <label class="control-label">Senha</label>
                                        <div class="controls">

                                            <input type="password" placeholder="Senha" id="senha" name="senha" class="input-xlarge">
                                            <c:if test="${msgErro != null}">
                                                <div class="alert alert-danger" style="width: 237px;">
                                                    <c:out value="${msgErro}" />
                                                </div>
                                            </c:if>
                                            <c:if test="${fazerLoginAttr != null}">
                                                <div class="alert alert-danger" style="width: 237px;">
                                                    <c:out value="${fazerLoginAttr}" />
                                                </div>
                                            </c:if>
                                            <c:if test="${sessionScope.msg != null}">
                                                <div class="alert alert-success" style="width: 237px;">
                                                    <c:out value="${sessionScope.msg}" />
                                                </div>
                                                <c:remove scope="session" var="msg" />
                                            </c:if>

                                            
                                            <c:if test="${msgErro != null}">
                                                <div class="alert alert-danger">
                                                    <c:out value="${msgErro}" />
                                                </div>
                                            </c:if>
                                            
                                            <c:if test="${criadoAttr}">
                                                <div class="alert alert-success">
                                                    Cadastrado com sucesso!
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="control-group">

                                        <input tabindex="3" class="btn btn-inverse large" type="submit" value="Entrar">
                                        <br>
                                        <br>
                                        <a href="${pageContext.request.contextPath}/cadastrar-cliente">Ainda não possuo um cadastro</a>
                                        <hr>
                                        <!-- <p class="reset">Recover your <a tabindex="4" href="#" title="Recover your username or password">username or password</a></p> -->
                                    </div>
                                </div>
                            </form>				
                        </div>

                    </div>

                </section>
            </center>
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