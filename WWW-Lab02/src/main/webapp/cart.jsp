<%@ page import="java.text.DecimalFormat" %>
<%@ page import="backend.models.OrderDetail" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="backend.models.Product" %>
<%@ page import="backend.services.ProductImageService" %>
<%@ page import="backend.services.ProductPriceService" %>
<%@ page import="backend.services.ProductService" %>
<%@ page import="backend.dto.Cart" %>
<%@ page import="backend.models.ProductPrice" %>
<%@ page import="backend.repositories.ProductRepository" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 06/10/2023
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <%@include file="cdn.jsp" %>
    <style>
        .table tbody td {
            vertical-align: middle;
        }

        .btn-incre, .btn-decre {
            box-shadow: none;
            font-size: 25px;
        }
    </style>

</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container my-3">
    <%
        DecimalFormat dcf = new DecimalFormat("#.##");
        request.setAttribute("dcf", dcf);
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        List<Cart> cartProduct = null;
        if (cart_list != null) {
            ProductRepository productRepository = new ProductRepository();
            cartProduct = productRepository.getCartProducts(cart_list);
            double total = productRepository.getTotalCartPrice(cart_list);
            request.setAttribute("total", total);
            request.setAttribute("cart_list", cart_list);
        }

    %>

    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cart_list != null) {
                for (Cart c : cartProduct) {
        %>
        <tr>
            <td><%=c.getName()%>
            </td>
            <td><%= dcf.format(c.getPrice())%>
            </td>
            <td>
                <form class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i
                                class="fas fa-plus-square"></i></a>
                        <input type="text" name="quantity" class="form-control" value="<%=c.getQuantity()%>" readonly>
                        <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i
                                class="fas fa-minus-square"></i></a>
                    </div>
                </form>
            </td>
            <td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
        </tr>

        <%
                }
            }%>
        </tbody>
    </table>

    <div class="d-flex py-3">
        <div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a
                class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
    </div>
</div>
</body>
</html>
