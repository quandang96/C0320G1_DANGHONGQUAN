import { CustomerService } from "src/app/service/customer.service";
import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";

@Component({
  selector: "app-customer-delete",
  templateUrl: "./customer-delete.component.html",
  styleUrls: ["./customer-delete.component.scss"],
})
export class CustomerDeleteComponent implements OnInit {
  name: String;
  constructor(
    private customerService: CustomerService,
    public dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    this.name = this.data.data1.name;
  }
  onDelete() {
    this.customerService.deleteCustomer(this.data.data1).subscribe((data) => {
      this.dialogRef.close();
    });
  }
}
