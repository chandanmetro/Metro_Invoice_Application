package com.metro.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String fileName =(String) request.getSession().getAttribute("FileName");
		String filelocation = (String) request.getSession().getAttribute("FileLocation");

		 response.setHeader("Content-Disposition","inline; filename=\""+
				 fileName+"\"");
				  response.setContentType("application/pdf; name=\""+fileName+"\"");
				  String hKey = "Content-Disposition"; String hValue =
				  "attachment; name=\""+fileName+"\""; response.setHeader(hKey, hValue);
				  FileInputStream inputStream = new
				  FileInputStream(filelocation); byte[] readData = new
				  byte[BUFFER_SIZE]; int dataThere = 1; OutputStream os =
				  response.getOutputStream(); while((dataThere = inputStream.read(readData)) !=
				  -1) { os.write(readData,0,dataThere); }

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}