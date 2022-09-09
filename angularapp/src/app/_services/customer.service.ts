import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from '../customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiServerUrl = environment.apiBaseUrl;
 

  constructor(private http: HttpClient) { }
  getUserproducts(): Observable<Object>{
    return this.http.get(`${this.apiServerUrl}/user/viewproducts`);
  }

  addcustomer(customer:Customer): Observable<Object>{
    return this.http.post(`${this.apiServerUrl}/user/addCustomer`,customer);
  }
}
