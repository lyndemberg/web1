<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SiSGER - Projetos</title>
    <!-- Compiled and minified CSS -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <h4>Projetos</h4>
        <div class="row">
            <form method="POST" action="/front?action=CriarProjeto" class="col l4">
                <div class="row">
                    <div class="input-field">
                        <input placeholder="Digite o nome do projeto"
                               id="nome" name="nome" type="text" class="validate" required>
                        <label for="nome">Nome do projeto</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field">
                        <i class="material-icons prefix">mode_edit</i>
                        <textarea id="descricao" name="descricao" class="materialize-textarea"></textarea>
                        <label for="descricao">Descrição</label>
                    </div>
                </div>
                <div class="row">
                    <button class="btn-large waves-effect waves-light" type="submit" name="action">CRIAR
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form>

            <m:mostrarProjetos/>
            <div class="col l7 offset-l1">
                <h5>Todos os projetos</h5>
                <c:choose>
                    <c:when test="${empty projetos}">
                        <b>Nenhum projeto criado</b>
                    </c:when>
                    <c:when test="${not empty projetos}">
                        <ul class="collapsible popout">
                        <c:forEach items="${projetos}" var="projeto">
                            <li>
                                <div class="collapsible-header">
                                    <i class="material-icons">assignment </i>
                                     <b>Nome: </b> ${projeto.nome}
                                </div>
                                <div class="collapsible-body">
                                    <span>
                                        <b>Código: </b> ${projeto.codigo}<br>
                                        <b>Descrição: </b>${projeto.descricao}<br>
                                        <b>Status: </b>
                                        <c:if test="${projeto.concluido == true}">
                                            CONCLUÍDO
                                        </c:if>
                                        <c:if test="${projeto.concluido == false}">
                                            EM ANDAMENTO
                                        </c:if><br>
                                    </span>

                                    <%--SÓ APARECE O BOTÃO PRA FINALIZAR E A OPÇÃO DE ALOCAÇÃO SE O PROJETO NÃO TIVER CONCLUÍDO--%>
                                    <c:if test="${projeto.concluido == false}">
                                        <form action="/front?action=FinalizarProjeto" method="post">
                                            <input type="hidden" name="codigo" id="codigo" value="${projeto.codigo}"/>
                                            <button class="btn waves-effect waves-light" type="submit" name="action">
                                                Finalizar
                                            </button>
                                        </form>

                                        <form action="/front?action=AlocarFuncionario" method="post">
                                            <h5>Alocar Funcionário</h5>
                                            <span>Digite a matrícula abaixo e adicione o funcionário a esse projeto</span>
                                            <div class="row">
                                                <div class="input-field col l10">
                                                    <input placeholder="Matrícula aqui" id="matricula" name="matricula"
                                                           type="number" class="validate" required>
                                                    <label class="active" for="matricula">Matrícula</label>
                                                </div>
                                                <input type="hidden" name="projeto" id="projeto" value="${projeto.codigo}"/>
                                                <div class="input-field col l2">
                                                    <button class="btn-floating btn-small waves-effect waves-light red" type="submit" name="action">
                                                        <i class="material-icons">add</i>
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </c:if>

                                    <b>Funcionários Alocados: </b><br>
                                    <m:mostrarFuncionariosProjeto projeto="${projeto.codigo}"/>
                                    <c:if test="${not empty funcionariosAlocados}">
                                        <c:forEach items="${funcionariosAlocados}" var="funcionario">
                                            <hr>
                                            Matrícula: ${funcionario.matricula} <br>
                                            Nome: ${funcionario.nome}
                                        </c:forEach>
                                    </c:if>


                                </div>
                            </li>
                        </c:forEach>
                        </ul>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.collapsible').collapsible();
        });
    </script>

    <jsp:include page="errorToast.jsp"/>


</body>
</html>
