<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .banner {
            background-color: #f8f9fa;
            padding: 0px;
            text-align: center;
            margin-left: -15px;
            margin-right: -15px;
        }

        .menu {
            background-color: #e9ecef;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .menu h3 {
            text-align: center;
            margin-bottom: 10px;
        }

        .menu ul {
            padding-left: 0;
            list-style-type: none;
        }

        .menu li {
            margin-bottom: 5px;
        }

        .menu a {
            display: block;
            padding: 10px 15px;
            text-decoration: none;
            color: #333;
            transition: background-color 0.3s ease;
        }

        .menu a:hover {
            background-color: #ddd;
            color: #000;
        }

        .table-container {
            margin-top: 30px;
        }

        .form-container {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .table-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<%@ include file="../fragment/navba.jsp" %>

<div class="container-fluid">
    <%@ include file="../fragment/banner.jsp" %>
    <div class="row mt-3">
        <div class="col-md-2">
            <%@ include file="../fragment/menu.jsp" %>
        </div>
        <div class="col-md-10">
            <div class="row">
                <div class="col-md-8 mx-auto form-container">
                    <h2>Thêm Danh Sách Sản Phẩm</h2>
                    <form  method="post">
                        <div class="mb-3">
                            <label class="form-label">Tên Danh Sách</label>
                            <input type="text" class="form-control" name="tenDs" value="${DSSPDT.tenDs}" required>
                        </div>
                        <button formaction="/admin/addDSSP" type="submit" class="btn btn-success">Thêm</button>
                        <button formaction="/admin/updateDSSP/${DSSPDT.dsspId}" type="submit" class="btn btn-primary">Sửa</button>
                    </form>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-md-8 mx-auto table-container">
                    <h2>Danh Sách Sản Phẩm</h2>
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên Danh Sách</th>
                            <th>action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="danhSachSanPham" items="${lstDSSP}">
                            <tr>
                                <td>${danhSachSanPham.dsspId}</td>
                                <td>${danhSachSanPham.tenDs}</td>
                                <td><a href="/admin/detailDSSP/${danhSachSanPham.dsspId}" class="btn btn-warning">Detail</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
