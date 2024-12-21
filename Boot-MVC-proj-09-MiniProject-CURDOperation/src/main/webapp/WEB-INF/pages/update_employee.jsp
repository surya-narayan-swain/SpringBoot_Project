<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="color: blue ;text-align: center;">Update Employee</h1>

<frm:form modelAttribute="emp">
<table align="center" bgcolor="cyan">
<tr>
<td>Employee Number</td>
<td><frm:input path="empno" readonly="true"/></td>
</tr>
<tr>
<td>Employee Name</td>
<td><frm:input path="ename"/></td>
</tr>
<tr>
<td>Employee Desg</td>
<td><frm:input path="job"/></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><frm:input path="sal"/></td>
</tr>
<tr>
<td>Dept no</td>
<td><frm:input path="deptno"/></td>
</tr>
<tr>
<td><input type="submit" value="Update Employee"></td>
<td><input type="reset" value="Cancel"></td>
</tr>


</table>


</frm:form>


</body>
</html>