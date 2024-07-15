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
            padding: 20px; /* Điều chỉnh padding nếu cần thiết */
        }

        .card-add-product {
            margin-bottom: 20px;
        }

        .card-add-product .card-body {
            padding: 20px; /* Điều chỉnh padding của card body */
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
        .product-image {
            max-width: 100px;
            max-height: 100px;
            object-fit: cover}
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
                            <h5 class="card-title">Add Product</h5>
                            <form action="/admin/updateSP/${SanPhamDeTail.id}" method="POST" enctype="multipart/form-data">
                                <div class="mb-3">
                                    <label  class="form-label">Product Name</label>
                                    <input type="text" class="form-control form-control-custom" value="${SanPhamDeTail.tenSanPham}" name="tenSanPham" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Category</label>
                                    <select class="form-select form-select-custom" name="danhSachSanPham" required>
                                        <option value="">Select category...</option>
                                        <c:forEach var="category" items="${lstDSSP}">
                                            <option value="${category.dsspId}"
                                                ${category.dsspId == SanPhamDeTail.danhSachSanPham.dsspId ? 'selected="selected"' : ''}>
                                                    ${category.tenDs}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="hinhAnh" class="form-label">Product Image</label>
                                    <input type="file" class="form-control form-control-custom" id="hinhAnh" name="hinhAnh" required>
                                </div>
                                <button type="submit" class="btn btn-success">Update Product</button>
                                <a href="/admin/view-addSP" class="btn btn-primary">Back</a>
                            </form>
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
