<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Save Customer</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />



</head>
<body>

	<div id="wrapper">
		<div id="head">
			<h2>CRM- Application</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
		<!-- need to associate this data with given customer -->
		<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><lable> First Name:</lable></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><lable> Last Name:</lable></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><lable> Email:</lable></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><lable></lable></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear;both;"></div>
		<p>
		<a  href="${pageContext.request.contextPath }/customer/list">Back to lists</a>
		</p>
		
		
		</div>
</body>

</html>