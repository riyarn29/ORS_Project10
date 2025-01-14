package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CustomerDTO;

public class CustomerForm extends BaseForm {

    @NotEmpty(message = "Please enter name")
    private String name;

    
   @PastOrPresent(message = "startDate must be today or in the past")
    @NotNull(message = "Please enter startDate")
    private Date startDate;

  
    @NotEmpty(message = "Please select Analysis Type")
    private String analysisType;

    
    @NotNull(message = "Please enter amount")
 
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



	public String getAnalysisType() {
		return analysisType;
	}



	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	@Override
    public BaseDTO getDto() {
        CustomerDTO dto = initDTO(new CustomerDTO());
        dto.setAnalysisType(analysisType);
        dto.setStartDate(startDate);
        dto.setAmount(amount);
        dto.setName(name);;
        return dto;
    }
}
