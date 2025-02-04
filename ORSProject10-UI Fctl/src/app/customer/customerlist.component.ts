import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css']
})
export class CustomerlistComponent  extends BaseListCtl implements OnInit {

  public form = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: {

      name: '',
      mobile: '',
      date: '', // Initialize date field
      dateOfJoining: '',
      experienceId: ''
    },
    searchMessage: null,
    list: [],
    pageNo: 0
  };

  isValidMobileInput: boolean = true;
  isValidNameInput: boolean = true;
  nameErrorMessage: string = '';
  mobileErrorMessage: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.CUSTOMER, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }

  // Format date function
  formatDate(event: any) {
    const selectedDate = new Date(event);
    const formattedDate = selectedDate.toISOString().split('T')[0];
    this.form.searchParams.date = formattedDate;
  }

  

  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    // For the "name" field validation
    if (field === 'name') {
      // Restrict input to alphabets and spaces only
      if (/[^A-Za-z\s]/.test(value)) {
        event.target.value = value.replace(/[^A-Za-z\s]/g, ''); // Remove non-alphabetic characters
        this.nameErrorMessage = 'Please type alphabets and spaces only';
        this.isValidNameInput = false;
      } else if (value.length > 15) {
        // Restrict input to a maximum length of 15 characters
        event.target.value = value.substring(0, 15); // Trim the input to 15 characters
        this.nameErrorMessage = 'Name cannot exceed 15 characters';
        this.isValidNameInput = false;
      } else {
        // If input is valid, clear the error message
        this.nameErrorMessage = '';
        this.isValidNameInput = true;
      }
    
  
  }
  
  }
  


  // Submit method
  submit() {
    // Reset page number before searching
    this.form.pageNo = 0;
    // Call the search method after formatting the date
    this.search();
  }


  // Search method
  search() {
    // Clear previous search message
    this.form.searchMessage = null;
    // Perform the search operation with the search parameters
    super.search();
  }
}