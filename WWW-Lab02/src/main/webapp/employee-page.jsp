<%@ page import="backend.services.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="backend.models.Employee" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Page</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <h2 class="text-center m-5">List Employee</h2>


    <div class="container">
        <table class="table table-bordered table-responsive">
            <thead class="table-dark">
            <tr>
                <th>Full name</th>
                <th>Date of birth</th>
                <th>Email</th>
                <th>Status</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <%
                EmployeeService employeeService = new EmployeeService();
                List<Employee> employees = employeeService.getAll();
                for (Employee employee : employees) {
                    String delete = "controls?action=delete_employee&id=" + employee.getId();
            %>
            <tr>
                <td><%= employee.getFullName() %></td>
                <td><%= employee.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %></td>
                <td><%= employee.getEmail() %></td>
                <td><%= employee.getEmployeeStatus() %></td>
                <td><%= employee.getPhone() %></td>
                <td><%= employee.getAddress() %></td>
                <td>
                    <a class="btn " href=<%=delete%>>
                        <i class="fa-solid fa-trash"></i>
                        <p>xóa</p>
                    </a>
                </td>
                <td>
                    <a class="btn btn-sm" href="update-employee.jsp?id=<%=employee.getId()%>">
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
