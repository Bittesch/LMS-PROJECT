<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.user != null}">
  <h1>Welcome, ${sessionScope.user.username}!</h1>
  <p>Email: ${sessionScope.user.email}</p>
</c:if>