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

        .col-md-10 {
            max-width: 90%;
            margin-left: auto;
            margin-right: auto;
            padding: 20px;
        }

        .card-add-product {
            margin-bottom: 20px;
        }

        .card-add-product .card-body {
            padding: 20px;
        }

        .card-add-product .card-title {
            font-size: 1.2rem;
            font-weight: bold;
        }

        .form-control-custom {
            padding: 10px;
            font-size: 1rem;
        }

        .form-select-custom {
            padding: 10px;
            font-size: 1rem;
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
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <div class="card card-add-product">
                        <div class="card-body">
                            <h5 class="card-title"> Detai</h5>
                            <form method="POST" enctype="multipart/form-data">
                                <div class="mb-3">
                                    <label class="form-label">Tên sản phẩm</label>
                                    <input type="text" class="form-control form-control-custom" value="${SP.tenSanPham}" readonly>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Giá</label>
                                    <input type="number" class="form-control form-control-custom" value="${SPCTDT.gia}" name="gia" >
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Mô tả</label>
                                    <input type="text" class="form-control form-control-custom" value="${SPCTDT.moTa}" name="moTa">
                                </div>
                                <button formaction="/admin/addchiTietSP/${SP.id}" type="submit" class="btn btn-primary">Add Detail</button>
                                <button formaction="/admin/update-detail/${SPCTDT.spctId}" type="submit" class="btn btn-success">Update Detail</button>
                                <a href="/admin/view-addSP"  class="btn btn-success">Back</a>
                            </form>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Product Information</h5>
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th scope="col">Tên sản phẩm</th>
                                        <th scope="col">Giá</th>
                                        <th scope="col">Mô tả</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lstCT}" var="CTSP">
                                        <tr>
                                            <td>${CTSP.sanPhamId.tenSanPham}</td>
                                            <td>${CTSP.gia}</td>
                                            <td>${CTSP.moTa}</td>
                                            <td>
                                                <a class="btn btn-warning" href="/admin/detailchiTietSP/${CTSP.spctId}">Detail</a>
                                                <a class="btn btn-danger" href="/admin/remove-SPCT/${CTSP.spctId}">Remove</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
