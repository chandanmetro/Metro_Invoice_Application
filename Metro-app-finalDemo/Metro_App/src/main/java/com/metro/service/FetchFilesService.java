package com.metro.service;

import java.util.List;



public interface FetchFilesService {
	public List<String> fetchFiles(String storeNo,String counterNo, String date, String incoiveNo) throws ClassNotFoundException;
}
