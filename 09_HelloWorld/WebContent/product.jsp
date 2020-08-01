  
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<%!  String Name = "";%>
		 	 
		 	<% Set<String> products = new LinkedHashSet<String>();%>
		 	
		<h3>Product Details</h3>
		<hr>
		
		<form action = "" method = "post">
			<table>
				<tr>
					<td>ProductName: </td>
					<td><input type="text" name="txtProductName"></td>
					<td></td><br><br>
				</tr>
				
				<tr>
					<td><input type="submit" value="Print"></td>
					<td><input type="reset" value="Clear"></td>
					<td></td>
				</tr>
			</table>
		</form>
    <br><br>
		<%	
		if (request.getParameter("txtProductName") != null)
		{
				Name =  request.getParameter("txtProductName");
				products.add(Name);
				
		}	%> 
		<br>
		<% for (int i=0; i<products.size(); i++) %>
				Suggestion : <%= products %>   
    
</body>
</html>