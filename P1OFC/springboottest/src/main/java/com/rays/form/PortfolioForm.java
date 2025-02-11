package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PortfolioDTO;

public class PortfolioForm extends BaseForm {
	@NotEmpty(message = "Please enter name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets are allowed")
	private String name;


    
   @PastOrPresent(message = "startDate must be today or in the past")
    @NotNull(message = "Please enter startDate")
    private Date startDate;

  
    @NotEmpty(message = "Please select level")
    private String level;

    
    @NotNull(message = "Please enter amount")
    @Min(value = 1000, message = " amount should be more than 1000")
    @Max(value = 99999999, message = " amount should have max 8 digits")
    private Integer amount;
    
   

	


	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public Date getStartDate() {
		return startDate;
	}






	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}






	public String getLevel() {
		return level;
	}






	public void setLevel(String level) {
		this.level = level;
	}






	public Integer getAmount() {
		return amount;
	}






	public void setAmount(Integer amount) {
		this.amount = amount;
	}






	@Override
    public BaseDTO getDto() {
        PortfolioDTO dto = initDTO(new PortfolioDTO());
        dto.setLevel(level);
        dto.setStartDate(startDate);
        dto.setAmount(amount);
        dto.setName(name);;
        return dto;
    }
}
