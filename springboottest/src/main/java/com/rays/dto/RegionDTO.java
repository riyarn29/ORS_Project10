package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "region")
public class RegionDTO extends BaseDTO {

	 @Column(name = "STATE", length = 100)
	    private String state;

	  
	    @Column(name = "PRICE")
	    private Long price;

	    @Column(name = "LATITUDE")
	    private Double latitude;

	    
	    @Column(name = "REGION", length = 50)
	    private String region;
	    
	    @Column(name = "ORG_NAME", length = 50)
		private String orgName;

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
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
			map.put("state", "asc");
			return map;
		}

		@Override
		public LinkedHashMap<String, Object> uniqueKeys() {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("modifiedBy", modifiedBy);
			return map;
		}

		
		

		

		
		

	
}
