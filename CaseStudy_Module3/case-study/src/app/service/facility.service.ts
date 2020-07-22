import { Injectable } from "@angular/core";
import { IService } from "../interface/service";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class FacilityService {
  constructor(private httpClient: HttpClient) {}
  private readonly API_URL = "http://localhost:3000/service";

  getListService(): Observable<IService[]> {
    return this.httpClient.get<IService[]>(this.API_URL);
  }

  createService(service: IService): Observable<IService> {
    return this.httpClient.post<IService>(this.API_URL, service);
  }

  updateService(service: IService): Observable<IService> {
    return this.httpClient.put<IService>(
      this.API_URL + `/${service.id}`,
      service
    );
  }

  deleteService(service: IService): Observable<any> {
    return this.httpClient.delete(this.API_URL + `/${service.id}`);
  }
}
