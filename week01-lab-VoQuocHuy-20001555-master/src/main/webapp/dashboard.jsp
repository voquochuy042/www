<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dash board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <meta charset="UTF-8">

</head>
<body>
<div class="container">
    <h1>Dash board</h1>
<%--    <jsp:include page="navbar.jsp" />--%>
</div>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
<h1>${user.fullName}</h1>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " href="">${user.fullName}</a>
                </li>
            </ul>
        </div>
    </nav>
    <h1>Danh sách thành viên</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">accountId</th>
            <th scope="col">fullName</th>
            <th scope="col">email</th>
            <th scope="col">phone</th>
            <th scope="col">status</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
<%--        <tr>--%>
<%--            <td>1</td>--%>
<%--            <td>Mark</td>--%>
<%--            <td>Otto</td>--%>
<%--            <td>@mdo</td>--%>
<%--            <td>Otto</td>--%>
<%--            <td>@mdo</td>--%>
<%--        </tr>--%>
<c:forEach items="${allAccount}" var="account">
    <tr>
        <td>${account.accountId}</td>
        <td>${account.fullName}</td>
        <td>${account.email}</td>
        <td>${account.phone}</td>
        <td>${account.status}</td>
        <td><a href="#" onclick="confirmDelete(${account.accountId})">Xóa</a></td>
        <td><a href="">Sửa</a></td>

        <!-- Add more table data as needed -->
    </tr>
</c:forEach>
        </tbody>

    </table>
</div>
<!-- Đường dẫn tới các tệp JavaScript của Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script >
    // function loadContent(page) {
    //     $("#content").load(page);
    //     alert("wef");
    // }
    function confirmDelete(id){
        var option = confirm('bạn có chắc chắn muốn xóa ');
        if (option === true){
            window.location.href = 'delete?id'+id;
        }
    }
</script>

</body>
</html>