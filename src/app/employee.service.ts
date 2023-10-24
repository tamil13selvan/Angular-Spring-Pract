import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  [x: string]: any;

  private baseUrl = "http://localhost:8080/api/v1/";

  constructor(private HttpClient:HttpClient, private route: ActivatedRoute,
    private router: Router) { }
    getAllEmployees(): Observable<any>{
    return this.HttpClient.get(`${this.baseUrl}`+"employeesAll");
  }

  createEmployee(employee:Employee): Observable<Object>{
    return this.HttpClient.post(`${this.baseUrl}`+"save", employee);
  }

  getEmployeeById(id:number): Observable<object>{
    return this.HttpClient.post(`${this.baseUrl}`+"employees",id);
  }

  updateEmployee(id: number, employee: Employee): Observable<any>{
    console.log(employee)
    return this.HttpClient.put(`${this.baseUrl}` + "employees" + `/${id}`, employee);
  }

  deleteEmployee(id:number):Observable<Object>{
    return this.HttpClient.delete(`${this.baseUrl}`+ `/${id}`);
  }
} 
