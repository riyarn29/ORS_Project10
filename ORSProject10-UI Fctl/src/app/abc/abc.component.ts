import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-abc',
  templateUrl: './abc.component.html',
  styleUrls: ['./abc.component.css']
})
export class AbcComponent extends BaseCtl {
  errorMessageTitle: string = '';
  errorMessageName: string = '';
  errorMessageOverview: string = '';
  errorMessageDecimal:string='';
  errorMsgInt:string='';
  errorMessageDecimal1:string='';


  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.XYZ, locator, route);
  }

  validateForm(form): boolean {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.analysisType);
    flag = flag && validator.isNotNullObject(form.endDate);
    flag = flag && validator.isNotNullObject(form.quantity);
    flag = flag && validator.isNotNullObject(form.latitude);
    flag = flag && validator.isNotNullObject(form.longitude);
    flag = flag && validator.isNotNullObject(form.overview);
    flag = flag && validator.isNotNullObject(form.startDate);
    flag = flag && validator.isNotNullObject(form.coverageAmount);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.analysisType = data.analysisType;
    form.startDate = data.startDate;
    form.endDate = data.endDate;
    form.quantity = data.quantity;
    form.latitude = data.latitude;
    form.longitude = data.longitude;
    form.overview = data.overview;
    form.coverageAmount = data.coverageAmount;
    
  }

  validateName(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const alphabetPattern = /^[a-zA-Z]*$/;  // Pattern to match only alphabetic characters

    if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageName = 'Only alphabets are allowed.';
      return;
    }

    if (inputValue.length < 3) {
      this.errorMessageName = 'Name must be at least 3 characters long.';
    } else if (inputValue.length > 15) {
      this.errorMessageName = 'Name must not exceed 15 characters.';
    } else {
      this.errorMessageName = '';  // Clear error message if valid
    }
  }

  validateIntegerInput(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const integerPattern = /^[0-9]*$/;  // Pattern to match only integer numbers
  
    // Allow Backspace, Delete, and Tab keys
    if (!['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      if (!integerPattern.test(inputChar)) {
        event.preventDefault();
        this.errorMsgInt = 'Only integers are allowed.';
        return;
      }
    }
  
    // Check the length of the input value
    if (inputValue.length < 3) {
      this.errorMsgInt = 'Input must be at least 3 digits long.';
    } else if (inputValue.length > 8) {
      this.errorMsgInt = 'Input must not exceed 8 digits.';
    } else {
      this.errorMsgInt = '';  // Clear error message if valid
    }
  }
  


  validateOverview(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const alphabetPattern = /^[a-zA-Z]*$/;  // Pattern to match only alphabetic characters

    if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageOverview = 'Only alphabets are allowed.';
      return;
    }

    if (inputValue.length < 10) {
      this.errorMessageOverview = 'Overview must be at least 10 characters long.';
    } else if (inputValue.length > 100) {
      this.errorMessageOverview = 'Overview must not exceed 100 characters.';
    } else {
      this.errorMessageOverview = '';  // Clear error message if valid
    }
  }

  validatePositiveDecimalInput(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLTextAreaElement).value;
    const inputChar = event.key;
    const positiveDecimalPattern = /^\d*\.?\d*$/;  // Pattern to allow positive decimals (e.g., 123.45)
  
    // Allow Backspace, Delete, and Tab keys
    if (!['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      // Check if the input value already has a decimal point and prevent another one
      if (inputChar === '.' && inputValue.includes('.')) {
        event.preventDefault();
        this.errorMessageDecimal = 'Only one decimal point is allowed.';
        return;
      }
  
      // Check if the input value matches the positive decimal pattern (numbers and optional decimal point)
      if (!positiveDecimalPattern.test(inputValue + inputChar)) {
        event.preventDefault();
        this.errorMessageDecimal = 'Only valid positive decimal numbers are allowed.';
        return;
      }
  
    
    }
  
    // Check the length of the input value
    if (inputValue.length > 10) {
      this.errorMessageDecimal = 'Input must not exceed 10 characters.';
    } else {
      this.errorMessageDecimal = '';  // Clear error message if valid
    }
  }
  
  validatePositiveDecimalInput1(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLTextAreaElement).value;
    const inputChar = event.key;
    const positiveDecimalPattern = /^\d*\.?\d*$/;  // Pattern to allow positive decimals (e.g., 123.45)
  
    // Allow Backspace, Delete, and Tab keys
    if (!['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      // Check if the input value already has a decimal point and prevent another one
      if (inputChar === '.' && inputValue.includes('.')) {
        event.preventDefault();
        this.errorMessageDecimal1 = 'Only one decimal point is allowed.';
        return;
      }
  
      // Check if the input value matches the positive decimal pattern (numbers and optional decimal point)
      if (!positiveDecimalPattern.test(inputValue + inputChar)) {
        event.preventDefault();
        this.errorMessageDecimal1 = 'Only valid positive decimal numbers are allowed.';
        return;
      }
  
    
    }
  
    // Check the length of the input value
    if (inputValue.length > 10) {
      this.errorMessageDecimal1 = 'Input must not exceed 10 characters.';
    } else {
      this.errorMessageDecimal1 = '';  // Clear error message if valid
    }
  }
  

  // New method to validate before saving
  validateBeforeSave(): boolean {
    if (this.errorMessageName) {
      // If there's any error message, don't proceed with saving
      return false;
    }

    if(this.errorMessageOverview){
      return false;
    }

    if(this.errorMessageDecimal){
      return false;
    }

    if(this.errorMessageDecimal1){
      return false;
    }
    if(this.errorMsgInt){
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