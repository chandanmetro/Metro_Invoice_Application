package com.metro.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metro.logging.LoginLogger;
import com.metro.modal.User;
import com.metro.service.DownloadInvoiceServiceImpl;
import com.metro.service.LoginService;
import com.metro.service.LoginServiceImpl;
import com.metro.service.ServerInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);

		LoginService loginService = new LoginServiceImpl();
		new ServerInfo();
		try {
			User user = loginService.userLogin(username, password);
			out.print("Login Failed..!!  Please Check your Email Id or Password..!!");
			//out.print("user.getStoreNumber() "+ user.getStoreNumber());
			DownloadInvoiceServiceImpl.getConnection(String.valueOf(user.getStoreNumber()));
			//out.print("After Calling DownloadInvoiceServiceImpl.getConnection(String.valueOf(user.getStoreNumber()))..!!");
			System.out.println(user.toString());
			if (user.getName() != null) {
				out.print("Login Successfull...!!!" + " Welcome to Metro store " + user.getStoreNumber());
				request.getSession().setAttribute("StoreId", String.valueOf(user.getStoreNumber()));
				request.getSession().setAttribute("TPFileLocation", String.valueOf(user.getTPFileLocation()));
				request.getSession().setAttribute("ServerURL", String.valueOf(user.getServerURL()));
				response.sendRedirect("index2.jsp");
				String uname = request.getParameter("username");
				String ipAddress = request.getRemoteAddr();
				LoginLogger.log(uname, ipAddress);

			} else {
				out.print("Enter correct Emailid & password..!!");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doGet(request, response);
//	}

}
