package com.metro.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DownloadInvoiceServiceImpl {

	public static StringBuilder invoiceFileFullPath(String invoiceNo, String date, String storeId) throws Exception {

		List<String> info = connectAndGetRequiredInfo(invoiceNo, storeId);


		/*
		 * String storeNo = "19"; //IRetailStoreID String counterNo=
		 * "1";//-IWorkstationNmbr String transactionId = "119564";//- ITaNmbr date =
		 * "20230519"; String time = "103027";//-szTime
		 */

		if(info.size() < 2) {
			throw new Exception(" Invoice is not found in database : "+ ServerInfo.getServerName(Integer.valueOf(storeId)));
		}

		  String storeNo = info.get(0);
		  if(!storeNo.equalsIgnoreCase(storeId)) {
			  throw new Exception(" You are checking wrong store bill..............it belongs to store :"+storeNo);
		  }
		  String counterNo=info.get(1);
		  String transactionId=info.get(2);
		  date=info.get(3);
		  String time=info.get(4);

		String initialPath = getPathBasedOnStore(storeNo, date);
		String fileNameReg = getFileNameRegrex(storeNo, counterNo, transactionId, date, time);

		String filepath = findFind_01(initialPath, fileNameReg);
		StringBuilder builder = new StringBuilder();
		builder.append(initialPath);
		builder.append(filepath);
		return builder;
	}

	public static String findFind_01(String initialPath, String name) throws Exception {
		try {
		String fileLoc_01 = null;
		File path = new File(initialPath);
		File[] files = path.listFiles();
		System.out.println("match pattern [" + name + "]:");
		for (File file : files) {
			String fileName = file.getName();
			boolean filemacthes = fileName.matches(name);
			if(filemacthes) {
				System.out.println("File Available ----------------------------------> "+fileName);
				fileLoc_01 = fileName;
				return fileLoc_01;
			}
		}
		return fileLoc_01;}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Invoice is not present. It might be deleted. !!!!!!!!!!!!!!!!!!!!!");
		}
	}

	public static String getFileNameRegrex(String storeNo, String counterNo, String transactionId,String date, String time) {
		StringBuilder invoiceFileFullPath = new StringBuilder();
		invoiceFileFullPath.append(storeNo);
		invoiceFileFullPath.append("_");
		invoiceFileFullPath.append(counterNo);
		invoiceFileFullPath.append("_");
		invoiceFileFullPath.append(transactionId);
		invoiceFileFullPath.append("_");
		invoiceFileFullPath.append(date);
		invoiceFileFullPath.append(time);
		invoiceFileFullPath.append("_");
		System.out.println(invoiceFileFullPath.toString());
		String regEx = invoiceFileFullPath+"[a-z]*_[a-z]*.pdf";
		System.out.println("Regrex of file name ----------------------------------> "+regEx);
		return regEx;


	}


	public static String getPathBasedOnStore(String storeId, String date) {
		String initialPath = ServerInfo.getTPFileLocation(Integer.valueOf(storeId));
		initialPath ="//"+ initialPath+"/TPServer/Server/Reports/Normal/"+date+"/";
		return initialPath;
	}
	public static Connection connectionObject = null;
	public static Connection getConnection(String storeId) throws ClassNotFoundException  {




		if(connectionObject != null) {
			return connectionObject;
		}
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			new ServerInfo();

			Connection connectionObject = DriverManager.getConnection("jdbc:sqlserver://"+ ServerInfo.getServerName(Integer.valueOf(storeId)) +";databaseName=TPCentralDB;integratedSecurity=true;");


			return connectionObject;
		}catch(Exception ex) {
			throw new ClassNotFoundException(" Connection failure : ");
		}
	}

	public static List<String> connectAndGetRequiredInfo(String invoiceNo, String storeId) throws ClassNotFoundException, SQLException  {
		List<String> info = new ArrayList<>();
		try {

			Connection con = getConnection(storeId);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select lRetailStoreID,lWorkstationNmbr,lTaNmbr,szDate,szTime from maitxinvoice where szlegalinvoiceid = '"+invoiceNo+"'");
			try {
				while (rs.next()) {
					String storeID = rs.getString("lRetailStoreID");
					String counterNo = rs.getString("lWorkstationNmbr");
					String transactionId = rs.getString("lTaNmbr");
					String date = rs.getString("szDate");
					String szTime = rs.getString("szTime");
					info.add(storeID);
					info.add(counterNo);
					info.add(transactionId);
					info.add(date);
					info.add(szTime);
				}

			} catch (SQLException e) {

				e.printStackTrace();
				throw new SQLException("Connection is not established !!!!!!!");
			}
			con.close();
			return info;

		} catch (ClassNotFoundException ex) {

						ex.printStackTrace();
						throw new ClassNotFoundException("Driver is not found!!!!!!");
		}catch(SQLException ex) {

						ex.printStackTrace();
						throw new SQLException("Connection is not established !!!!!!!");
		}
	}
}
