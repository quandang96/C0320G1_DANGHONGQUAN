import { Component, OnInit, Inject } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ICustomer } from "src/app/interface/customer";
import { CustomerService } from "src/app/service/customer.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { CustomerAddComponent } from "../customer-add/customer-add.component";
import { DatePipe } from "@angular/common";

@Component({
  selector: "app-customer-edit",
  templateUrl: "./customer-edit.component.html",
  styleUrls: ["./customer-edit.component.scss"],
})
export class CustomerEditComponent implements OnInit {
  customerEditForm: FormGroup;

  constructor(
    private customerService: CustomerService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<CustomerAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    this.customerEditForm = this.fb.group({
      id: [""],
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
      address: ["", Validators.required],
      customerType: ["", Validators.required],
    });

    this.customerEditForm.patchValue(this.data.dataCustomer);
  }

  onSubmit() {
    let customer = this.customerEditForm.value as ICustomer;
    let datePipe = new DatePipe("en-US");
    customer.birthday = datePipe.transform(customer.birthday, "dd/MM/yyyy");
    this.customerService.updateCustomer(customer).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
