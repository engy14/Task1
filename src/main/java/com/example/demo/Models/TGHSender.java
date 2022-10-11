package com.example.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="TGH_SENDER")
public class TGHSender {

	@Column(name="GEN_ID")
	private Long GenId;
	
	@Id
	@JsonProperty("SenderId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SenderSEQ")
	@SequenceGenerator(name = "SenderSEQ", sequenceName="TGH_SENDER_SEQ", allocationSize = 1)
	@Column(name="SENDER_ID")
	private Long SenderId;
	
	@JsonProperty("SenderName")
	@Column(name="SENDER_NAME")
	private String SenderName;
	
	@JsonProperty("TelNum")
	@Column(name="BILL_TEL_NO")
	private String TelNum;
	
	@JsonProperty("Notes")
	@Column(name="NOTES")
	private String Notes;
	
	@ManyToOne
	@JoinColumn(name = "GEN_ID", insertable = false, updatable = false)
	@JsonIgnore    
	private TGHGenerator generator1;


	@Override
	public String toString() {
		return "TGHSender [GenId=" + GenId + ", SenderId=" + SenderId + ", SenderName=" + SenderName + ", TelNum="
				+ TelNum + ", Notes=" + Notes + "]";
	}
	
	public TGHSender() {
		
	}

	public TGHSender(Long genId, Long senderId, String senderName, String telNum, String notes) {
		super();
		GenId = genId;
		SenderId = senderId;
		SenderName = senderName;
		TelNum = telNum;
		Notes = notes;
	}

	public Long getGenId() {
		return GenId;
	}

	public void setGenId(Long genId) {
		GenId = genId;
	}

	public Long getSenderId() {
		return SenderId;
	}

	public void setSenderId(Long senderId) {
		SenderId = senderId;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getTelNum() {
		return TelNum;
	}

	public void setTelNum(String telNum) {
		TelNum = telNum;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public TGHGenerator getGenerator1() {
		return generator1;
	}

	public void setGenerator1(TGHGenerator generator1) {
		this.generator1 = generator1;
	}

	
	
	


}
