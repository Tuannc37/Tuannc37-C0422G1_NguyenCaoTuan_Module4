<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h1>Settings</h1>
    <form:form action="/result" method="post" modelAttribute="email">
        <table>
            <tr>
                <td><form:label path="languages">Languages</form:label></td>
                <td>
                    <form:select path="languages" items="${languages}"/><br/>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page size</form:label></td>
                <td>Show
                    <form:select path="pageSize" items="${pageSize}"/><br/>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="filter">Spam filter</form:label></td>
                <td>
                    <form:checkbox path="filter"/>
                    <form:label path="filter">Enable spams filter</form:label>
                </td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature</form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><input type="reset" value="Cancel"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
