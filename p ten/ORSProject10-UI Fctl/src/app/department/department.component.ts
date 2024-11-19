import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent extends BaseCtl {
  errorMessageTitle: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.DEPARTMENT, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.departmentName);
    flag = flag && validator.isNotNullObject(form.dateOfJoining);
    flag = flag && validator.isNotNullObject(form.amount);
    flag = flag && validator.isNotNullObject(form.lastEmployerName);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.departmentName = data.departmentName;
    form.dateOfJoining = data.dateOfJoining;
    form.amount = data.amount;
    form.lastEmployerName = data.lastEmployerName;

  }

}


