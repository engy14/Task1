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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="TGH_RECEPIENT")

public class TGHRecepient {
	
	@Column(name="GEN_ID")
	private Long GenId;
	
	@Id
	@JsonProperty("RecId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RecordSEQ")
	@SequenceGenerator(name = "RecordSEQ", sequenceName="TGH_RECEPIENT_SEQ1", allocationSize = 1)
	@Column(name="REC_ID")
	private Long RecId;
	
	@JsonProperty("RecName")
	@Column(name="REC_NAME")
	private String RecName;
	
	@JsonProperty("REC_TEL_NO")
	@Column(name="REC_TEL_NO")
	private String REC_TEL_NO;
	
	@JsonProperty("Address")
	@Column(name="ADDRESS")
	private String Address;
	
	@JsonProperty("Notes")
	@Column(name="NOTES")
	private String Notes;

	@ManyToOne
	@JoinColumn(name = "GEN_ID", insertable = false, updatable = false)
	@JsonIgnore    
	private TGHGenerator generator2;
	@Override
	public String toString() {
		return "TGHRecepient [GenId=" + GenId + ", RecId=" + RecId + ", RecName=" + RecName + ", REC_TEL_NO=" + REC_TEL_NO
				+ ", Address=" + Address + ", Notes=" + Notes + "]";
	}
	
	public TGHRecepient() {
		
	}

	public TGHRecepient(Long genId, Long recId, String recName, String telNum, String address, String notes) {
//		super();
		GenId = genId;
		RecId = recId;
		RecName = recName;
		REC_TEL_NO = telNum;
		Address = address;
		Notes = notes;
	}

	public Long getGenId() {
		return GenId;
	}

	public void setGenId(Long genId) {
		GenId = genId;
	}

	public Long getRecId() {
		return RecId;
	}

	public void setRecId(Long recId) {
		RecId = recId;
	}

	public void setGenerator2(TGHGenerator newTGHGenerator) {
		// TODO Auto-generated method stub
		this.generator2=newTGHGenerator;
		
	}

	public TGHGenerator getGenerator2() {
		return generator2;
	}

	public String getRecName() {
		return RecName;
	}

	public void setRecName(String recName) {
		RecName = recName;
	}

	public String getREC_TEL_NO() {
		return REC_TEL_NO;
	}

	public void setREC_TEL_NO(String rEC_TEL_NO) {
		REC_TEL_NO = rEC_TEL_NO;
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
	
	
	
}
