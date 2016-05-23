<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加员工</title>
    </head>
    <body>
        <jsp:include page="/head.jsp"></jsp:include>
        <s:form action="emp_save.action" method="POST" theme="simple">
        <table border="1" align="center" width="80%" cellpadding="5" cellspacing="0">
            <tr>
                <td>员工姓名</td>
                <td>
                    <s:textfield name="empName" id="empName" value=""></s:textfield>
                </td>
            </tr>
            <tr>
                <td>员工薪水</td>
                <td>
                    <s:textfield name="salary" id="salary" value=""></s:textfield>
                </td>
            </tr>
            <tr>
                <td>选择部门</td>
                <td>
                    <s:select name="deptId" headerKey="-1" headerValue="请选择" list="#request.listDept" listKey="id" listValue="name" value="-1">

                    </s:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:submit value="添加员工"></s:submit>
                </td>

            </tr>
        </table>
        </s:form>
    </body>
</html>
