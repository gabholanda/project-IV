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
            <a class="navbar-brand" href="#">Loja Esportiva</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="#">Cadastrar Produto</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Listar Produtos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Sair</a>
                </li>
              </ul>
            </div>
          </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Cadastrar Produto</h1>
        </div>

        <form action="${pageContext.request.contextPath}/cadastrar-produto" method="post" enctype="multipart/form-data" novalidate>         
            <div class="form-group row">
                <label for="inputNome" class="col-sm-1 offset-md-3">Nome*:</label>
                <input type="text" class="form-control col-md-4" name="nome" id="nome" placeholder="Digite o nome do Produto" required>
                <div class="invalid-feedback">
                    Digite um nome
                </div>
            </div>

            <div class="form-group row">
                <label for="inputDesc" class="col-sm-1 offset-md-3">Descrição</label>
                <textarea class="form-control col-sm-4" id="inputDesc" name="descricao" rows="3"></textarea>
            </div>
            
            <div class="form-group row">
                <label for="inputTipo" class="col-sm-1 offset-md-3">Tipo*:</label>

                <select name="tipo" id="tipo" class="form-control col-sm-4">
                    <option selected>Tenis</option>
                    <option>Camiseta</option>
                    <option>Bermudas</option>
                    <option>Acessórios</option>
                    <option>Outros</option>
                </select>
                <div class="invalid-feedback">
                    Selecione um tipo
                </div>
            </div>
            
            <div class="form-group row">
                <label for="inputPreco" class="col-sm-1 offset-md-3">Preço*:</label>
                <input type="number" class="form-control col-sm-4" name="preco" id="inputPreco" placeholder="9,99" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                <div class="invalid-feedback">
                    Digite um Preço
                </div>
            </div>
          
            <div class="form-group row">
                <label for="inputQtd" class="col-sm-1 offset-md-3">Quantidade*:</label>
                <input type="number" class="form-control col-sm-4" name="quantidade" id="inputQtd" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                <div class="invalid-feedback">
                    Digite uma quantidade
                </div>
            </div>
            
            <div class="form-group row">
              <label for="exampleFormControlFile1" class="col-sm-1 offset-md-3">Imagem</label>
              <input type="file" class="form-control-file col-sm-4" id="file" name=""file>
            </div>

            <br>
             <div class="button-group">
                <button class="btn  btn-success" type="submit">Cadastrar</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#" class="btn btn-danger">Cancelar</a>
            </div>
        </form>
        <br>
        <form action="upload" method="get" >
            <input type="submit" value="Visalizar imagem" />
        </form>
    </body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>