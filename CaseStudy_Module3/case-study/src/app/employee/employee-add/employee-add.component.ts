import { MAT_DIALOG_DATA } from "@angular/material";
import { MatDialogRef } from "@angular/material/dialog";
import { Component, OnInit, Inject } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { DatePipe } from "@angular/common";
import { IEmployee } from "src/app/interface/employee";
import { EmployeeService } from "src/app/service/employee.service";

@Component({
  selector: "app-employee-add",
  templateUrl: "./employee-add.component.html",
  styleUrls: ["./employee-add.component.scss"],
})
export class EmployeeAddComponent implements OnInit {
  employeeForm: FormGroup;
  constructor(
    private employeeService: EmployeeService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<EmployeeAddComponent>
  ) {}

  ngOnInit() {
    this.employeeForm = this.fb.group({
      code: ["", [Validators.required, Validators.pattern(/^NV-\d{4}$/)]],
      name: [
        "",
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(20),
        ],
      ],
      idCard: ["", [Validators.required, Validators.pattern(/^\d{9}$/)]],
      phone: [
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
      salary: ["", [Validators.required, Validators.min(0)]],
      edu_bg: ["", Validators.required],
      position: ["", Validators.required],
    });
  }

  onSubmit() {
    let employee = this.employeeForm.value as IEmployee;
    let datePipe = new DatePipe("en-US");
    employee.birthday = datePipe.transform(employee.birthday, "MM/dd/yyyy");

    this.employeeService.createEmployee(employee).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
