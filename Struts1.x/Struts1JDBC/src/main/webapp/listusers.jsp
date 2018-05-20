<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List	Of Users</title>

<link href="<c:url value='/resources/mytheme/css/demo_table.css'/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/mytheme/css/demo_table_jui.css'/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/mytheme/css/jquery-ui-1.8.24.custom.css'/>"
	rel="stylesheet" type="text/css" media="all" />
<script src="<c:url value='/resources/mytheme/js/jquery.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/mytheme/js/jquery.dataTables.js'/>"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#companies").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true
		});
	});
</script>
</head>
<body id="dt_example">

	<div class="full_w">
		<div class="h_title">
			<img src="<c:url value='/resources/mytheme/images/b_usrlist.png'/>" />&nbsp;&nbsp;List
			Of Users
		</div>
		<br>
		<br>
		<br>
		<table id="companies" class="display">
			<thead>
				<tr>
					<th>Username</th>
					<th><u>First Name</u></th>
					<th><u>Last Name</u></th>
					<th><u>Phone</u></th>
					<th><u>Email Id</u></th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td align='center'><c:out value="${user.username}" /></td>
						<td align='center'><c:out value="${user.firstName}" /></td>
						<td align='center'><c:out value="${user.lastName}" /></td>
						<td align='center'><c:out value="${user.phone}" /></td>
						<td align='center'><c:out value="${user.emailId}" /></td>
						<td align='center'><a
							href="/Struts1JDBC/editUser.do?userid=${user.user_id}"><img
								src="<c:url value='/resources/mytheme/images/b_edit.png'/>" /></a>&nbsp;&nbsp;<a
							href="/Struts1JDBC/deleteUser.do?userid=${user.user_id}"><img
								src="<c:url value='/resources/mytheme/images/b_drop.png'/>" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>