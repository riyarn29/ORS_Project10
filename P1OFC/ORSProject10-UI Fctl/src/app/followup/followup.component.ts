import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-followup',
  templateUrl: './followup.component.html',
  styleUrls: ['./followup.component.css']
})
export class FollowupComponent extends BaseCtl {
  errorMessageTitle: string = '';
  errorMessageName: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.FOLLOWUP, locator, route);
  }


  
  validateForm(form): boolean {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.client);
    flag = flag && validator.isNotNullObject(form.physician);
    flag = flag && validator.isNotNullObject(form.appointmentDate);
    flag = flag && validator.isNotNullObject(form.charges);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.charges = data.charges;
    form.appointmentDate = data.appointmentDate;
    form.physician = data.physician;
    form.client = data.client;
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
      this.errorMessageName = 'Name must not exceed 15 characters.';
    } else {
      this.errorMessageName = '';  // Clear error message if valid
    }
  }
  

  // New method to validate before saving
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