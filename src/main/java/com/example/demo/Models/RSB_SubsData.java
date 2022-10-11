package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="SUBS_INFO")
public class RSB_SubsData {
	
	@Id
//	@JsonProperty("TelNum")
	@Column(name="TELEPHONE_NO")
	private String telNum;
	
//	@JsonProperty("SubName")
	@Column(name="NAME")
	private String SubName;

	public RSB_SubsData(String telNum, String subName) {
//		super();
		this.telNum = telNum;
		SubName = subName;
	}
	
	public RSB_SubsData() {
		
	}
	
	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getSubName() {
		return SubName;
	}

	public void setSubName(String subName) {
		SubName = subName;
	}
		
}
