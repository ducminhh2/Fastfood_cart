<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar Example</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="menu">
    <h5 style="background-color: #f6d655; padding: 10px; margin-bottom: 10px; text-align: center;">Danh sách</h5>
    <ul class="list-unstyled">
        <c:forEach var="ds" items="${lstDSSP}">
            <li><a href="/view/danh-sach-san-pham/${ds.tenDs}" data-id="${ds.dsspId}">${ds.tenDs}</a></li>
        </c:forEach>
    </ul>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>