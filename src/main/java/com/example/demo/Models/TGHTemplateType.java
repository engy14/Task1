package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TGH_TEMPLATE_TYPE")
public class TGHTemplateType {

	@Id
	@Column(name="TEMP_TYPE_CODE")
	private String TempTypeCode;
	
	@Column(name="TEMP_TYPE_NAME")
	private String TempTypeName;

	@Override
	public String toString() {
		return "TGHTemplateType [TempTypeCode=" + TempTypeCode + ", TempTypeName=" + TempTypeName + "]";
	}

	public TGHTemplateType() {
		
	}
	public TGHTemplateType(String tempTypeCode, String tempTypeName) {
//		super();
		TempTypeCode = tempTypeCode;
		TempTypeName = tempTypeName;
	}

	public String getTempTypeCode() {
		return TempTypeCode;
	}

	public void setTempTypeCode(String tempTypeCode) {
		TempTypeCode = tempTypeCode;
	}

	public String getTempTypeName() {
		return TempTypeName;
	}

	public void setTempTypeName(String tempTypeName) {
		TempTypeName = tempTypeName;
	}
	
	

	
}
