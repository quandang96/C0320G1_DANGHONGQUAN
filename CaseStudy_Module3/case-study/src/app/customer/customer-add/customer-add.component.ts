import { Component, OnInit, Inject } from "@angular/core";
import { CustomerService } from "src/app/service/customer.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ICustomer } from "src/app/interface/customer";
import { MatDialogRef } from "@angular/material/dialog";
import { DatePipe } from "@angular/common";

@Component({
  selector: "app-customer-add",
  templateUrl: "./customer-add.component.html",
  styleUrls: ["./customer-add.component.scss"],
})
export class CustomerAddComponent implements OnInit {
  customerForm: FormGroup;

  constructor(
    private customerService: CustomerService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<CustomerAddComponent>
  ) {}

  ngOnInit() {
    this.customerForm = this.fb.group({
      code: ["", [Validators.required, Validators.pattern(/^KH-\d{4}$/)]],
      name: [
        "",
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(20),
        ],
      ],
      idCard: ["", [Validators.required, Validators.pattern(/^\d{9}$/)]],
      phoneNumber: [
        "",
        [
          Validators.required,
          Validators.pattern(
            /^(090|091|([\\(]84[\\)][\\+]90)|([\\(]84[\\)][\\+]91))[0-9]{7}$/
          ),
        ],
      ],
      email: ["", [Validators.required, Validators.email]],
      birthday: ["", Validators.required],
      address: ["", [Validators.required, Validators.minLength(3)]],
      customerType: ["", Validators.required],
    });
  }

  onSubmit() {
    let customer = this.customerForm.value as ICustomer;
    let datePipe = new DatePipe("en-US");
    customer.birthday = datePipe.transform(customer.birthday, "MM/dd/yyyy");

    this.customerService.createCustomer(customer).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
