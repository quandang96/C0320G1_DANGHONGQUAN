import { CustomerModule } from "./customer/customer.module";
import { EmployeeModule } from "./employee/employee.module";
import { MaterialModule } from "./material/material.module";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPaginationModule } from "ngx-pagination";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { CustomerAddComponent } from "./customer/customer-add/customer-add.component";
import { CustomerListComponent } from "./customer/customer-list/customer-list.component";
import { EmployeeListComponent } from "./employee/employee-list/employee-list.component";
import { EmployeeAddComponent } from "./employee/employee-add/employee-add.component";
import { ServiceListComponent } from "./services/service-list/service-list.component";
import { ServiceAddComponent } from "./services/service-add/service-add.component";
import { ContractAddComponent } from "./contract/contract-add/contract-add.component";
import { AttachServiceComponent } from "./attach-service/attach-service.component";
import { ServiceRegisterComponent } from "./services/service-register/service-register.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { CustomerDeleteComponent } from "./customer/customer-delete/customer-delete.component";
import { CustomerEditComponent } from "./customer/customer-edit/customer-edit.component";
import { MatNativeDateModule, MatInputModule } from "@angular/material";
import { EmployeeDeleteComponent } from "./employee/employee-delete/employee-delete.component";
import { EmployeeEditComponent } from "./employee/employee-edit/employee-edit.component";
import { ServiceDeleteComponent } from "./services/service-delete/service-delete.component";
import { ServiceEditComponent } from "./services/service-edit/service-edit.component";
import { ServicesModule } from "./services/services.module";
import { NotFoundComponent } from "./not-found/not-found.component";

@NgModule({
  declarations: [
    AppComponent,
    ContractAddComponent,
    AttachServiceComponent,
    ServiceRegisterComponent,
    DashboardComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    MaterialModule,
    MatNativeDateModule,
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
