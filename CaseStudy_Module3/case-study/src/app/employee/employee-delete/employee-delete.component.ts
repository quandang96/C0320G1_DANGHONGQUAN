import { Component, OnInit, Inject } from "@angular/core";
import { EmployeeService } from "src/app/service/employee.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";

@Component({
  selector: "app-employee-delete",
  templateUrl: "./employee-delete.component.html",
  styleUrls: ["./employee-delete.component.scss"],
})
export class EmployeeDeleteComponent implements OnInit {
  name: String;
  constructor(
    private employeeService: EmployeeService,
    public dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    this.name = this.data.data1.name;
  }
  onDelete() {
    this.employeeService.deleteEmployee(this.data.data1).subscribe((data) => {
      this.dialogRef.close();
    });
  }
}
