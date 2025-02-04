import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-portfoliolist',
  templateUrl: './portfoliolist.component.html',
  styleUrls: ['./portfoliolist.component.css']
})
export class PortfoliolistComponent extends BaseListCtl implements OnInit {

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
  isValidStartDate: boolean = true;
  startDateErrorMessage: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {

    super(locator.endpoints.PORTFOLIO, locator, route);
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

  

  validateInput(event: any, field: string): void {
    const value = event.target.value;

    // For the "name" field validation
    if (field === 'name') {
      // Restrict input to alphabets and spaces only
      if (/[^A-Za-z\s]/.test(value)) {
        // Replace non-alphabetic characters
        event.target.value = value.replace(/[^A-Za-z\s]/g, ''); 
        this.nameErrorMessage = 'Please type alphabets only';
        this.isValidNameInput = false;
      } 
      // Restrict input to a maximum length of 15 characters
      else if (value.length > 15) {
        // Trim the input to 15 characters
        event.target.value = value.substring(0, 15); 
        this.nameErrorMessage = 'Name cannot exceed 15 characters';
        this.isValidNameInput = false;
      } else {
        // Clear error message if input is valid
        this.nameErrorMessage = '';
        this.isValidNameInput = true;
      }
    }
  
  }
  
  

  validateDate(event: any) {
    const selectedDate = new Date(event.target.value);
    const today = new Date();
    today.setHours(0, 0, 0, 0); // Set today's time to midnight to compare only the date

    if (selectedDate > today) {
      // If selected date is in the future
      this.startDateErrorMessage = 'Please enter a past date';
      this.isValidStartDate = false;
    } else {
      // If selected date is valid (past or today)
      this.startDateErrorMessage = ''; // Clear error message
      this.isValidStartDate = true;
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