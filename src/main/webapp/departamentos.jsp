<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>SiSGER - Departamentos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <h4>Departamentos</h4>
        <div class="row">
            <form method="POST" action="/front?action=CriarDepartamento">
                <div class="input-field col l6 offset-l3">
                    <input placeholder="Digite o nome do Departamento"
                           id="nomeDepartamento" name="nomeDepartamento" type="text" class="validate" required>
                    <label for="nomeDepartamento">Departamento</label>
                </div>
                <button class="btn-floating btn-large waves-effect waves-light red" type="submit" name="action">
                    <i class="material-icons">add</i>
                </button>
            </form>
        </div>
        <div class="row">
            <m:mostrarDepartamentos/>
            <div class="col l6 offset-l3">
                <c:if test="${empty departamentos}">
                    <b>Não existem departamentos criados!</b>
                </c:if>
                <c:if test="${not empty departamentos}">
                    <b>Departamentos existentes</b>
                    <ul class="collection">
                        <c:forEach items="${departamentos}" var="departamento">
                            <li class="collection-item">
                                <div>${departamento.nome}
                                    <form action="/front?action=ExcluirDepartamento" method="post" class="secondary-content">
                                        <input type="hidden" name="idDepartamento" value="${departamento.id}"/>
                                        <button class="btn-floating btn-small waves-effect waves-light red" type="submit" name="action">
                                            <i class="material-icons">delete</i>
                                        </button>
                                    </form>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>

            </div>
        </div>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>

    <jsp:include page="errorToast.jsp"/>
</body>
</html>
