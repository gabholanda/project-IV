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
        <c:if test="${criadoAttr}">
            <div class="alert alert-success">
                Cadastrado com sucesso!
            </div>
        </c:if>

        <form method="post" action="${pageContext.request.contextPath}/enderecos" novalidate>

            <div class="group"> 

                <div class="row">

                    <div class="col-sm-3">
                        <label for="cep">CEP</label>
                        <input type="text" class="form-control" name="cep" id="cep" class="input-xlarge"  required>
                    </div>

                    <div class="col-sm-2">
                        <label for="rua">Rua</label>
                        <input type="text" class="form-control" name="rua" id="numero" required>
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
                    <div class="col-sm-1">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" name="estado" id="estado" required>
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
        <div class="row">						
            <div class="span9">
                <c:if test="${not empty enderecosAttr}">
                    <div class="block">
                        <table class="table table-sm offset-md-2">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">CEP</th>
                                    <th scope="col">NUMERO</th>
                                    <th scope="col">COMPLEMENTO</th>
                                    <th scope="col">BAIRRO</th>
                                    <th scope="col">CIDADE</th>
                                    <th scope="col">ESTADO</th>
                                    <th scope="col">TIPO</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${enderecosAttr}" var="endereco">
                                    <tr>
                                        <th> <c:out value="${endereco.getId()}"/></th>
                                        <td ><c:out value="${endereco.getCep()}"/></td>
                                        <td><c:out value="${endereco.getRua()}"/></td>
                                        <td> <c:out value="${endereco.getNumero()}"/></td>
                                        <td> <c:out value="${endereco.getComplemento()}"/></td>
                                        <td> <c:out value="${endereco.getBairro()}"/></td>
                                        <td> <c:out value="${endereco.getCidade()}"/></td>
                                        <td> <c:out value="${endereco.getEstado()}"/></td>
                                        <td> <c:out value="${endereco.getTipo()}"/></td>
                                        <td><a data-method="get" href="${pageContext.request.contextPath}/enderecos?id=${endereco.getId()}" class="btn btn-primary mb-1" >Enderecos</a></td>
                                    </tr>
                                </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>

        </div>
    </div>

    <script>
        jQuery(function ($) {

            $("#cep").mask('00000-000');
        });
    </script>
<script>
        if (${ErroCep} === false) {
            alert('CEP obrigatório');
        }
    </script>
    <script>
        if (${ErroNome} === false) {
            alert('Nome com menos que 5 letras');
        }
    </script>
    <script>
        if (${ErroNome} === false) {
            alert('Nome com menos que 5 letras');
        }
    </script>

</body>
</html>