import { EmployeeAddComponent } from "./../employee-add/employee-add.component";
import { EmployeeService } from "./../../service/employee.service";
import { Component, OnInit } from "@angular/core";
import { IEmployee } from "src/app/interface/employee";
import { MatDialog } from "@angular/material";
import { EmployeeDeleteComponent } from "../employee-delete/employee-delete.component";
import { EmployeeEditComponent } from "../employee-edit/employee-edit.component";

@Component({
  selector: "app-employee-list",
  templateUrl: "./employee-list.component.html",
  styleUrls: ["./employee-list.component.scss"],
})
export class EmployeeListComponent implements OnInit {
  employeeList: IEmployee[] = [];
  term: string;
  p: number = 1;

  constructor(
    private employeeService: EmployeeService,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    this.employeeService.getListEmployee().subscribe(
      (data) => {
        this.employeeList = data;
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
    const dialogRef = this.dialog.open(EmployeeAddComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }

  openDelete(employee) {
    const dialogRef = this.dialog.open(EmployeeDeleteComponent, {
      disableClose: true,
      width: "500px",

      data: { data1: employee },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel")
        this.employeeList = this.employeeList.filter(
          (t) => t.id != employee.id
        );
    });
  }

  openEdit(employee) {
    const dialogRef = this.dialog.open(EmployeeEditComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
      data: {
        dataEmployee: employee,
      },
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }
}
