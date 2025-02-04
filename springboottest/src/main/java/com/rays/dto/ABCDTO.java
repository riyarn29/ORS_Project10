package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "abc")
public class ABCDTO extends BaseDTO {

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "OVERVIEW")
	private String overview;

	@Column(name = "ANALYSIS_TYPE")
	private String analysisType;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;
	
	  @Column(name = "COVERAGE_AMOUNT")
	    private Integer coverageAmount;

	  @Column(name = "QUANTITY")
	    private Integer quantity;
	  
	  @Column(name = "LATITUDE")
	    private Double latitude;
	  
	  @Column(name = "LONGITUDE")
	    private Double longitude;
	

	@Column(name = "ORG_NAME", length = 50)
	private String orgName;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public String getAnalysisType() {
		return analysisType;
	}


	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Integer getCoverageAmount() {
		return coverageAmount;
	}


	public void setCoverageAmount(Integer coverageAmount) {
		this.coverageAmount = coverageAmount;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "orgName";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

	
	

	

	
	

}

	
	
