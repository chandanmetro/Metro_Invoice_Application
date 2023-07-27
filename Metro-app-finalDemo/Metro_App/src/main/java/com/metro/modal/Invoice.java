
package com.metro.modal;

public class Invoice {
	private String  invoicenumber;

	private String customerid;

	private int storenumber;

	private String date;

	private String filepath;

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public int getStorenumber() {
		return storenumber;
	}

	public void setStorenumber(int storenumber) {
		this.storenumber = storenumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Invoice(String invoicenumber, String customerid, int storenumber, String date, String filepath) {
		super();
		this.invoicenumber = invoicenumber;
		this.customerid = customerid;
		this.storenumber = storenumber;
		this.date = date;
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return "Invoice [invoicenumber=" + invoicenumber + ", customerid=" + customerid + ", storenumber=" + storenumber
				+ ", date=" + date + ", filepath=" + filepath + "]";
	}







}
