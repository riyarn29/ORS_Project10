package com.rays.form;

import java.util.Date;
import javax.validation.constraints.*;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ABCDTO;

public class AbcForm extends BaseForm {

    @NotEmpty(message = "Please enter the name")
    @Size(max = 10, message = "Name must not exceed 10 characters")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Name can only contain alphabets and spaces")
    private String name;

    @NotEmpty(message = "Please enter the overview")
    @Size(max = 100, message = "Overview must not exceed 100 characters")
    private String overview;

    @PastOrPresent(message = "Start date must be today or in the past")
    @NotNull(message = "Please enter start date")
    private Date startDate;

    @NotNull(message = "Please enter end date")
    @FutureOrPresent(message = "End date must be today or in the future")
    private Date endDate;

    @NotEmpty(message = "Please select Analysis Type")
  
    private String analysisType;

    @NotNull(message = "Please enter coverage amount")
    @Min(value = 0, message = "Coverage amount must be a positive number")
    private Integer coverageAmount;
    
    @NotNull(message = "Please enter quantity")
    @Min(value = 1, message = "Quantity must be a positive number")
    private Integer quantity;
    
    @NotNull(message = "Please enter latitude")
    @DecimalMin(value = "0.0", message = "Latitude must be between 0.0 and 100.0")
    @DecimalMax(value = "100.0", message = "Latitude must be between 0.0 and 100.0")
    private Double latitude;
    
    @NotNull(message = "Please enter longitude")
    @DecimalMin(value = "0.0", message = "Longitude must be between 0.0 and 100.0")
    @DecimalMax(value = "100.0", message = "Longitude must be between 0.0 and 100.0")
    private Double longitude;

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

	public String getAnalysisType() {
		return analysisType;
	}

	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
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

	 @Override
	    public BaseDTO getDto() {
	        ABCDTO dto = initDTO(new ABCDTO());
	        dto.setName(name);
	        dto.setOverview(overview);
	        dto.setCoverageAmount(coverageAmount);
	        dto.setQuantity(quantity);
	        dto.setLatitude(latitude);
	        dto.setLongitude(longitude);
	        dto.setStartDate(startDate);
	        dto.setEndDate(endDate);
	        dto.setAnalysisType(analysisType);

	        return dto;
	    }
    
}
