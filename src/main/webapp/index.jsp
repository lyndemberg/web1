<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<html>
<head>
    <title>SiSGER - Funcionários</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified JavaScript -->
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <h4>Funcionários</h4>
        <div class="row">
            <div class="col l6">
                <h5>Busca</h5>
                <form method="POST" action="/front?action=BuscarFuncionario">
                    <div class="row">
                        <div class="input-field col l10">
                            <input placeholder="Digite o nome do empregado"
                                   id="busca" name="busca" type="text" class="validate" required>
                            <label for="busca">Nome</label>
                        </div>
                        <div class="col l2">
                            <button class="btn-floating btn-large waves-effect waves-light red" type="submit" name="action">
                                <i class="material-icons">search</i>
                            </button>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <c:choose>
                        <c:when test="${empty funcionariosBusca}">
                            <b>Nenhum funcionário encontrado</b>
                        </c:when>
                        <c:when test="${not empty funcionariosBusca}">
                            <b>Resultado da busca</b>
                            <ul class="collection">
                                <c:forEach items="${funcionariosBusca}" var="funcionario">
                                    <li class="collection-item avatar">
                                        <img src="data:image/jpg;base64,${funcionario.imageBase64()}" alt="" class="circle">
                                        <span class="title"><b>${funcionario.nome}</b></span>
                                        <p>${funcionario.email}<br>
                                                ${funcionario.telefone1} / ${funcionario.telefone2}
                                        </p>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:when>
                    </c:choose>
                </div>
            </div>



            <form method="post" enctype="multipart/form-data"
                  action="/front?action=CadastrarFuncionario" class="col l5 offset-l1">
                <h5>Cadastro</h5>
                <div class="row">
                    <div class="input-field col l6">
                        <input placeholder="Nome" id="nome" name="nome" type="text" class="validate" required>
                        <label for="nome">Nome</label>
                    </div>
                    <div class="input-field col l6">
                        <input placeholder="E-mail" id="email" name="email" type="email" class="validate" required>
                        <label for="email">E-mail</label>
                    </div>
                </div>
                <div class="row">
                    <div class="file-field input-field col l12">
                        <div class="btn">
                            <span>Foto</span>
                            <input name="foto" id="foto" type="file" accept="image/*" required>
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col l6">
                        <input placeholder="Telefone 1" id="telefone1" name="telefone1" type="text" class="validate" required>
                        <label for="telefone1">Telefone 1</label>
                    </div>
                    <div class="input-field col l6">
                        <input placeholder="Telefone 2" id="telefone2" name="telefone2" type="text" class="validate" required>
                        <label for="telefone2">Telefone 2</label>
                    </div>
                </div>
                <div class="row">
                    <m:mostrarDepartamentos/>
                    <label>Departamento</label>
                    <select class="browser-default" name="departamento" id="departamento" required>
                        <option value="" disabled selected>Escolha o Departamento</option>
                        <c:forEach items="${departamentos}" var="departamento">
                            <option value="${departamento.id}">${departamento.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <button class="btn-large waves-effect waves-light" type="submit" name="action">CADASTRAR
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    <jsp:include page="errorToast.jsp"/>
</body>
</html>
