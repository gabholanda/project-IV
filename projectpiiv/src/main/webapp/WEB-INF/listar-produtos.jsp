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
                  <a class="nav-link" href="#">Sair</a>
                </li>
              </ul>
            </div>
          </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Produtos</h1>
        </div>
        <c:if test="${excluidoAttr}">
          <div class="alert alert-success">
              Produto excluído com sucesso!
          </div>
        </c:if>
        
        <c:if test="${not empty produtosAttr}">
            <table class="table table-sm offset-md-2" style="width: 75%;">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Preco</th>
                        <th scope="col">Quantidade</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach items="${produtosAttr}" var="produto">
                    <tr>
                        <th> <c:out value="${produto.getId()}"/></th>
                        <td ><c:out value="${produto.getNome()}"/></td>
                        <td><c:out value="${produto.getPreco()}"/></td>
                        <td> <c:out value="${produto.getQuantidade()}"/></td>
                        <td><a data-method="get" href="${pageContext.request.contextPath}/admin/editar-produto?id=${produto.getId()}" class="btn btn-primary mb-1" >Editar</a></td>
                        <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#p${produto.getId()}">Excluir</button></td> 
                     </tr>  
                </tbody>
                <div class="modal fade" id="p${produto.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-body">
                          Tem certeza que deseja excluir o produto <c:out value="${produto.getNome()}"/>
                      </div>
                      <div class="modal-footer">
                        <form action="${pageContext.request.contextPath}/admin/excluir-produto" method="post">
                            <button class="btn btn-success" type="submit" name="id" id="confirmDeleteButton" value="${produto.getId()}">Confirmar</button>
                        </form>
                        
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                      </div>
                    </div>
                  </div>
                </div> 
               </c:forEach>
            </table>
        </c:if>

    </body>

<script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>
