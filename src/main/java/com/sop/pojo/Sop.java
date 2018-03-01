package com.sop.pojo;

import java.util.Date;

public class Sop {
	private Integer id;

	private String fileName;
	
	private String buMen;
	
	private String xiTong;
	
	private Date insertTime;
	
	public Sop(Integer id,String fileName,String buMen,String xiTong,Date insertTime){
		this.id=id;
		this.fileName=fileName;
		this.buMen=buMen;
		this.xiTong=xiTong;
		this.insertTime=insertTime;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBuMen() {
		return buMen;
	}

	public void setBuMen(String buMen) {
		this.buMen = buMen;
	}

	public String getXiTong() {
		return xiTong;
	}

	public void setXiTong(String xiTong) {
		this.xiTong = xiTong;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	
	
	
	
}
