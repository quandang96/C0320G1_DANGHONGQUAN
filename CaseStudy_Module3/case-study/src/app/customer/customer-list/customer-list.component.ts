import { CustomerEditComponent } from "./../customer-edit/customer-edit.component";
import { CustomerDeleteComponent } from "./../customer-delete/customer-delete.component";
import { CustomerService } from "src/app/service/customer.service";
import { MatDialog } from "@angular/material";
import { ICustomer } from "./../../interface/customer";
import { Component, OnInit } from "@angular/core";
import { CustomerAddComponent } from "../customer-add/customer-add.component";

@Component({
  selector: "app-customer-list",
  templateUrl: "./customer-list.component.html",
  styleUrls: ["./customer-list.component.scss"],
})
export class CustomerListComponent implements OnInit {
  customerList: ICustomer[] = [];
  term: string;
  p: number = 1;

  constructor(
    private customerService: CustomerService,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    this.customerService.getListCustomer().subscribe(
      (data) => {
        this.customerList = data;
      },
      (error) => {
        console.log(error);
      },
      () => {
        console.log("complete");
      }
    );
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CustomerAddComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }

  openDelete(customer) {
    const dialogRef = this.dialog.open(CustomerDeleteComponent, {
      disableClose: true,
      width: "500px",

      data: { data1: customer },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel")
        this.customerList = this.customerList.filter(
          (t) => t.id != customer.id
        );
    });
  }

  openEdit(customer) {
    const dialogRef = this.dialog.open(CustomerEditComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",

      data: { dataCustomer: customer },
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }
}
