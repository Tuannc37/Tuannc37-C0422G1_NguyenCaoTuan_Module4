<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h4>Sandwich Condiments:</h4>
  <form action="/save" method="post">
      <c:forEach var="eat" items="${menu}">
          <span><input type="checkbox" value="${eat}" name="stringList">${eat}</span>
      </c:forEach>
      <button type = "submit">Choose</button>
  </form>
  <h4>${list}</h4>
</body>
</html>
