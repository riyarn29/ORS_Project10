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
import com.rays.dto.CartOverviewDTO;

public class CartOverviewForm extends BaseForm {
	
	@NotEmpty(message = "Please enter Customer Name")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only alphabets are allowed")
	private String customerName;


    
   @PastOrPresent(message = "Transaction Date must be today or in the past")
    @NotNull(message = "Please enter Transaction Date")
    private Date transactionDate;

  
    @NotEmpty(message = "Please select product")
    private String product;

    
    @NotNull(message = "Please enter quantity")
    @Min(value = 1, message = " quantity should be more than 1")
    @Max(value = 99999999, message = " quantity should have max 8 digits")
    private Integer quantity;
    
   

	


	





	public String getCustomerName() {
		return customerName;
	}












	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}












	public Date getTransactionDate() {
		return transactionDate;
	}












	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}












	public String getProduct() {
		return product;
	}












	public void setProduct(String product) {
		this.product = product;
	}












	public Integer getQuantity() {
		return quantity;
	}












	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}












	@Override
    public BaseDTO getDto() {
        CartOverviewDTO dto = initDTO(new CartOverviewDTO());
        dto.setProduct(product);
        dto.setTransactionDate(transactionDate);
        dto.setQuantity(quantity);
        dto.setCustomerName(customerName);
        return dto;
    }
}
