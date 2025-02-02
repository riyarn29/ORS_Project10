package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FollowUpDTO;

public class FollowUpForm extends BaseForm {

    @NotEmpty(message = "Please select client")
   // @Pattern(regexp = "^[a-zA-Z]*$", message = "Only alphabets are allowed")
    private String client;

    
   @PastOrPresent(message = "appointmentDate must be today or in the past")
    @NotNull(message = "Please enter appointmentDate")
    private Date appointmentDate;

  
    @NotEmpty(message = "Please select physician")
    private String physician;

    
    @NotNull(message = "Please enter charges")
    @Min(value = 100, message = " charges should be more than 100")
    @Max(value = 99999999, message = " charges should have max 8 digits")
    private Integer charges;
    
   

	


	





	public String getClient() {
		return client;
	}












	public void setClient(String client) {
		this.client = client;
	}












	public Date getAppointmentDate() {
		return appointmentDate;
	}












	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}












	public String getPhysician() {
		return physician;
	}












	public void setPhysician(String physician) {
		this.physician = physician;
	}












	public Integer getCharges() {
		return charges;
	}












	public void setCharges(Integer charges) {
		this.charges = charges;
	}












	@Override
    public BaseDTO getDto() {
        FollowUpDTO dto = initDTO(new FollowUpDTO());
        dto.setClient(client);
        dto.setAppointmentDate(appointmentDate);
        dto.setCharges(charges);
        dto.setPhysician(physician);
        return dto;
    }
}
