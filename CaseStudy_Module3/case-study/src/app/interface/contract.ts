import { ICustomer } from "./customer";
import { IEmployee } from "./employee";
import { IService } from "./service";
export interface IContract {
  id: number;
  code: String;
  service: IService;
  dateStart: string;
  dateEnd: string;
  employee: IEmployee;
  customer: ICustomer;
  deposit: number;
  total: number;
}
