package com.dbs.fpro.healthcheck.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class FprohealthcheckResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDateTime date;
	private String serviceUrl;
	private String status;
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public FprohealthcheckResponse()
	{
		super();
	}
	public FprohealthcheckResponse(LocalDateTime date,String serviceUrl,String status)
	{
		this.date=date;
		this.serviceUrl=serviceUrl;
		this.status=status;
	}
	public FprohealthcheckResponse(String status,String serviceUrl)
	{
		this.serviceUrl=serviceUrl;
		this.status=status;
	}

	public FprohealthcheckResponse(int id,LocalDateTime date,String serviceUrl,String status)
	{
		this.id=id;
		this.date=date;
		this.serviceUrl=serviceUrl;
		this.status=status;
	}

	
	
}
