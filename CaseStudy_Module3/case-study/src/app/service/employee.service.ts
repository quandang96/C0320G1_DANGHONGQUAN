import { Injectable } from "@angular/core";
import { IEmployee } from "../interface/employee";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class EmployeeService {
  constructor(private httpClient: HttpClient) {}
  private readonly API_URL = "http://localhost:3000/Staff";

  getListEmployee(): Observable<IEmployee[]> {
    return this.httpClient.get<IEmployee[]>(this.API_URL);
  }

  createEmployee(employee: IEmployee): Observable<IEmployee> {
    return this.httpClient.post<IEmployee>(this.API_URL, employee);
  }

  updateEmployee(employee: IEmployee): Observable<IEmployee> {
    return this.httpClient.put<IEmployee>(
      this.API_URL + `/${employee.id}`,
      employee
    );
  }

  deleteEmployee(employee: IEmployee): Observable<any> {
    return this.httpClient.delete(this.API_URL + `/${employee.id}`);
  }
}
