<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/7/30 0030
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<br/>
<br/>
<br/>

    <h2 align="center">系统登录用户列表</h2>

<br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/user/addInit">新 增</a>
<br/><br/>
      <table border="1" align="center">
          <thead>
            <tr>
                <td>序号</td>
                <td>用户编码</td>
                <td>用户名</td>
                <td>性别</td>
                <td>出生日期</td>
                <td>电子邮件</td>
                <td>联系地址</td>
                <td>联系电话</td>
                <td>操作</td>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${users}" var="data" varStatus="s">
                <tr>
                    <td><c:out value="${s.index+1}"/></td>
                    <td><c:out value="${data.userId}"/></td>
                    <td><c:out value="${data.userName}"/></td>
                    <td><c:out value="${data.password}"/></td>
                    <td><c:out value="${data.birthday}"/></td>
                    <td><c:out value="${data.email}"/></td>
                    <td><c:out value="${data.address}"/></td>
                    <td><c:out value="${data.phone}"/></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/user/modifyInit?userId=${data.userId}">修 改</a>
                        <a href="<%=request.getContextPath()%>/user/modifyInit2/${data.userId}">修 改2</a>
                        <a href="<%=request.getContextPath()%>/user/delete/${data.userId}">删 除</a>
                    </td>
                </tr>
            </c:forEach>
          </tbody>
      </table>

</body>
</html>
