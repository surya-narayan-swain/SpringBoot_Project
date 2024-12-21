<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
<c:when test="${!empty empsList}">
<h1 align="center" style="color: red;font-family: sans-serif;text-shadow: 2px 2px 2px black ">Employees Report</h1>

<table align="center" style="background: yellow;text-align: center;">
<tr style="color: red"><th>empno</th><th>empname</th><th>job</th><th>salary</th><th>deptno</th></tr>
<c:forEach var="emp" items="${empsList}">
<tr style="color: blue">
<td>${emp.empno}</td>
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td><a href="emp_edit?no=${emp.empno}"><img alt="" src="images/edit.jpeg" width="30px" height="30px"></a>
<a href="emp_delete?no=${emp.empno}"onclick="return confirm('Do you want to delete Employee')"><img alt="" src="images/delete.jpeg" width="30px" height="30px"></a></td>

</tr>
</c:forEach>

</table>
</c:when>
<c:otherwise>
<h1 style="color: red;text-align: center;">Employees not found</h1>
</c:otherwise>
</c:choose>

<h2 style="color: green;text-align: center;">${resultMsg}</h2>
<center>
<a href="emp_add"> <img alt="" src="images/add.jpeg" width="40px" height="50px">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="./"> <img alt="" src="images/home.png" width="40px" height="50px">Home</a>







</body>
</html>