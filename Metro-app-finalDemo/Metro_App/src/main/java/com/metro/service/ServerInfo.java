package com.metro.service;

import java.util.HashMap;
import java.util.Map;

public class ServerInfo {
	private static Map<Integer, String> serverURLMapping = new HashMap<>();
	private static Map<Integer, String> tpURLMapping = new HashMap<>();
	static {

		serverURLMapping.put(10, "ban11mpsp010001.mpos.madm.net");
		serverURLMapping.put(11, "ban11mpsp011001.mpos.madm.net");
		serverURLMapping.put(12, "hyd11mpsp012001.mpos.madm.net");
		serverURLMapping.put(15, "hyd11mpsp015001.mpos.madm.net");
		serverURLMapping.put(16, "hyd11mpsp016001.mpos.madm.net");
		serverURLMapping.put(17, "vij11mpsp017001.mpos.madm.net");
		serverURLMapping.put(18, "ban11mpsp018001.mpos.madm.net");
		serverURLMapping.put(19, "ban11mpsp019001.mpos.madm.net");
		serverURLMapping.put(20, "mum11mpsp020001.mpos.madm.net");
		serverURLMapping.put(23, "mum11mpsp023001.mpos.madm.net");
		serverURLMapping.put(24, "idr11mpsp024001.mpos.madm.net");
		serverURLMapping.put(25, "sut11mpsp025001.mpos.madm.net");
		serverURLMapping.put(26, "ban11mpsp026001.mpos.madm.net");
		serverURLMapping.put(27, "ban11mpsp027001.mpos.madm.net");
		serverURLMapping.put(28, "ahe11mpsp028001.mpos.madm.net");
		serverURLMapping.put(29, "hyd11mpsp029000.mpos.madm.net");
		serverURLMapping.put(30, "nas11mpsp030001.mpos.madm.net");
		serverURLMapping.put(32, "mru11mpsp032001.mpos.madm.net");
		serverURLMapping.put(33, "Hub11mpsp033001.mpos.madm.net");
		serverURLMapping.put(34, "tum11mpsp034001.mpos.madm.net");
		serverURLMapping.put(36, "GTR11MPSP036001.MPOS.MADM.NET");
		serverURLMapping.put(37, "VIZ11MPSP037001.MPOS.MADM.NET");
		serverURLMapping.put(43, "cdg11mpsp043001.mpos.madm.net");
		serverURLMapping.put(45, "jai11mpsp045001.mpos.madm.net");
		serverURLMapping.put(46, "del11mpsp046001.mpos.madm.net");
		serverURLMapping.put(47, "jal11mpsp047001.mpos.madm.net");
		serverURLMapping.put(48, "asr11mpsp048001.mpos.madm.net");
		serverURLMapping.put(52, "del11mpsp052001.mpos.madm.net");
		serverURLMapping.put(53, "lkn11mpsp053001.mpos.madm.nett");
		serverURLMapping.put(54, "gzb11mpsp054001.mpos.madm.net");
		serverURLMapping.put(60, "kok11mpsp060001.mpos.madm.net");



		tpURLMapping.put(10, "10.141.89.57");
		tpURLMapping.put(11, "10.141.83.57");
		tpURLMapping.put(12, "10.141.87.57");
		tpURLMapping.put(15, "10.141.93.57");
		tpURLMapping.put(16, "10.141.103.57");
		tpURLMapping.put(17, "10.141.119.57");
		tpURLMapping.put(18, "10.141.125.57");
		tpURLMapping.put(19, "10.141.97.57");
		tpURLMapping.put(20, "10.141.85.57");
		tpURLMapping.put(23, "10.141.99.57");
		tpURLMapping.put(24, "10.141.123.57");
		tpURLMapping.put(25, "10.141.127.57");
		tpURLMapping.put(26, "10.141.115.57");
		tpURLMapping.put(27, "10.141.37.57");
		tpURLMapping.put(28, "10.141.45.57");
		tpURLMapping.put(29, "10.141.41.57");
		tpURLMapping.put(30, "10.141.49.57");
		tpURLMapping.put(32, "10.141.39.57");
		tpURLMapping.put(33, "10.220.254.123");
		tpURLMapping.put(34, "10.141.51.57");
		tpURLMapping.put(36, "10.220.238.123");
		tpURLMapping.put(37, "10.220.246.123");
		tpURLMapping.put(43, "10.141.117.57");
		tpURLMapping.put(45, "10.141.113.57");
		tpURLMapping.put(46, "10.141.107.57");
		tpURLMapping.put(47, "10.141.109.57");
		tpURLMapping.put(48, "10.141.121.57");
		tpURLMapping.put(52, "10.141.105.57");
		tpURLMapping.put(53, "10.141.33.57");
		tpURLMapping.put(54, "10.141.47.57");
		tpURLMapping.put(60, "10.141.91.57");

	}

	public static String getServerName(Integer storeId){
		return serverURLMapping.get(storeId);
	}


	public static String getTPFileLocation(Integer storeId){
		return tpURLMapping.get(storeId);
	}

}
