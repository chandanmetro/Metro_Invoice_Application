package com.metro.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metro.service.DownloadInvoiceServiceImpl;

/**
 * Servlet implementation class InvoiceController
 */
@WebServlet("/InvoiceController")
public class InvoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvoiceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public static int BUFFER_SIZE = 1024*1024;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String invoice = request.getParameter("InvoiceNumber");
		String date = request.getParameter("Date");
		String storeId = request.getParameter("StoreId");
		StringBuilder invoiceFileFullPath = null;
		try {
			invoiceFileFullPath =  DownloadInvoiceServiceImpl.invoiceFileFullPath(invoice, date,storeId);
		}catch(Exception ex) {
			response.getWriter().write(ex.getMessage());
			//throw new IOException(ex.getMessage());
		}
		try {
			File file = new File(invoiceFileFullPath.toString());
			if(file.exists()) {
				/*
				 * request.getSession().setAttribute("FileLocation", file.getAbsolutePath());
				 * request.getSession().setAttribute("FileName", file.getName());
				 * response.sendRedirect("index3.jsp");
				 */




				response.setHeader("Content-Disposition","inline; filename=\""+
						file.getName()+"\"");
				response.setContentType("application/pdf; name=\""+file.getName()+"\"");
				String hKey = "Content-Disposition"; String hValue =
						"attachment; name=\""+file.getName()+"\""; response.setHeader(hKey, hValue);
						FileInputStream inputStream = new
								FileInputStream(invoiceFileFullPath.toString()); byte[] readData = new
								byte[BUFFER_SIZE]; int dataThere = 1;
								OutputStream os =  response.getOutputStream();
								while((dataThere = inputStream.read(readData)) !=-1) {
									os.write(readData,0,dataThere);
								}
			}else {
				response.getWriter().write("Failed to find the file............");
				//throw new ServletException("File Not Found");
			}
		}catch(Exception ex) {
			response.getWriter().write("Location is not accesible............"+invoiceFileFullPath);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
