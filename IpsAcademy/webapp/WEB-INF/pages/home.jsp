<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Student List</h1>
		
		<table border="1">

			<th>Name</th>
			<th>Surname</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Action</th>

			<c:forEach var="student" items="${listStudent}">
				<tr>

					<td>${student.name}</td>
					<td>${student.surname}</td>
					<td>${student.contact}</td>
					<td>${student.address}</td>
					<td><a href="editStudent?sid=${student.sid}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteStudent?sid=${student.sid}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Student Register <a href="newStudent">here</a>
		</h4>
	</div>
</body>
</html>