package com.example.demo.Models;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@NamedEntityGraph(
		  name = "generator-entity-graph",
		  attributeNodes = {
		    @NamedAttributeNode("senders"),
		    @NamedAttributeNode("reciepnts"),
		    @NamedAttributeNode("telegraphs"),
		  }
		)

@Entity
@Table(name="TGH_GENERATOR")
public class TGHGenerator {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GeneratorSEQ")
//	@SequenceGenerator(name = "GeneratorSEQ", sequenceName="TGH_GENERATOR_SEQ1", allocationSize = 1)
	@Column(name="GEN_ID")
	private Long id;
	
//	@JsonProperty("CallDate")
	@Column(name="CALL_DATE")
	private LocalDate CallDate= LocalDate.now();
	
//	@JsonProperty("CallerTelNum")
	@Column(name="CALLER_TEL_NO")
	private String callerTelNum;
	
//	@JsonProperty("CallerName")
	@Column(name="CALLER_NAME")
	private String callerName;
	
//	@JsonProperty("SendDate")
    @JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="SEND_DATE")
	private Date SendDate;
	
//	@JsonProperty("Template")
	@Column(name="TEMPLATE")
	private int Template;
	
//	@JsonProperty("TempTypeCode")
	@Column(name="TEMP_TYPE_CODE")
	private String TempTypeCode;
	
//	@JsonProperty("TempCode")
	@Column(name="TEMP_CODE")
	private String TempCode;
	
//	@JsonProperty("DeliveryNotice")
	@Column(name="DELIVERY_NOTICE")
	private int DeliveryNotice;
	
//	@JsonProperty("Urgent")
	@Column(name="URGENT")
	private int Urgent;
	
//	@JsonProperty("Message")
	@Column(name="MESSAGE")
	private String message;
	
//	@JsonProperty("Senders")
    @OneToMany(mappedBy="generator1",fetch=FetchType.EAGER)
	private Set<TGHSender> senders;
	
//	@JsonProperty("Reciepnts")
    @OneToMany(mappedBy="generator2",fetch=FetchType.EAGER)	
	private Set<TGHRecepient> reciepnts;
	
//	@JsonProperty("Telegraphs")
    @OneToMany(mappedBy="generator3",fetch=FetchType.EAGER)	
	private Set<TGHTelegraph> telegraphs;
	
	@Override
	public String toString() {
		return "TGHGenerator [id=" + id + ", CallDate=" + CallDate + ", CallerTelNum=" + callerTelNum + ", CallerName="
				+ callerName + ", SendDate=" + SendDate + ", Template=" + Template + ", TempTypeCode=" + TempTypeCode
				+ ", TempCode=" + TempCode + ", DeliveryNotice=" + DeliveryNotice + ", Urgent=" + Urgent + ", Message="
				+ message + "]";
	}
	
	public TGHGenerator() {
		
	}
	
	public TGHGenerator(Long id,String callertelnum,String callerName, Date sendDate, int template,
			String tempTypeCode, String tempCode, int deliveryNotice, int urgent, String message) {
//		super();
		this.id = id;
		CallDate = LocalDate.now();
		this.callerTelNum = callertelnum;
		this.callerName = callerName;
		SendDate = sendDate;
		Template = template;
		this.TempTypeCode = tempTypeCode;
		TempCode = tempCode;
		DeliveryNotice = deliveryNotice;
		Urgent = urgent;
		this.message = message;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	

	public Set<TGHSender> getSenders() {
		return senders;
	}

	public void setSenders(Set<TGHSender> senders) {
		this.senders = senders;
	}



	public Set<TGHRecepient> getReciepnts() {
		return reciepnts;
	}

	public void setReciepnts(Set<TGHRecepient> reciepnts) {
		this.reciepnts = reciepnts;
	}

	public Set<TGHTelegraph> getTelegraphs() {
		return telegraphs;
	}

	public void setTelegraphs(Set<TGHTelegraph> telegraphs) {
		this.telegraphs = telegraphs;
	}



//	public Set<TGHTelegraph> getTelegraphs() {
//		return Telegraphs;
//	}
//
//	public void setTelegraphs(Set<TGHTelegraph> telegraphs) {
//		Telegraphs = telegraphs;
//	}
	

}
