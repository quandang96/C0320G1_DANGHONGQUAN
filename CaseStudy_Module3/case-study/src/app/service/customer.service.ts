import { Injectable } from "@angular/core";
import { ICustomer } from "../interface/customer";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CustomerService {
  customer: ICustomer[] = [];
  constructor(private httpClient: HttpClient) {}
  private readonly API_URL = "http://localhost:3000/customers";

  getListCustomer(): Observable<ICustomer[]> {
    return this.httpClient.get<ICustomer[]>(this.API_URL);
  }

  createCustomer(customer: ICustomer): Observable<ICustomer> {
    return this.httpClient.post<ICustomer>(this.API_URL, customer);
  }

  updateCustomer(customer: ICustomer): Observable<ICustomer> {
    return this.httpClient.put<ICustomer>(
      this.API_URL + `/${customer.id}`,
      customer
    );
  }

  deleteCustomer(customer: ICustomer): Observable<any> {
    return this.httpClient.delete(this.API_URL + `/${customer.id}`);
  }
}
