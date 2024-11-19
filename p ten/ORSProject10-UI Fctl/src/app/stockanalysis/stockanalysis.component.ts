import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-stockanalysis',
  templateUrl: './stockanalysis.component.html',
  styleUrls: ['./stockanalysis.component.css']
})
export class StockanalysisComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.STOCKANALYSIS, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.stockSymbol);
    flag = flag && validator.isNotNullObject(form.analysisType);
    flag = flag && validator.isNotNullObject(form.startDate);
    flag = flag && validator.isNotNullObject(form.endDate);

    return flag;
  }
 
  populateForm(form, data) {
    form.id = data.id;
    form.stockSymbol = data.stockSymbol;
    form.analysisType = data.analysisType;
    form.startDate = data.startDate;
    form.endDate = data.endDate;
  }
}


