<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <h3>TỜ KHAI Y TẾ</h3>
    <a href="/person/showCreate" class="btn btn-primary mb-3">Create</a>
    <h4 style="color: darkgreen">${msg}</h4>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>yearOfBirth</th>
            <th>gender</th>
            <th>nationality</th>
            <th>idCard</th>
            <th>travelInformation</th>
            <th>vehicleNumber</th>
            <th>seats</th>
            <th>startDay</th>
            <th>endDay</th>
            <th>travelHistory</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${personList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.birthDay}</td>
                <td>${item.genDer}</td>
                <td>${item.nationality}</td>
                <td>${item.passportId}</td>
                <td>${item.travelInformation}</td>
                <td>${item.vehicleNumber}</td>
                <td>${item.seats}</td>
                <td>${item.startDay}/${item.startMonth}/${item.startYear}</td>
                <td>${item.endDay}/${item.endMonth}/${item.endYear}</td>
                <td>${item.travelHistory}</td>
                <td><a href="/person/showUpdate?id=${item.id}" class="btn btn-primary">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
