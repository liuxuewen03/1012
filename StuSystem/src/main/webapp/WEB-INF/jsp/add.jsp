<%--
  Created by IntelliJ IDEA.
  User: lxw
  Date: 2020/10/12
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/doadd" method="post" enctype="multipart/form-data">
    <table class="table-flowser" width="500" border="1" align="center">
        <tr>
            <th colspan="2">增加标准信息</th>
        </tr>
        <tr>
            <td align="center">标准号</td>
            <td><input type="text" name="stdNum"/></td>
        </tr>
        <tr>
            <td align="center">中文名称</td>
            <td><input type="text" name="zhname"/></td>
        </tr>
        <tr>
            <td align="center">版本</td>
            <td><input type="text" name="version"/></td>
        </tr>
        <tr>
            <td align="center">关键词/字</td>
            <td><input type="text" name="keys"/></td>
        </tr>
        <tr>
            <td align="center">发布日期(yyyy-MM-dd)</td>
            <td><input type="text" name="releaseDate"/></td>
        </tr>
        <tr>
            <td align="center">实施日期(yyyy-MM-dd)</td>
            <td><input type="text" name="implDate"/></td>
        </tr>
        <tr>
            <td align="center">附件</td>
            <td><input type="file" name="packagePath2"/></td>
        </tr>
        <tr align="center">
            <td>
                <button type="submit" class="tijiao">提交</button>
            </td>
            <td>
                <button type="button"><a href="/">返回</a></button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
