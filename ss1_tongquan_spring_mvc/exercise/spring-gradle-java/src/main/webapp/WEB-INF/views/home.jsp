<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/convert">
        <div>
            <label>Nhập USD</label>
            <input type="number" name="usd" value="${usd}">
            <button type="submit" class="btn btn-success" style="alignment: center">Đổi VND</button>
        </div>
    </form>
    <div>
        <label>VND</label>
        <input type="number" name="vnd" value="${result}">
    </div>
</body>
</html>
