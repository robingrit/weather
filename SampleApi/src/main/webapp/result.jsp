<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="model.weatherBean" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<jsp:include page="Header.jsp" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div>
<p>
<%
weatherBean wBean = (weatherBean) request.getAttribute("wBean");
//// Fixa datum

out.println("The weather " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr()+ "<br>");

out.println("The weather temp "  + " in kelvin is " + wBean.getTemprature()+ "<br>" );

out.println("Todays date is " + wBean.getDate()+"");

%>
</p>

<a href="EatCookie">Testar om cookie är null</a>
<form action="ApiController" method="get">  
    City:<input type="text" name="city"/><br/>  
    Country (Language code):<input type="text" name="country"/><br/>  
    
    <input type="submit" value="go"/>  
    </form>  

</div>
<p></p>
<jsp:include page="Footer.jsp"/>
</body>
</html>