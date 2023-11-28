<%@ page import="backend.services.CustomerService" %>
<%@ page import="backend.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h2 class="text-center m-5">List Customers</h2>


<div class="container">
    <table class="table table-bordered table-responsive">
        <thead class="table-dark">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <%
            CustomerService customerService = new CustomerService();
            List<Customer> customers = customerService.getCustomers();
            for (Customer customer : customers) {
                String delete = "controls?action=delete_cust&id=" + customer.getId();

        %>
        <tr>
            <td><%= customer.getName() %>
            </td>
            <td><%= customer.getAddress() %>
            </td>
            <td><%= customer.getEmail() %>
            </td>
            <td><%= customer.getPhone()%>
            </td>
            <td>
                <a class="btn btn-sm" href=<%=delete%>>
                    <i class="fa-solid fa-trash"></i>
                    <p>xóa</p>
                </a>
            </td>
            <td>
                <a class="btn btn-sm" href="update-customer.jsp?id=<%=customer.getId()%>">
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
