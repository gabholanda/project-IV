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
                            <li><a href="${pageContext.request.contextPath}/editar-cliente">Meu Cadastro</a></li>
                            <li><a href="${pageContext.request.contextPath}/logout-cliente">Logout</a></li>
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
                <h2><span>Forma de Pagamento</span></h2>
            </section>
            <section class="main-content">
                <div class="row">						
                    <div class="span9">
                        <form action="${pageContext.request.contextPath}/forma-pagamento" method="post" class="form-stacked">
                            <div class="block">

                                <input style="width: 20px;  height: 18px;" class="form-check-input" type="radio" name="pagamento" id="boleto" value="boleto" onchange="desabilitarCampos()" required>
                                <label class="form-check-label" for="inlineRadio1" style="margin-top: 15px;"><strong style="font-size: 30px;">Boleto</strong></label>
                                <i style="font-size: 90px" class="fas fa-money-bill-alt"></i>
                            </div>

                            <div class="block" style="border-top: none;">
                                <input style="width: 20px;  height: 18px;" class="form-check-input" type="radio" name="pagamento" id="cartaoCredito" value="cartaoCredito" onchange="liberarCampos()" required>
                                <label class="form-check-label" for="inlineRadio1" style="margin-top: 15px;"><strong style="font-size: 30px;">Cartão de Crédito</strong></label>
                                <br>
                                <i style="font-size: 40px" class="fab fa-cc-visa"></i>
                                <i style="font-size: 40px" class="fab fa-cc-amex"></i>
                                <i style="font-size: 40px" class="fab fa-cc-mastercard"></i>
                                <i style="font-size: 40px" class="fab fa-cc-paypal"></i>
                                <i style="font-size: 40px" class="fab fa-cc-diners-club"></i>
                                <i style="font-size: 40px" class="fab fa-apple-pay"></i>
                                <br><br>
                                <fieldset>
                                    <div class="control-group">
                                        <label class="control-label">Número do Cartão</label>
                                        <div class="controls">
                                            <input disabled="disabled" type="text" placeholder="xxxx xxxx xxxx xxxx" id="numeroCartao" name="numeroCartao" class="input-xlarge" required>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Código de Segurança</label>
                                        <div class="controls">
                                            <input disabled="disabled" type="text" placeholder="xxx" id="codigoSeguranca" name="codigoSeguranca" class="input-xlarge" required>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Data de Vencimento</label>
                                        <div class="controls">
                                            <input disabled="disabled" type="text" placeholder="xx/xx" id="dataVencimento" name="dataVencimento" class="input-xlarge">
                                        </div>
                                    </div>						                            

                                    <hr>
                                    <div class="actions"><input tabindex="9" id="avancarButton" class="btn btn-inverse large" type="submit" value="Avançar" disabled="disabled"></div>
                                </fieldset>
                            </div>


                        </form>	
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
        <script>
            function liberarCampos() {
                document.getElementById('numeroCartao').disabled = false
                document.getElementById('codigoSeguranca').disabled = false
                document.getElementById('dataVencimento').disabled = false
                document.getElementById('dataVencimento').disabled = false
                document.getElementById('avancarButton').disabled = false
            }

            function desabilitarCampos() {
                document.getElementById('numeroCartao').disabled = true
                document.getElementById('codigoSeguranca').disabled = true
                document.getElementById('dataVencimento').disabled = true
                document.getElementById('avancarButton').disabled = false
            }

            jQuery(function ($) {
                $("#numeroCartao").mask('0000 0000 0000 0000');
                $("#codigoSeguranca").mask('000');
                $("#dataVencimento").mask('00/00');
            });
        </script>
        <script src="${pageContext.request.contextPath}/themes/js/common.js"></script>
        <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    </body>
</html>
