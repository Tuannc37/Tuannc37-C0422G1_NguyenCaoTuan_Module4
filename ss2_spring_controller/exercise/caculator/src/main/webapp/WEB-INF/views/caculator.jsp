<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h1>Simple Calculator</h1>
    <form method="post" action="/calculator">
        <fieldset>
            <legend>Calculator</legend>
            <table>
                <tr>
                    <td>First operand: </td>
                    <td><input name="number1" type="text"/></td>
                </tr>
                <tr>
                    <td>Operator: </td>
                    <td>
                        <select name="operator">
                            <option value="+">Addition</option>
                            <option value="-">Subtraction</option>
                            <option value="*">Multiplication</option>
                            <option value="/">Division</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Second operand: </td>
                    <td><input name="number2" type="text"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Calculate"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <h1>Kết quả là :${number1}${operator}${number2}=${result}</h1>
</body>
</html>
