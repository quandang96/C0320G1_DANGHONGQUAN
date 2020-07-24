import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { IContract } from "../interface/contract";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class ContractService {
  constructor(private httpClient: HttpClient) {}
  private readonly API_URL = "http://localhost:3000/contract";

  getListContract(): Observable<IContract[]> {
    return this.httpClient.get<IContract[]>(this.API_URL);
  }

  createContract(contract: IContract): Observable<IContract> {
    return this.httpClient.post<IContract>(this.API_URL, contract);
  }

  updateContract(contract: IContract): Observable<IContract> {
    return this.httpClient.put<IContract>(
      this.API_URL + `/${contract.id}`,
      contract
    );
  }

  deleteContract(contract: IContract): Observable<any> {
    return this.httpClient.delete(this.API_URL + `/${contract.id}`);
  }
}
