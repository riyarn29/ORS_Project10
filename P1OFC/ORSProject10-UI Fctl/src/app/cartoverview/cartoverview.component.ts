import { Component, OnInit } from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cartoverview',
  templateUrl: './cartoverview.component.html',
  styleUrls: ['./cartoverview.component.css']
})
export class CartoverviewComponent extends BaseCtl {


  errorMessageTitle: string = '';
  errorMessageName: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.CART, locator, route);
  }

  validateForm(form): boolean {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.customerName);
    flag = flag && validator.isNotNullObject(form.product);
    flag = flag && validator.isNotNullObject(form.transactionDate);
    flag = flag && validator.isNotNullObject(form.quantity);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.customerName = data.customerName;
    form.product = data.product;
    form.transactionDate = data.transactionDate;
    form.quantity = data.quantity;
  }

  


  validateName(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const alphabetPattern = /^[a-zA-Z\s]*$/;
  
    if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageName = 'Only alphabets are allowed.';
      return;
    }
  
    if (inputValue.length > 20) {
      this.errorMessageName = 'Customer Name must not exceed 20 characters.';
    } else {
      this.errorMessageName = '';  // Clear error message if valid
    }
  }
  

  
  validateBeforeSave(): boolean {
    if (this.errorMessageName) {
      // If there's any error message, don't proceed with saving
      return false;
    }

    // Add other field validations if needed

    // Validate form data
    if (!this.validateForm(this.form.data)) {
      return false;
    }

    return true;
  }

  // Save method that checks validation
  saveForm(): void {
    if (this.validateBeforeSave()) {
      console.log('Form data is valid. Saving data...');
      // Perform the actual save operation
    } else {
      console.log('Validation failed. Form not saved.');
    }
  }
}