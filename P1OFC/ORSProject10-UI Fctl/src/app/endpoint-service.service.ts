import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EndpointServiceService {

  constructor() { }

  public SERVER_URL = "http://localhost:8084";
  public MESSAGE = this.SERVER_URL + "/Message";
  public USER = this.SERVER_URL + "/User";
  public ROLE = this.SERVER_URL + "/Role";
  public COLLEGE = this.SERVER_URL + "/College";
  public MARKSHEET = this.SERVER_URL + "/Marksheet";
  public STUDENT = this.SERVER_URL + "/Student";
  public SUBJECT = this.SERVER_URL+ "/Subject";
  public FACULTY = this.SERVER_URL+ "/Faculty";
  public COURSE = this.SERVER_URL + "/Course";
  public TIMETABLE = this.SERVER_URL+ "/TimeTable";
  public JASPERREPORT = this.SERVER_URL+ "/Jasper";
 
  public ASSET = this.SERVER_URL + "/Asset";
  public DEPARTMENT = this.SERVER_URL + "/Department";
  public ITEMINFORMATION = this.SERVER_URL + "/Iteminformation";
  public STOCKANALYSIS = this.SERVER_URL + "/StockAnalysis";
  public CUSTOMER = this.SERVER_URL + "/Customer";
  public ABC = this.SERVER_URL + "/Abc";
  public RIYA = this.SERVER_URL + "/Riya";
  public PORTFOLIO = this.SERVER_URL + "/Portfolio";
  public REGION = this.SERVER_URL + "/Region";
  public FOLLOWUP = this.SERVER_URL + "/FollowUp";
  public CLIENT = this.SERVER_URL + "/Client";
  public XYZ = this.SERVER_URL + "/Xyz";



}
