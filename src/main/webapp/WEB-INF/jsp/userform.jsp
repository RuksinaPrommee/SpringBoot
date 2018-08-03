<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h1>Hello World</h1>
<form action="/save" method="POST">
	First Name: <input type="text" name="firstName"> <br />
	<br /> Last Name: <input type="text" name="lastName" /> <br />
	<br /> <input type="submit" value="Submit" />
</form>
<br />
<br />
<table>
	<tbody>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
		</tr>
		<c:forEach var="user" items="${users}">    	                     
		    <tr>
		        <td>${user.firstName}</td>
		        <td>${user.lastName}</td>
		    </tr>
		</c:forEach>
	</tbody>
</table>
