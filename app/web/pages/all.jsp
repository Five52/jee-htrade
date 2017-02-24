<%@ page pageEncoding="UTF-8" %>

<jsp:include page="../fragments/header.jsp" />

    <h1>Toutes les habitations</h1>

    <c:choose>
        <c:when test="${empty sessionScope.habitation}">
            <p>
                Aucune habitation n'est encore disponible.
            </p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="habitation" items="${sessionScore.habitations}">
                    <li>${habitation}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
<jsp:include page="../fragments/footer.jsp" />
