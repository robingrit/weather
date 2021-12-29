package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ApiController
 */
@WebServlet("/ApiController")
public class ApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		String langre = "null6null7null6null";
		
		String s1 ="";
		String str = cityStr+"6"+ countryStr + s1+ s1;
		
		weatherBean wBean = new weatherBean(cityStr,countryStr);
		Cookie ck = new Cookie("cname", str);
		ApiHandler.getApi(wBean);
		ck.setMaxAge(3600);
		response.addCookie(ck);
		
		
		

		Cookie searchCookies[] = request.getCookies();

for (int i = 0; i < searchCookies.length; i++) {
			
			if (searchCookies[i].getName().equals("cname")) {
				System.out.println("Succses");
				String cStr = searchCookies[i].getValue();
				// String countryStr = ck[i].getValue();

				String[] splitcookie = cStr.split("6");

				System.out.println(splitcookie[0]+ "ts");
				System.out.println(splitcookie[1]);
//							
			}
		}
//				
//				
    	request.setAttribute("wBean", wBean);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);	
				
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
