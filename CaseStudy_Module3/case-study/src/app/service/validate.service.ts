import { CustomerService } from "./customer.service";
import { Injectable } from "@angular/core";
import {
  ValidationErrors,
  AbstractControl,
  AsyncValidator,
} from "@angular/forms";
import { differenceInDays, differenceInYears } from "date-fns";
import { map, catchError } from "rxjs/operators";
import { of, Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class ValidateService {
  constructor(private customerService: CustomerService) {}

  validate(control: AbstractControl): Observable<ValidationErrors> | null {
    return this.customerService.getListCustomer().pipe(
      map((code) => {
        return code.find((t) => t.code == control.value)
          ? { invalidCode: true }
          : null;
      }),
      catchError(() => of(null))
    );
  }

  static checkDate(c: AbstractControl): ValidationErrors | null {
    const v = c.value;
    const d1 = new Date(v.dateStart);
    const d2 = new Date(v.dateEnd);
    const day = differenceInDays(d2, d1);
    return day > 0 ? null : { invalidDate: true };
  }

  static checkAge(date: AbstractControl): ValidationErrors | null {
    const y = differenceInYears(new Date(), new Date(date.value));
    return y < 18 ? { age: true } : null;
  }
}
