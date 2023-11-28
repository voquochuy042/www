<%@ page import="backend.services.ProductService" %>
<%@ page import="backend.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Page</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h1 class="text-center">List products</h1>
<div class="container">
    <table class="table container table-bordered table-responsive">
        <thead class="text-center">
        <tr>
            <th>Tên sản phẩm</th>
            <th>Nhà cung cấp</th>
            <th>Đơn vị</th>
            <th>mô tả</th>
            <td>Delete</td>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <%
            ProductService productService = new ProductService();
            List<Product> products = productService.getProducts();
            for (Product product : products) {
                String delete = "controls?action=delete_product&id=" + product.getId();
        %>
        <tr>
            <td><%= product.getName() %>
            </td>
            <td><%= product.getManufacturer() %>
            </td>
            <td><%= product.getUnit() %>
            </td>
            <td><%= product.getDescription() %>
            </td>
            <td>
                <a class="btn btn-sm " href=<%=delete%>>
                    <i class="fa-solid fa-trash"></i>
                    <p>xóa</p>
                </a>
            </td>
            <td>
                <a class="btn btn-sm" href="update-product.jsp?id=<%=product.getId()%>">
                    <i class="fa-regular fa-pen-to-square"></i>
                    <p>sửa</p>
                </a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
