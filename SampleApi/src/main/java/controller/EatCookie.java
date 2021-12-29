package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ApiHandler;
import model.weatherBean;

/**
 * Servlet implementation class EatCookie
 */
@WebServlet("/EatCookie")
public class EatCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EatCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cookie ck[] = request.getCookies();
		
		for(int i=0;i<ck.length;i++){
			 
			
			if(ck[i].getName().equals("cname") ){ 
				System.out.println("Succses");
				String cStr = ck[i].getValue();
				//String countryStr = ck[i].getValue();
				
				String[] splitcookie = cStr.split("7");
				
				
				
				//System.out.println(splitcookie[0]);
				//System.out.println(splitcookie[1]);
				
				
//				String Cook = countryStr+"1" +cityStr;
//				ck[i].setValue(Cook);
//				
//				
//				
				weatherBean wBean = new weatherBean(splitcookie[0],splitcookie[1]);
				
			
				ArrayList<String> t =wBean.getAr();
				
				t.add(wBean.getCityStr());
				t.add("Yess");
				t.add(wBean.getCountryStr());
				t.add("funkar detta ");
				
				wBean.setAr(t);
				
				ArrayList<String> s =wBean.getAr();
				
				
				for(int i1 = 0; i1 < s.size(); i1++) {   
				    System.out.println(s.get(i1));
				}  
				
     			ApiHandler.getApi(wBean);
//				
////				
				request.setAttribute("wBean", wBean);
				RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);				
			}
			else{
				System.out.println("------");
			}
		}
		
		
			
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
