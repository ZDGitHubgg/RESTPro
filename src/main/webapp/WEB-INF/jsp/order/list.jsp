<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>REST风格</title>
</head>
<body>
<h2>获取订单列表（REST风格CURD操作）</h2>
<br>
<form action="/order/1" method="post" id="deleteForm">
    <input type="hidden" name="_method" value="DELETE" />
</form>

<form action="/order/1" method="post" id="updateForm">
    <input type="hidden" name="_method" value="PUT" />
</form>

<table align="center"  width="60%" border="1px" bordercolor="#FB5832" CELLSPACING="0">
    <tr>
        <td>id</td>
        <td>订单</td>
        <td>金额</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${orderList }" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.code}</td>
            <td>${order.money}</td>
            <td>
                <a href="javascript:void(0)" onclick="deleteById(${order.id})">删除</a>
                <a href="javascript:void(0)" onclick="updateById(${order.id})">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>

<center>
    <h3>添加订单</h3>
    <form action="${pageContext.request.contextPath}/order/save" method="post">
        <label for="code">订单<input id="code" type="text" name="code" /></label>
        <label for="money">总金额<input id="money" type="text" name="money" /></label>
        <button>添加订单</button>
    </form>
</center>

<script>

    function updateById(id) {
        //更新订单
        //注意 要动态修改form的action
        var form = document.getElementById("updateForm");
        form.action = "${pageContext.request.contextPath}/order/"+id;
        form.submit();
    }

    function deleteById(id) {
        //TODO 删除
        var form = document.getElementById("deleteForm");
        form.action = "${pageContext.request.contextPath}/order/"+id;
        form.submit();
    }

</script>

</body>
</html>
