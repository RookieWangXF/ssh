<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>员工列表展示</title>
    </head>
    <body>
        <jsp:include page="/head.jsp"></jsp:include>
        <table border="1" align="center" width="80%" cellpadding="5" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>薪水</th>
                <th>操作</th>
            </tr>
            <s:if test="#request.listEmp != null">
                <s:iterator var="emp" value="#request.listEmp" status="st">
                    <tr>
                        <td><s:property value="#st.count" /> </td>
                        <td><s:property value="#emp.id" /> </td>
                        <td><s:property value="#emp.empName" /> </td>
                        <td><s:property value="#emp.salary" /> </td>
                        <td>
                            <s:a href="emp_viewUpdate.action?id=%{#emp.id}">修改</s:a>
                            <s:a href="emp_delete.action?id=%{#emp.id}">删除</s:a>
                        </td>
                    </tr>
                </s:iterator>
            </s:if>
            <s:else>
                <tr>
                    <td colspan="5">对不起，没有数据！请先录入。 </td>
                </tr>
            </s:else>
        </table>
    </body>
</html>
