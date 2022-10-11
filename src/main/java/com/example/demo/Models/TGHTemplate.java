package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TGH_TEMPLATE")
public class TGHTemplate {
	
	@Column(name="TEMP_TYPE_CODE")
	private String tempTypeCode;
	
	@Id
	@Column(name="TEMP_CODE")
	private String TempCode;
	
	@Column(name="TEMP_NAME")
	private String TempName;
	
	@Column(name="TEMP_SUBJECT")
	private String Subject;

	@Override
	public String toString() {
		return "TGHTemplate [TempTypeCode=" + tempTypeCode + ", TempCode=" + TempCode + ", TempName=" + TempName
				+ ", Subject=" + Subject + "]";
	}

	public TGHTemplate() {
		
	}
	public TGHTemplate(String tempTypeCode, String tempCode, String tempName, String subject) {
//		super();
		tempTypeCode = tempTypeCode;
		TempCode = tempCode;
		TempName = tempName;
		Subject = subject;
	}

	public String getTempTypeCode() {
		return tempTypeCode;
	}

	public void setTempTypeCode(String tempTypeCode) {
		tempTypeCode = tempTypeCode;
	}

	public String getTempCode() {
		return TempCode;
	}

	public void setTempCode(String tempCode) {
		TempCode = tempCode;
	}

	public String getTempName() {
		return TempName;
	}

	public void setTempName(String tempName) {
		TempName = tempName;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}
	
	




}
