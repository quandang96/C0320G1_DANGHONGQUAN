import { Component, OnInit, Inject } from "@angular/core";
import { DatePipe } from "@angular/common";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ICustomer } from "src/app/interface/customer";
import { IEmployee } from "src/app/interface/employee";
import { IService } from "src/app/interface/service";
import { ContractService } from "src/app/service/contract.service";
import { FacilityService } from "src/app/service/facility.service";
import { CustomerService } from "src/app/service/customer.service";
import { EmployeeService } from "src/app/service/employee.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { ValidateService } from "src/app/service/validate.service";
import { differenceInDays, isThisSecond } from "date-fns";

@Component({
  selector: "app-contract-edit",
  templateUrl: "./contract-edit.component.html",
  styleUrls: ["./contract-edit.component.scss"],
})
export class ContractEditComponent implements OnInit {
  contractEditForm: FormGroup;
  customers: ICustomer[];
  employees: IEmployee[];
  facilities: IService[];

  piceService: number = 0;
  priceDate: number = 0;
  datePipe = new DatePipe("en-US");
  // new Data
  newData: any;
  startDate: any;
  endDate: any;

  constructor(
    private contractService: ContractService,
    private facilityService: FacilityService,
    private customerService: CustomerService,
    private employeeService: EmployeeService,
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<ContractEditComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any
  ) {}

  ngOnInit() {
    this.customerService.getListCustomer().subscribe((value) => {
      this.customers = value;
      this.facilityService.getListService().subscribe((value) => {
        this.facilities = value;
        this.employeeService.getListEmployee().subscribe((value) => {
          this.employees = value;
        });
      });
    });
    //--------------------------------------------------------------------------
    this.contractEditForm = this.fb.group({
      id: [Number],
      code: ["", [Validators.required, Validators.pattern(/^HD-\d{4}$/)]],

      service: [null],

      date: this.fb.group(
        {
          dateStart: ["", [Validators.required]],
          dateEnd: ["", [Validators.required]],
        },
        { validators: [ValidateService.checkDate] }
      ),

      employee: [""],

      customer: [""],

      deposit: ["", [Validators.required]],
      total: ["", Validators.required],
    });

    this.newData = this.clone(this.data.dataContract);
    this.newData.date.dateStart = this.datePipe.transform(
      this.newData.date.dateStart,
      "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    );
    this.newData.date.dateEnd = this.datePipe.transform(
      this.newData.date.dateEnd,
      "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    );
    this.contractEditForm.setValue(this.newData);
    //--------------------------------------------------------------------
  }

  onSubmit() {
    let contract = this.contractEditForm.value;
    contract.date.dateStart = this.datePipe.transform(
      contract.date.dateStart,
      "MM/dd/yyyy"
    );
    contract.date.dateEnd = this.datePipe.transform(
      contract.date.dateEnd,
      "MM/dd/yyyy"
    );

    this.contractService.updateContract(contract).subscribe(() => {
      this.dialogRef.close();
    });
  }
  compareByID(itemOne, itemTwo) {
    return itemOne && itemTwo && itemOne.id == itemTwo.id;
  }
  onChangeService(service: IService) {
    this.piceService = service.price;
    this.contractEditForm.patchValue({
      total: this.piceService + this.priceDate,
    });
  }

  onChangeStartDate(startDate) {
    this.startDate = startDate;
    this.endDate = this.contractEditForm.value.date.dateEnd;
    this.startDate = this.datePipe.transform(this.startDate, "MM/dd/yyyy");
    console.log(this.startDate);
    if (this.endDate != null) {
      this.priceDate =
        differenceInDays(new Date(this.endDate), new Date(this.startDate)) *
        200;
      this.contractEditForm.patchValue({
        total: this.piceService + this.priceDate,
      });
    }
  }

  onChangeEndDate(endDate) {
    this.endDate = endDate;
    this.startDate = this.contractEditForm.value.date.dateStart;
    this.endDate = this.datePipe.transform(this.endDate, "MM/dd/yyyy");
    if (this.endDate != null) {
      this.priceDate =
        differenceInDays(new Date(this.endDate), new Date(this.startDate)) *
        200;

      this.contractEditForm.patchValue({
        total: this.piceService + this.priceDate,
      });
    }
  }

  private clone(oldData): any {
    return {
      id: oldData.id,
      code: oldData.code,
      service: oldData.service,
      date: {
        dateStart: oldData.date.dateStart,
        dateEnd: oldData.date.dateEnd,
      },
      employee: oldData.employee,
      customer: oldData.customer,
      deposit: oldData.deposit,
      total: oldData.total,
    };
  }
}
