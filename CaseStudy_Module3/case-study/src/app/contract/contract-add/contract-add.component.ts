import { differenceInDays } from "date-fns";
import { ValidateService } from "./../../service/validate.service";
import { ICustomer } from "./../../interface/customer";
import { EmployeeService } from "./../../service/employee.service";
import { CustomerService } from "./../../service/customer.service";
import { FacilityService } from "src/app/service/facility.service";
import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ContractService } from "src/app/service/contract.service";
import { MatDialogRef, MatDatepickerInputEvent } from "@angular/material";
import { IContract } from "src/app/interface/contract";
import { DatePipe } from "@angular/common";
import { IEmployee } from "src/app/interface/employee";
import { IService } from "src/app/interface/service";

@Component({
  selector: "app-contract-add",
  templateUrl: "./contract-add.component.html",
  styleUrls: ["./contract-add.component.scss"],
})
export class ContractAddComponent implements OnInit {
  contractForm: FormGroup;
  customers: ICustomer[];
  employees: IEmployee[];
  facilities: IService[];
  totals: number = 0;
  piceService: number = 0;
  priceDate: number = 0;
  startDate: any;
  endDate: any;

  constructor(
    private contractService: ContractService,
    private facilityService: FacilityService,
    private customerService: CustomerService,
    private employeeService: EmployeeService,
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<ContractAddComponent>
  ) {}

  ngOnInit() {
    this.contractForm = this.fb.group({
      code: ["", [Validators.required, Validators.pattern(/^HD-\d{4}$/)]],
      service: ["", [Validators.required]],
      date: this.fb.group(
        {
          dateStart: ["", [Validators.required]],
          dateEnd: ["", [Validators.required]],
        },
        { validators: [ValidateService.checkDate] }
      ),
      employee: ["", [Validators.required]],
      customer: ["", [Validators.required]],
      deposit: [Number, [Validators.required]],
      total: [Number, Validators.required],
    });
    this.customerService
      .getListCustomer()
      .subscribe((data) => (this.customers = data));
    this.employeeService
      .getListEmployee()
      .subscribe((data) => (this.employees = data));
    this.facilityService
      .getListService()
      .subscribe((data) => (this.facilities = data));
  }

  onSubmit() {
    let contract = this.contractForm.value;
    contract.total = this.totals;
    let datePipe = new DatePipe("en-US");
    contract.date.dateStart = datePipe.transform(
      contract.date.dateStart,
      "MM/dd/yyyy"
    );
    contract.date.dateEnd = datePipe.transform(
      contract.date.dateEnd,
      "MM/dd/yyyy"
    );

    this.contractService.createContract(contract).subscribe(() => {
      this.dialogRef.close();
    });
  }

  onChangeService(service: IService) {
    this.piceService = service.price;
    this.totals = this.piceService + this.priceDate;
  }

  onChangeStartDate(startDate) {
    this.startDate = startDate;
    let datePipe = new DatePipe("en-US");
    this.startDate = datePipe.transform(this.startDate, "MM/dd/yyyy");

    if (this.endDate != null) {
      this.priceDate =
        differenceInDays(new Date(this.endDate), new Date(this.startDate)) *
        200;

      this.totals = this.piceService + this.priceDate;
    }
  }

  onChangeEndDate(endDate) {
    this.endDate = endDate;
    let datePipe = new DatePipe("en-US");
    this.endDate = datePipe.transform(this.endDate, "MM/dd/yyyy");

    if (this.endDate != null) {
      this.priceDate =
        differenceInDays(new Date(this.endDate), new Date(this.startDate)) *
        200;

      this.totals = this.piceService + this.priceDate;
    }
  }
}
