<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Users:</h1>
<ul>
  <c:forEach items="${users}" var="user">
    <li>${user.username} (${user.email})</li>
  </c:forEach>
</ul>