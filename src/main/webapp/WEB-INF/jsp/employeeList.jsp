<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>:: Employee details ::</title>
<BODY>
	<div>
		Welcome ${userName }..!! <a href="login.go">Go Back</a>
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<td>Employee ID</td>
						<td>Employee Name</td>
						<td>Employee User ID</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${eList }">
						<tr>
							<td>${emp.id }</td>
							<td>${emp.firstName}</td>
							<td>${emp.emailId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</center>
	</div>
</BODY>
</HTML>
