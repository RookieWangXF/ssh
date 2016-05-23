<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div align="center" style="width:80%">
    <s:if test="#session.adminInfo != null">
        欢迎你：<s:property value="#session.adminInfo.adminName" /> &nbsp;
        <s:a HREF="#">退出</s:a>
        <s:a href="emp_viewAdd">添加员工</s:a>
    </s:if>
    <s:else>
        <s:a href="login.jsp">登录</s:a>
        <s:a href="register.jsp">注册</s:a>
    </s:else>
</div>