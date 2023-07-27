package com.metro.dao;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class FetchFileClass {

	public static void main(String ar[]) {
		/*
		 * file - 10_2_57577_20230519203911_invoice_main.pdf
		 *
		 * C:\Users\chandan.kumar\Desktop\InvoiceDownload/test/
		 */
		StringBuilder remotePath = new StringBuilder();
		remotePath.append("/TPServer/Server/Reports/Normal/20230519");
		remotePath.append("10_2_57577_20230519203911_invoice_main.pdf");
		String downloadPath = "C:/Users/chandan.kumar/Desktop/InvoiceDownload/test";

		FetchFileClass fetchFile = new FetchFileClass();
		try {
			fetchFile.downloadSFTPFile(remotePath.toString(), downloadPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static String findFind_01(String downloadFolderPath, String name) {
		String fileLoc_01 = null;
		File path = new File(downloadFolderPath);
	    File[] files = path.listFiles();
	        System.out.println("match pattern [" + name + "]:");
	        for (File file : files) {
	        	String fileName = file.getName();
	        	//String filenameObj = new String(fileName);\
	        	System.out.println(".pdf name : "+fileName);
	        	boolean filemacthes = fileName.matches(name);
	        	if(filemacthes) {
	        		System.out.println(".pdf matched"+fileName);
	        		fileLoc_01 = fileName;
	        		return fileLoc_01;


	        	}
	    }
	        return fileLoc_01;
}

	public  void featchFiles(String storeNo,String counterNo, String date, String txnno) {



		//String path  = "C:\\Users\\chandan.kumar\\Desktop\\New folder";
		      String path  = "file://10.141.83.57/TPServer/Server/Reports/Normal/"+date +"/";
				if(storeNo == "") {
					storeNo = "[0-9]*?";
				}
				if(counterNo == "") {
					counterNo = "[0-9]*?";
				}
				if(txnno =="") {
					date = "[0-9]*?";
				}
				String name = storeNo+"_"+counterNo+"_"+txnno+"_"+date+"[0-9]*"+"_[a-z]*_[a-z]*.pdf";
				String filePath =  findFind_01(path, name);

				if(filePath == null) {
					return;
				}
				String fileCompletePAth = path+filePath;
				File pdfFile = new File(fileCompletePAth);
				if (pdfFile.exists()) {

					if (Desktop.isDesktopSupported()) {
						try {
							Desktop.getDesktop().open(pdfFile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

	}

	private void downloadSFTPFile(String remotePath, String downloadPath) throws IOException {

		// create a instance of sftpConnector
        //SFTPConnector sftpConnector = new SFTPConnector();

        // getting sftpClient by calling method of sftpConnector
        /*
         * "file://10.141.83.57/TPServer/Server/Reports/Normal/"+date +"/"
         */
        SSHClient client = new SSHClient();
        // add host key verifier
        client.addHostKeyVerifier(new PromiscuousVerifier());

        // connect to the sftp server



        try {
        	client.connect("ban11mpsp010001.mpos.madm.net");

        	// authenticate by username and password.
        	// client.authPassword("test_user", "123");

        	SFTPClient sftpClient = client.newSFTPClient();

            //String remoteDir = "/test_user/demo";
            // list all the files from the sftp server for specific directory.
            List<RemoteResourceInfo> resourceInfoList = sftpClient.ls(remotePath);

            // files will be stored in this directory after downloading.
            //String downloading_dir = "/home/malav/Downloads/test/";

            for (RemoteResourceInfo file : resourceInfoList) {
                // download or get file from the sftp server.
                //sftpClient.get(file.getPath(), downloadPath);
                System.out.printf("%s is downloaded%n", file.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            client.close();
        }












	}
}
