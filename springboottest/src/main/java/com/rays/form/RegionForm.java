package com.rays.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RegionDTO;
import com.rays.validation.ValidDouble;

public class RegionForm extends BaseForm {

    @NotEmpty(message = "Please enter state")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only alphabets are allowed")
    private String state;


  
    @NotEmpty(message = "Please select region")
    private String region;

    
    @NotNull(message = "Please enter price")
    @Min(value = 10, message = "phone number must be 10 didgits")
 //  @Max(value = 999999999, message = " price should have max 9 digits")
    private Long price;
    
    
    
    @NotNull(message = "Please enter latitude")
    @Positive(message = "Latitude must be a positive value")
    @DecimalMin(value = "100.0", message = "Latitude must be greater than 100")
    @ValidDouble(message = "Latitude must be a double value (not an integer)")
    private Double latitude;



	


	public String getState() {
		return state;
	}






	public void setState(String state) {
		this.state = state;
	}






	public String getRegion() {
		return region;
	}






	public void setRegion(String region) {
		this.region = region;
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






	@Override
    public BaseDTO getDto() {
        RegionDTO dto = initDTO(new RegionDTO());
        dto.setState(state);
        dto.setRegion(region);
        dto.setPrice(price);
        dto.setLatitude(latitude);
        return dto;
    }
}
