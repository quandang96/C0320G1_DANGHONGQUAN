import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { EmployeeRoutingModule } from "./employee-routing.module";
import { EmployeeListComponent } from "./employee-list/employee-list.component";
import { EmployeeAddComponent } from "./employee-add/employee-add.component";
import { EmployeeDeleteComponent } from "./employee-delete/employee-delete.component";
import { EmployeeEditComponent } from "./employee-edit/employee-edit.component";
import { MaterialModule } from "../material/material.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPaginationModule } from "ngx-pagination";
import { MatNativeDateModule, MatInputModule } from "@angular/material";

@NgModule({
  declarations: [
    EmployeeListComponent,
    EmployeeAddComponent,
    EmployeeDeleteComponent,
    EmployeeEditComponent,
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    MaterialModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatInputModule,
  ],
  entryComponents: [
    EmployeeAddComponent,
    EmployeeDeleteComponent,
    EmployeeEditComponent,
  ],
})
export class EmployeeModule {}
