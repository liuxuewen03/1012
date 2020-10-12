<%--
  Created by IntelliJ IDEA.
  User: lxw
  Date: 2020/10/12
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin: auto;text-align: center">
    标准信息列表
</div>
<table border="1px solid" style="text-align: center; margin: auto;">
    <tr>
        <form action="/">
            <td colspan="7" style="text-align: right"><input type="text" name="zhname">
                <input type="submit" value="提交检索">
                <button><a href="/toadd">新增标准</a></button>
                <button class="del">删除标准</button>
            </td>
        </form>
    </tr>
    <tr>
        <td><input type="checkbox" name="all" class="all"></td>
        <td>标准号</td>
        <td>中文名称</td>
        <td>版本</td>
        <td>发布日期</td>
        <td>实施日期</td>
        <td>操作</td>
    </tr>
    <c:forEach var="s" items="${standardPageInfo.list}">
        <tr>
            <td><input type="checkbox" class="dan"><input type="text"hidden value="${s.id}"></td>
            <td>${s.stdNum}</td>
            <td>${s.zhname}</td>
            <td>${s.version}</td>
            <td><fmt:formatDate type="date" value="${s.releaseDate}"/></td>
            <td><fmt:formatDate type="date" value="${s.implDate}"/></td>
            <td><a href="/statics/images/${s.packagePath}" download="${s.packagePath}">下载</a>&nbsp;&nbsp;&nbsp;<a
                    href="/toupd/${s.id}">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7" style="text-align: right">
            <a href="${standardPageInfo.firstPage}">首页</a>
            <a href="${standardPageInfo.prePage}">上一页</a>
            <a>${standardPageInfo.pageNum}/${standardPageInfo.pages}</a>
            <a href="${standardPageInfo.nextPage}">下一页</a>
            <a href="${standardPageInfo.lastPage}">末页</a>
        </td>
    </tr>
</table>

</body>
<script type="text/javascript" src="/statics/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(".all").click(function () {
        if (this.checked) {
            $(".dan").prop("checked", true);
        } else {
            $(".dan").prop("checked", false);
        }
    })
    $(".del").click(function () {
        var arr = new Array();
        $.each($(".dan"), function (i, v) {
            if (v.checked) {
                arr.push($(v).next().val())
            }
        })
        if (arr.length > 0) {
            var json = {
                "arr": arr
            }
            $.post("del", json, function (data) {
                if (data.success) {
                    alert("删除成功");
                    location.href="/";
                }
            }, "json")
        }
    })
</script>
</html>
