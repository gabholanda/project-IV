<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.scss" media="screen" />
        <title>Loja de Artigos Esportivos</title>
    </head>
    <header>
        <nav class="navbar navbar-light nav-color">
            <a class="navbar-brand" href="#">Loja Esportiva</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Cadastrar Produto</h1>
        </div>

        <form action="${pageContext.request.contextPath}/cadastrar-produto" method="post" enctype="multipart/form-data" novalidate>         
            <div class="form-group">
                <label for="inputNome">Nome*:</label>
                <input type="text" class="form-control col-sm-2" name="nome" id="nome" placeholder="Digite o nome do Produto" required>
                <div class="invalid-feedback">
                    Digite um nome
                </div>
            </div>

            <div class="form-group">
                <label for="inputDesc">Example textarea</label>
                <textarea class="form-control col-sm-2" id="inputDesc" name="descricao" rows="3"></textarea>
            </div>
            
            <div class="form-group">
                <label for="inputTipo">Tipo*:</label>

                <select name="tipo" id="tipo" class="form-control col-sm-2">
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
            
            <div class="form-group">
                <label for="inputPreco">Preço*:</label>
                <input type="number" class="form-control col-sm-2" name="preco" id="inputPreco" placeholder="9,99" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                <div class="invalid-feedback">
                    Digite um Preço
                </div>
            </div>
          
            <div class="form-group">
                <label for="inputQtd">Quantidade*:</label>
                <input type="number" class="form-control col-sm-2" name="quantidade" id="inputQtd" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                <div class="invalid-feedback">
                    Digite uma quantidade
                </div>
            </div>
            
            <div class="form-group">
              <label for="exampleFormControlFile1">Imagem</label>
              <input type="file" class="form-control-file col-sm-2" id="file" name=""file>
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