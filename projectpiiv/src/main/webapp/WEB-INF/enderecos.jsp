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

                            <h4 class="title"><span class="text"><strong>Cadastrar Novo Endereço</strong></span></h4>
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

                            <form method="post" action="${pageContext.request.contextPath}/enderecos">
                                <div class="group"> 
                                    <div class="row">
                                        <div class="col-sm-2">
                                            <label for="cep">CEP</label>

                                            <input type="text" class="form-control" name="cep" id="cep" class="input-xlarge"  required>
                                        </div>

                                        <div class="col-sm-2">
                                            <label for="rua">Rua</label>
                                            <input type="text" class="form-control" name="rua" id="rua" required>
                                        </div>

                                        <div class="col-sm-2">
                                            <label for="numero">Número</label>
                                            <input type="number" class="form-control" name="numero" id="numero" required>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <label for="complemento">Complemento</label>
                                            <input type="text" class="form-control" name="complemento" id="complemento">
                                        </div>
                                        <div class="col-sm-3">
                                            <label for="bairro">Bairro</label>
                                            <input type="text" class="form-control" name="bairro" id="bairro" required>
                                        </div>
                                        <div class="col-sm-3">
                                            <label for="cidade">Cidade</label>
                                            <input type="text" class="form-control" name="cidade" id="cidade" required>
                                        </div>

                                        <div class="col-sm-3">
                                            <label for="estado" class="col-sm-1 offset-md-3">Estado</label>
                                            <select name="estado" id="estado" class="form-control col-sm-4">
                                                <option >Acre</option>
                                                <option >Alagoas</option>
                                                <option >Amapá</option>
                                                <option >Amazonas</option>
                                                <option >Bahia</option>
                                                <option >Ceará</option>
                                                <option >Distrito Federal</option>
                                                <option >Espirito Santo</option>
                                                <option >Goiás</option>
                                                <option >Maranhão</option>
                                                <option >Mato Grosso do Sul</option>
                                                <option >Mato Grosso</option>
                                                <option >Minas Gerais</option>
                                                <option >Pará</option>
                                                <option >Paraíba</option>
                                                <option >Paraná</option>
                                                <option >Pernambuco</option>
                                                <option >Piauí</option>
                                                <option >Rio de Janeiro</option>
                                                <option >Rio Grande do Norte</option>
                                                <option >Rio Grande do Sul</option>
                                                <option >Rondônia</option>
                                                <option >Roraima</option>
                                                <option >Santa Catarina</option>
                                                <option >São Paulo</option>
                                                <option >Sergipe</option>
                                                <option >Tocantins</option>

                                            </select>
                                        </div>
                                        <div class="col-sm-3">
                                            <label for="tipo" class="col-sm-1 offset-md-3">Tipo:</label>

                                            <select name="tipo" id="tipo" class="form-control col-sm-4">
                                                <option selected>Endereço Entrega</option>
                                                <option>Endereço Fatura</option>
                                                <option>Ambos Endereços</option>

                                            </select>

                                        </div>

                                    </div>
                                    <input type="hidden" class="form-control" name="idCliente" id="idCliente" value="${idCliente}">

                                    <input type="submit" value="Cadastrar Endereço" class="btn btn-cor-especial col-2 mb-5" />
                                    <br>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script>
        jQuery(function ($) {
            $("#cep").mask('00000-000');
        });
    </script>	

    <script>
        jQuery(function ($) {
            $("#rua").mask('SSSS'): {pattern: /[a-zA-Z]/;
        });
    </script>
    <script>
        jQuery(function ($) {
            $("#numero").mask('000000');
        });
    </script>		
    </body>
</html>