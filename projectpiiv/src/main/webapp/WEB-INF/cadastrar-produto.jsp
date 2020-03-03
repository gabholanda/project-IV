<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <script type="text/javascript" src="https://code.jquery.com/jquery/jquery-3.1.1.min.js"></script>
        <title>Loja de Artigos Esportivos</title>
    </head>
<body>
   <form action="${pageContext.request.contextPath}/cadastrar-produto" method="post" enctype="multipart/form-data" novalidate>
        

    <label for="inputNome">Nome*:</label>
                    
                        <input type="text" name="nome" id="nome" placeholder="Digite o nome do Produto" required>
                    
                    <br>
                    <br>
                    <label for=inputDesc > Descrição*:</label>
                    <textarea id="descricao" name="descricao"></textarea>
                    <br>
                    <br>
                    <label for="inputTipo">Tipo*:</label>
                    <select id="tipo" name="tipo">
                        <option selected>Tenis</option>
                        <option>Camiseta</option>
                        <option>Bermudas</option>
                        <option>Acessórios</option>
                        <option>Outros</option>
                    </select>
                    <br>
                    <br>
                    <label for="inputPreco" >Preço*:</label>
                    <input type="number" name="preco" id="preco" placeholder="9,99" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                    <br>
                    <br>
                    <label for="inputQtd" >Quantidade*:</label>
                    <input type="number" name="quantidade" id="quantidade" placeholder="9,99" pattern="[0-9]+([,\.][0-9]+)?" min="0" step="any" required>
                    <br>
                    <br>
        <br/>
        <br/>

     <input type="file" name="file" id="file"/> 
        <button type="submit">Enviar </button>
    </form>
    <label>${message}</label>
    <br/>
    <br/>
    <form action="upload" method="get" >
        <input type="submit" value="Visalizar imagem" />
    </form>
</body>
</html>