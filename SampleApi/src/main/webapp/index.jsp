<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp" />
<div>
<form action="ApiController" method="get">  
    City:<input type="text" name="city"/><br/>  
    Country (Language code):<input type="text" name="country"/><br/>  
    
    <input type="submit" value="go"/>  
    </form>  

</div>
<%

Cookie ck[] = request.getCookies();


if(ck != null){
	for(int i=0;i<ck.length;i++){
		//System.out.print("<br>"+ck[i].getName()+" "+ck[i].getValue());//printing name and value of cookie 
		
		if(ck[i].getName().equals("cname")){ 
			System.out.println("Succses");
			RequestDispatcher rd = request.getRequestDispatcher("EatCookie");
			rd.forward(request, response);
		}
		else{
			System.out.println("This is not working mate");
		}

	}
	
	
}



%>

    <jsp:include page="Footer.jsp"/>
</body>
</html>