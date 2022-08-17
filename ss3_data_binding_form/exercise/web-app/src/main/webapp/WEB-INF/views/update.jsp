<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h3>TỜ KHAI Y TẾ</h3>
        <p>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</p>
        <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự</p>
    </div>
    <form:form method="post" modelAttribute="person" action="update?id=${person.id}">
        <div class="mb-3">
            <form:label path="name" class="form-label">Họ Tên (ghi in Chữ Hoa)</form:label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <form:label path="birthDay" class="form-label">Năm Sinh</form:label>
                    <form:select path="birthDay" class="form-select" items="${yearList}"/>
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Giới tính</label>
                    <form:select path="genDer" class="form-select" items="${genderList}"/>
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Quốc tịch</label>
                    <form:select path="nationality" class="form-select" items="${nationalityList}"/>
                </div>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Số hộ chiếu hoặc CMND hoặc giấy tờ thông hành khác</label>
            <form:input path="passportId" class="form-control" placeholder="VD: 124332" />
        </div>
        <div class="mb-3">
            <label class="form-label">Phương tiện đi lại</label>
            <div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="travelInformation" class="form-check-input" label="Tàu bay" value="Tàu bay"/>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="travelHistory" class="form-check-input" label="Tàu thuyền" value="Tàu thuyền"/>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="travelInformation" class="form-check-input" label="ô tô" value="ô tô"/>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="travelHistory" class="form-check-input" label="khác(ghi rõ)" value="khác"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Số hiệu phương tiện</label>
                    <form:input path="vehicleNumber" cssClass="form-control" />
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">số ghế</label>
                    <form:input path="seats" cssClass="form-control" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="mb-1">
                    <label class="form-label">Ngày khởi hành</label>
                    <form:select path="startDay" items="${dayList}" cssClass="form-select" />
                </div>
                <div class="mb-1">
                    <label class="form-label">Tháng khởi hành</label>
                    <form:select path="startMonth" items="${monthList}" cssClass="form-select" />
                </div>
                <div class="mb-1">
                    <label class="form-label">Năm khởi hành</label>
                    <form:select path="startYear" items="${yearList}" cssClass="form-select" />
                </div>
            </div>
            <div class="col">
                <div class="mb-1">
                    <label class="form-label">Ngày kết thúc</label>
                    <form:select path="endDay" items="${dayList}" cssClass="form-select" />
                </div>
                <div class="mb-1">
                    <label class="form-label">Tháng kết thúc</label>
                    <form:select path="endMonth" items="${monthList}" cssClass="form-select" />
                </div>
                <div class="mb-1">
                    <label class="form-label">Năm kết thúc</label>
                    <form:select path="endYear" items="${yearList}"  cssClass="form-select" />
                </div>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào?</label>
            <form:textarea path="travelHistory" class="form-control"></form:textarea>
        </div>

        <div class="text-center p-2">
            <input type="submit" class="btn btn-primary" value="GỬI TỜ KHAI">
        </div>
    </form:form>
</div>
</body>
</html>
