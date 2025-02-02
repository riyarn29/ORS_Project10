import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-region',
  templateUrl: './region.component.html',
  styleUrls: ['./region.component.css']
})
export class RegionComponent extends BaseCtl {
  errorMessageTitle: string = '';
  errorMessageName: string = '';
  errorMessageDouble: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.REGION, locator, route);
  }

  validateForm(form): boolean {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.state);
    flag = flag && validator.isNotNullObject(form.region);
    flag = flag && validator.isNotNullObject(form.price);
    flag = flag && validator.isNotNullObject(form.latitude);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.latitude = data.latitude;
    form.price = data.price;
    form.region = data.region;
    form.state = data.state;
  }

  // validateName(event: KeyboardEvent): void {
  //   const inputValue = (event.target as HTMLInputElement).value;
  //   const inputChar = event.key;
  //   const alphabetPattern = /^[a-zA-Z]*$/;  // Pattern to match only alphabetic characters

  //   if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
  //     event.preventDefault();
  //     this.errorMessageName = 'Only alphabets are allowed.';
  //     return;
  //   }

  //   if (inputValue.length < 1) {
  //     this.errorMessageName = 'Name must be at least  characters long.';
  //   } else if (inputValue.length > 15) {
  //     this.errorMessageName = 'Name must not exceed 15 characters.';
  //   } else {
  //     this.errorMessageName = '';  // Clear error message if valid
  //   }
  // }


  validateName(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const alphabetPattern = /^[a-zA-Z]*$/;  // Pattern to match only alphabetic characters
  
    if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageName = 'Only alphabets are allowed.';
      return;
    }
  
    if (inputValue.length > 15) {
      this.errorMessageName = 'State must not exceed 15 characters.';
    } else {
      this.errorMessageName = '';  // Clear error message if valid
    }
  }


  validateDouble(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    
    // Regex to match numbers with at most one decimal point
    const doublePattern = /^[0-9]*\.?[0-9]*$/;
  
    // Prevent multiple decimal points
    if (inputChar === '.' && inputValue.includes('.')) {
      event.preventDefault();
      this.errorMessageDouble = 'Only one decimal point is allowed.';
      return;
    }
  
    // Allow digits and one decimal point
    if (!doublePattern.test(inputValue + inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageDouble = 'Only numeric values with one decimal point are allowed.';
      return;
    }
  
    // Check if input exceeds max length (8 characters)
    if (inputValue.length >= 8 && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageDouble = 'Input cannot exceed 8 characters.';
      return;
    }
  
    // Clear error message if valid
    this.errorMessageDouble = '';
  }
  

  // New method to validate before saving
  validateBeforeSave(): boolean {
    if (this.errorMessageName) {
      // If there's any error message, don't proceed with saving
      return false;
    }

    if(this.errorMessageDouble){
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