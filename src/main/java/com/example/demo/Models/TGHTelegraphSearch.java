package com.example.demo.Models;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TGHTelegraphSearch {
	
	@JsonProperty("TGH")
	private Long TGHId;
	
	@JsonProperty("Gen")
	private Long GenId;

	@JsonProperty("Send")
	private String SenderName;
	
	@JsonProperty("Caller")
	private String CallerName;
	
	@JsonProperty("Address")
	private String Address;
	
	@JsonProperty("Notes")
	private String Notes;

	@JsonProperty("Statuscode")
	private String StatusCode;
	
	@JsonProperty("Cost")
	private String Cost;
	
	@JsonProperty("TGHDate")
	private LocalDate TGHDate=LocalDate.now();
	
	@JsonProperty("TGHSend_Date")
	private Date TGHSend_Date;

	@JsonProperty("senddatefrom")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date senddatefrom;
    
	@JsonProperty("senddateto")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date senddateto;
	
	@JsonProperty("tghdate")
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate tghdate;
    
	@JsonProperty("tghdateto")
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate tghdateto;

	public Long getTGHId() {
		return TGHId;
	}

	public void setTGHId(Long tGHId) {
		TGHId = tGHId;
	}
	
	

	public LocalDate getTghdate() {
		return tghdate;
	}

	public void setTghdate(LocalDate tghdate) {
		this.tghdate = tghdate;
	}

	public LocalDate getTghdateto() {
		return tghdateto;
	}

	public void setTghdateto(LocalDate tghdateto) {
		this.tghdateto = tghdateto;
	}

	public Long getGenId() {
		return GenId;
	}

	public void setGenId(Long genId) {
		GenId = genId;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getCallerName() {
		return CallerName;
	}

	public void setCallerName(String callerName) {
		CallerName = callerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}



	public Date getTGHSend_Date() {
		return TGHSend_Date;
	}

	public void setTGHSend_Date(Date tGHSend_Date) {
		TGHSend_Date = tGHSend_Date;
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
