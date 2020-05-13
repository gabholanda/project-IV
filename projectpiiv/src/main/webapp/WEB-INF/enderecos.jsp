<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
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

    <section class="navbar main-menu">
        <div class="navbar-inner main-menu">				
            <a href="${pageContext.request.contextPath}/land" class="logo pull-left logo-size"><i class="fas fa-shopping-cart"></i> Sports TADS</a>

        </div>
    </section>	
    <div class="container mt-5">
        <h3 class="title-default mb-5">Cadastrar Endereços</h3>

        <form method="post" action="${pageContext.request.contextPath}/enderecos" novalidate>
            <h4 class="mb-3">Endereço de Entrega</h4>

            <div class="group"> 

                <div class="row">

                    <div class="col-sm-3">
                        <label for="cep">CEP</label><span class="obrigatorio"></span>
                        <input type="number" class="form-control" name="cep" id="cep" maxlength="8" placeholder="00000-000" required>
                    </div>

                    <div class="col-sm-7">
                        <label for="logradouro">Logradouro</label><span class="obrigatorio"></span>
                        <input type="text" class="form-control" name="logradouro" id="logradouro" required>
                    </div>

                    <div class="col-sm-2">
                        <label for="numero">Número</label><span class="obrigatorio"></span>
                        <input type="number" class="form-control" name="numero" id="numero" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <label for="complemento">Complemento</label>
                        <input type="text" class="form-control" name="complemento" id="complemento">
                    </div>
                    <div class="col-sm-3">
                        <label for="bairro">Bairro</label><span class="obrigatorio"></span>
                        <input type="text" class="form-control" name="bairro" id="bairro" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="cidade">Cidade</label><span class="obrigatorio"></span>
                        <input type="text" class="form-control" name="cidade" id="cidade" required>
                    </div>
                    <div class="col-sm-1">
                        <label for="estado">Estado</label><span class="obrigatorio"></span>
                        <input type="text" class="form-control" name="estado" id="estado" required>
                    </div>
                </div>
                <input type="hidden" class="form-control" name="idCliente" id="idCliente" value="${idCliente}">

                <input type="submit" value="Enviar para esse endereço" class="btn btn-cor-especial col-2 mb-5" />
                <br>
                <div class="mt-5">
                    <button class="btn btn-secondary" type="button" id="copiar" name="copiar" onClick="copyFromTextbox();">Usar endereço para faturamento</button>
                </div>
            </div>

        </form>
    </div>



</body>
</html>