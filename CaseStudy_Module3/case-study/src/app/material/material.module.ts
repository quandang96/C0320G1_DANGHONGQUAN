import { ServiceDeleteComponent } from "./../services/service-delete/service-delete.component";
import { CustomerEditComponent } from "./../customer/customer-edit/customer-edit.component";
import { CustomerDeleteComponent } from "./../customer/customer-delete/customer-delete.component";
import { MatDialogModule } from "@angular/material/dialog";
import { CustomerAddComponent } from "./../customer/customer-add/customer-add.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { MatFormFieldModule, MatInputModule } from "@angular/material";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { EmployeeAddComponent } from "../employee/employee-add/employee-add.component";
import { EmployeeDeleteComponent } from "../employee/employee-delete/employee-delete.component";
import { EmployeeEditComponent } from "../employee/employee-edit/employee-edit.component";
import { ServiceAddComponent } from "../services/service-add/service-add.component";
import { ServiceEditComponent } from "../services/service-edit/service-edit.component";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
  ],
  exports: [
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule,
  ],
  entryComponents: [],
})
export class MaterialModule {}
