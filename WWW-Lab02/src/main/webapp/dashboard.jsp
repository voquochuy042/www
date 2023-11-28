<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="backend.repositories.OrderDetailRepository" %>
<%@ page import="backend.repositories.ProductRepository" %>

<%
    Gson gsonObj = new Gson();

    List<Map<Object, Object>> list = new ArrayList<>();
    OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
    Map<Long,Double> mapOrder = orderDetailRepository.staticsPriceByProduct();
    mapOrder.forEach((key, value) -> {
        System.out.println(key);
        System.out.println(value);
    });
//    Map<Object, Object> map = null;
    ProductRepository productRepository = new ProductRepository();
    for (Long key : mapOrder.keySet()) {
        System.out.println();
        Map<Object, Object> map = new HashMap<>();
        map.put("label", productRepository.getProductNameById(key));
        map.put("y",mapOrder.get(key));
        list.add(map);
    }
    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="cdn.jsp"%>


    <script type="text/javascript">
        window.onload = function() {

            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2", // "light1", "light2", "dark1", "dark2"
                title: {
                    text: "Biểu đồ tổng doanh thu của từng sản phẩm"
                },
                subtitles: [{
                    text: "2023"
                }],
                axisY: {
                    title: "$",
                    labelFormatter: addSymbols
                },
                data: [{
                    type: "column",
                    indexLabel: "{y}",
                    indexLabelFontColor: "#333",
                    indexLabelPlacement: "inside",
                    dataPoints: <%out.print(dataPoints);%>
                },
                    {
                        type: "line", // Biểu đồ đường
                        name: "Average Revenue",
                        showInLegend: true,
                        yValueFormatString: "#,##0.##",
                        dataPoints: <%out.print(dataPoints);%> // Dữ liệu cho biểu đồ đường
                    }]
            });
            chart.render();

            function addSymbols(e) {
                var suffixes = ["", "K", "M", "B"];

                var order = Math.max(Math.floor(Math.log(Math.abs(e.value)) / Math.log(1000)), 0);
                if(order > suffixes.length - 1)
                    order = suffixes.length - 1;

                var suffix = suffixes[order];
                return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
            }

        }
    </script>
</head>
<body>
<%@include file="navbar.jsp"%>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
</body>
</html>