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


        <form method="post" action="${pageContext.request.contextPath}/enderecos" novalidate>

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
                        <input type="text" class="form-control" name="complemento" id="complemento" required>
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