package com.example.demo.Models;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TGHGeneratorSearch {

	private Long id;
	
	private String callerName;


    
	private String callerTelNum;
	
	private int Template;

	private String TempTypeCode;

	private String TempCode;

	private int DeliveryNotice;

	private int Urgent;
	

	private LocalDate CallDate;
	
	@JsonProperty("Calldatefrom")
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate calldatefrom;
    
	@JsonProperty("Calldateto")
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate calldateto;
	
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date SendDate;

	@JsonProperty("Datefrom")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date senddatefrom;
    
	@JsonProperty("Dateto")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date senddateto;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
    @JsonFormat(pattern="yyyy-MM-dd")

	public Date getSendDate() {
		return SendDate;
	}

	public void setSendDate(Date sendDate) {
		SendDate = sendDate;
	}

	public LocalDate getCallDate() {
		return CallDate;
	}

	public void setCallDate(LocalDate callDate) {
		CallDate = callDate;
	}

	public String getCallerTelNum() {
		return callerTelNum;
	}

	public void setCallerTelNum(String callerTelNum) {
		this.callerTelNum = callerTelNum;
	}

	public int getTemplate() {
		return Template;
	}

	public void setTemplate(int template) {
		Template = template;
	}

	public String getTempTypeCode() {
		return TempTypeCode;
	}

	public void setTempTypeCode(String tempTypeCode) {
		TempTypeCode = tempTypeCode;
	}

	public String getTempCode() {
		return TempCode;
	}

	public void setTempCode(String tempCode) {
		TempCode = tempCode;
	}

	public int getDeliveryNotice() {
		return DeliveryNotice;
	}

	public void setDeliveryNotice(int deliveryNotice) {
		DeliveryNotice = deliveryNotice;
	}

	public int getUrgent() {
		return Urgent;
	}

	public void setUrgent(int urgent) {
		Urgent = urgent;
	}

	public LocalDate getCalldatefrom() {
		return calldatefrom;
	}

	public void setCalldatefrom(LocalDate calldatefrom) {
		this.calldatefrom = calldatefrom;
	}

	public LocalDate getCalldateto() {
		return calldateto;
	}

	public void setCalldateto(LocalDate calldateto) {
		this.calldateto = calldateto;
	}

	public Date getSenddatefrom() {
		return senddatefrom;
	}

	public void setSenddatefrom(Date senddatefrom) {
		this.senddatefrom = senddatefrom;
	}

	public Date getSenddateto() {
		return senddateto;
	}

	public void setSenddateto(Date senddateto) {
		this.senddateto = senddateto;
	}


	

}
