package com.orange.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */

public class OrangeLocatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrangeLocatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lng = Double.parseDouble(request.getParameter("lng"));
		String mbl = request.getParameter("mobile_name");
		ShopLocator s = new ShopLocator();
		Distance distance_find=s.findOrangeShopWithMobileAvailable(lng, lat, mbl);
		Line response1=distance_find.getLine();
		double distance = distance_find.getDistance();
		
		int avail=1;
		switch(mbl)
		{
		case "sunusng": avail=Integer.parseInt(response1.getField4());
			break;
		case "ipom":avail=Integer.parseInt(response1.getField5());
			break;
		case "weiwei": avail=Integer.parseInt(response1.getField6());
			break;
		}
		
		
		
		
		
		
		
		

		request.setAttribute("destination_lat", Double.parseDouble(response1.getField2()));
		request.setAttribute("destination_lng", Double.parseDouble(response1.getField1()));
		request.setAttribute("destination_address", response1.getField3());
		request.setAttribute("available",avail);
		request.setAttribute("user_lat",lat);
		request.setAttribute("user_lng",lng);
		request.setAttribute("distance",distance);
		request.setAttribute("mobile",mbl);
		RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/locator.jsp");
		rd.forward(request, response);
	}

}
