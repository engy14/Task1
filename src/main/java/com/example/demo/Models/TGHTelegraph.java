package com.example.demo.Models;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="TGH_TELEGRAPH")
public class TGHTelegraph {
	@Column(name="GEN_ID")
	private Long GenId;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TGH_TELEGRAPH_SEQ")
	@SequenceGenerator(name = "TGH_TELEGRAPH_SEQ", sequenceName="TGH_TELEGRAPH_SEQ", allocationSize = 1)
	@Column(name="TGH_ID")
	private Long TGHId;
	
	@Column(name="SENDER_NAME2")
	private String SenderName2;
	
	@Column(name="SENDER_NAME")
	private String SenderName;
	
	@Column(name="CALLER_NAME")
	private String CallerName;
	
	@Column(name="REC_NAME")
	private String RecName;
	
	@Column(name="REC_NAME2")
	private String RecName2;
	
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="TGH_DATE")
	private LocalDate TGHDate=LocalDate.now();
	
    @JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="SEND_DATE")
	private Date TGHSend_Date;
	
	@Column(name="STATUS_CODE")
	private String StatusCode;
	
	@Column(name="USER_CODE")
	private String UserCode;
	
	@Column(name="SEQ_NO")
	private int SeqNum;
	
	@Column(name="PLAN_CODE")
	private String PlanCode;
	
	@Column(name="COUNTRY_CODE")
	private String CountryCode;
	
	@Column(name="MESSAGE")
	private String Message;
	
	@Column(name="ADDRESS")
	private String Address;
	
	@Column(name="TGH_COST")
	private String Cost;
	
	@Column(name="NOTES")
	private String Notes;
	
	@Column(name="TGH_CODE")
	private String TGHCode;
	
//	@JsonProperty("tghdate")
//    @JsonFormat(pattern="yyyy-MM-dd")
//	private Date tghdate;
//    
//	@JsonProperty("tghdateto")
//    @JsonFormat(pattern="yyyy-MM-dd")
//	private Date tghdateto;
	
	@ManyToOne
	@JoinColumn(name = "GEN_ID", insertable = false, updatable = false)
	@JsonIgnore    
	private TGHGenerator generator3;

	@Override
	public String toString() {
		return "TGHTelegraph [GenId=" + GenId + ", TGHId=" + TGHId + ", SenderName=" + SenderName + ", RecName=" + RecName
				+ ", TGHDate=" + TGHDate + ", StatusCode=" + StatusCode + ", Address=" + Address + ", Cost=" + Cost
				+ ", Notes=" + Notes + "]";
	}

	public TGHTelegraph() {
		StatusCode = "11";
		TGHCode="1000";
		UserCode="111";
		SeqNum=10;
		PlanCode="1000";
		CountryCode="EG";
		Cost="200";
	}
	public TGHTelegraph(Long genId, Long tGHId, String senderName, String recName,
			String address, String cost, String notes, String statusCode, String Temp,String UserCode,int SeqNum,String PlanCode,String CountryCode) {
//		super();
		GenId = genId;
		TGHId = tGHId;
		SenderName = senderName;
		RecName = recName;
		StatusCode = statusCode;
		Address = address;
		Cost = cost;
		Notes = notes;
		TGHCode=Temp;
		this.UserCode=UserCode;
		this.SeqNum=SeqNum;
		this.PlanCode=PlanCode;
		this.CountryCode=CountryCode;
	}

	
	public String getUserCode() {
		return UserCode;
	}

	public void setUserCode(String userCode) {
		UserCode = userCode;
	}

	
	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getTGHCode() {
		return TGHCode;
	}

	public void setTGHCode(String tGHCode) {
		TGHCode = tGHCode;
	}

	public Long getGenId() {
		return GenId;
	}

	public void setGenId(Long genId) {
		GenId = genId;
	}

	public Long getTGHId() {
		return TGHId;
	}

	public void setTGHId(Long tGHId) {
		TGHId = tGHId;
	}
	
	
	public int getSeqNum() {
		return SeqNum;
	}

	public void setSeqNum(int seqNum) {
		SeqNum = seqNum;
	}

	public LocalDate getTGHDate() {
		return TGHDate;
	}

	public void setTGHDate(LocalDate tGHDate) {
		TGHDate = tGHDate;
	}

	public Date getTGHSend_Date() {
		return TGHSend_Date;
	}

	public void setTGHSend_Date(Date tGHSend_Date) {
		TGHSend_Date = tGHSend_Date;
	}
		

	public String getPlanCode() {
		return PlanCode;
	}

	public void setPlanCode(String planCode) {
		PlanCode = planCode;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	public String getRecName2() {
		return RecName2;
	}

	public void setRecName2(String recName2) {
		RecName2 = recName2;
	}

	
	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}

	public String getCallerName() {
		return CallerName;
	}

	public void setCallerName(String callerName) {
		CallerName = callerName;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public TGHGenerator getGenerator3() {
		return generator3;
	}

	public void setGenerator3(TGHGenerator generator3) {
		this.generator3 = generator3;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getRecName() {
		return RecName;
	}

	public void setRecName(String recName) {
		RecName = recName;
	}

	public String getSenderName2() {
		return SenderName2;
	}

	public void setSenderName2(String senderName2) {
		SenderName2 = senderName2;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

//	public Date getTghdate() {
//		return tghdate;
//	}
//
//	public void setTghdate(Date tghdate) {
//		this.tghdate = tghdate;
//	}
//
//	public Date getTghdateto() {
//		return tghdateto;
//	}
//
//	public void setTghdateto(Date tghdateto) {
//		this.tghdateto = tghdateto;
//	}
//	
	
	
}
