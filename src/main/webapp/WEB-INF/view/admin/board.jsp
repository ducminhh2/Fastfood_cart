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

        .product {
            background-color: #f8f9fa;
            padding: 10px;
            margin-bottom: 20px;
            text-align: center;
        }

        .card {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 100%;
        }

        .card-body {
            flex-grow: 1;
        }

        .card-img-top {
            height: 200px;
            object-fit: cover;
        }

        .product-image {
            height: 200px;
            object-fit: cover;
            width: 100%;
        }

        footer {
            background-color: #f6d655;
            padding: 20px 0;
            text-align: center;
            position: relative;
            bottom: 0;
            width: 100%;
            border-top: 1px solid #ccc;
        }

        footer .container p {
            margin: 0;
            color: #333;
        }

        footer .container .social-icons a {
            margin: 0 10px;
            color: #333;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        footer .container .social-icons a:hover {
            color: #000;
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
                <c:forEach var="product" items="${lstAllSPCT}">
                    <div class="col-lg-4 col-md-6 mb-3">
                        <div class="card mb-4">
                            <img src='data:image/jpeg;base64,${product.sanPhamId.encodedImage}' alt="my image" class="product-image" />
                            <div class="card-body">
                                <h5 class="card-title">${product.sanPhamId.tenSanPham}</h5>
                                <p class="card-text">${product.moTa}</p>
                            </div>
                            <div class="card-footer text-muted">
                                    ${product.gia} VNĐ
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <c:forEach var="pageNumber" items="${pageNumbers}">
                        <li class="page-item ${pageNumber == page ? 'active' : ''}">
                            <a class="page-link" href="?page=${pageNumber}&size=6">${pageNumber}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <p>&copy; 2024 FastFoot Online. All rights reserved.</p>
        <div class="social-icons">
            <a href="#">Facebook</a>
            <a href="#">Twitter</a>
            <a href="#">Instagram</a>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
