<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="m" uri="/WEB-INF/myTags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>SiSGER - Error</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <div class="row">
            <c:choose>
                <c:when test="${pageContext.response.status == 404}">
                    <h5>Error 404! <br>
                        Página não encontrada!
                    </h5>
                </c:when>
                <c:when test="${pageContext.response.status == 500}">
                    <h5>Aconteceu um problema, volte para a página anterior</h5>
                </c:when>
            </c:choose>

        </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
</body>
</html>
