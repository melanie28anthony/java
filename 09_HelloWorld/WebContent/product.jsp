  
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
<%! Set<String> productSet= new HashSet<>();   %>

<form action="" method="post">
Product Name= <input type ="text" name="productname">
<input type ="submit" value="print">
</form>
<hr>

<% if(request.getParameter("productname")!= null){
	productSet.add(request.getParameter("productname"));
	}
	if(application.getAttribute("name") == null)
		application.setAttribute("name", productSet);
%>

Suggestion:
<% for(String name1 : productSet){ %>
<%= name1+"," %>
<% }%>

<% application.setAttribute("name", productSet); %>

</body>
</html>
