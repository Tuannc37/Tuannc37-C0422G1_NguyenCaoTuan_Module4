
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th><label for="Amount">Amount</label></th>
        <th>From Currency</th>
        <th>To Currency</th>
        <th></th>
    </tr>
    <tr>
        <td><input type="text" id="Amount"></td>
        <td>
            <select id="From">
                <option value="VND">VND</option>
                <option value="USD">USD</option>
            </select>
        </td>
        <td>
            <select id="To">
                <option value="VND">VND</option>
                <option  value="USD">USD</option>
            </select>
        </td>
        <td><button  style="background-color: blueviolet; color: white;">Convert</button></td>
    </tr>
</table>
</body>
</html>
