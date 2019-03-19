<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Customer</title>

<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>CRM-CUSTOMER</h2>
		
		</div>

</div>

<div class="container">

 <h3>Save Customer</h3>
 
 <form:form action="saveCustomer" modelAttribute="customer" method="post">
  <form:hidden path="id" />
 <table>
 <tbody>

<tr>
	<td> <label>Adı</label></td>
	<td><form:input path="firstName"/> </td>
 </tr>
 <tr>
	<td> <label>SoyAdı</label></td>
	<td><form:input path="lastName"/> </td>
 </tr> 
 <tr>
	<td> <label>Mail</label></td>
	<td><form:input path="email"/> </td>
 </tr>  
  <tr>
	<td><label></label></td>
	<td><input type="submit" value="Kaydet" class="save"/></td>
 </tr>  
 </tbody>
 </table>
 </form:form>
 
 

</div>
</body>
</html>