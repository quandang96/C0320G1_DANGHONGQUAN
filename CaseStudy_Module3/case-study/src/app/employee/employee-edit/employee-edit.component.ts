import { Component, OnInit, Inject } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { EmployeeService } from "src/app/service/employee.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";
import { EmployeeAddComponent } from "../employee-add/employee-add.component";
import { IEmployee } from "src/app/interface/employee";
import { DatePipe } from "@angular/common";

@Component({
  selector: "app-employee-edit",
  templateUrl: "./employee-edit.component.html",
  styleUrls: ["./employee-edit.component.scss"],
})
export class EmployeeEditComponent implements OnInit {
  employeeEditForm: FormGroup;

  constructor(
    private employeeService: EmployeeService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<EmployeeAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    this.employeeEditForm = this.fb.group({
      id: [Number],
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

    this.employeeEditForm.patchValue(this.data.dataEmployee);
  }

  onSubmit() {
    let employee = this.employeeEditForm.value as IEmployee;
    let datePipe = new DatePipe("en-US");
    employee.birthday = datePipe.transform(employee.birthday, "MM/dd/yyyy");

    this.employeeService.updateEmployee(employee).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
