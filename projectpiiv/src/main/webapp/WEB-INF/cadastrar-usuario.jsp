<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
        <title>Loja de Artigos Esportivos</title>
    </head>

    <header>
        <nav class="navbar navbar-expand-lg navbar-light nav-color">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin">Loja Esportiva</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/admin/cadastrar-produto">Cadastrar Produto</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/admin/listar-produtos">Listar Produtos</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/admin/cadastrar-usuario">Cadastrar Usuario</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/admin/listar-usuarios">Listar Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sair</a>
                </li>
              </ul>
            </div>
        </nav>
    </header>
    <div>
        <span> Todos os campos são obrigatórios</span> <span style="color: red ">*</span>
    </div>
    <body>
        <div class="page-title">
            <h1>Cadastrar Usuario</h1>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/admin/cadastrar-usuario" novalidate>         
            <div class="form-group row">
                <label for="inputNome" class="col-sm-1 offset-md-3">Nome*:</label>
                <input type="text" class="form-control col-md-4" name="nome" id="nome" placeholder="Digite o nome do Usuario" required>
                <div class="invalid-feedback">
                    Digite o nome do usuario:
                </div>
            </div>

            <div class="form-group row">
                <label for="inputNome" class="col-sm-1 offset-md-3">Email*:</label>
                <input type="text" class="form-control col-md-4" name="email" id="email" placeholder="Digite o email para o Usuario" pattern=".+@dominio.com" required>
                <div class="invalid-feedback">
                    Digite o email do usuario:
                </div>
            </div>

            <div class="form-group row">
                <label for="inputNome" class="col-sm-1 offset-md-3">Senha*:</label>
                <input type="password" class="form-control col-md-4" name="senha" id="senha" placeholder="Digite a senha do Usuario" required>
                <div class="invalid-feedback">
                    Digite a senha do usuario:
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-1 offset-md-3">Tipo*:</label>
                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="tipo" id="admin" value="admin" required>
                    <label class="form-check-label" for="inlineRadio1">Admin</label>&nbsp;&nbsp;
                    <input class="form-check-input" type="radio" name="tipo" id="estoquista" value="estoquista" required>
                    <label class="form-check-label" for="inlineRadio1">Estoquista</label>                   
                </div>
            </div>
                <br>
                <div class="button-group">
                    <button class="btn  btn-success offset-md-5" type="submit">Cadastrar</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="#" class="btn btn-danger">Cancelar</a>
                </div>
                
        </form>
        <br>
        <!-- <form action="upload" method="get" >
            <input type="submit" value="Visalizar imagem" />
        </form> -->
    </body>


    <script>
        if (${ErroNome} === false) {
            alert('Nome com menos que 5 letras');
        }
    </script>

    <script>
       
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>
