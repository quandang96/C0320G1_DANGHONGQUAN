import { CustomerEditComponent } from "./customer-edit/customer-edit.component";
import { CustomerDeleteComponent } from "./customer-delete/customer-delete.component";
import { CustomerAddComponent } from "./customer-add/customer-add.component";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { CustomerRoutingModule } from "./customer-routing.module";
import { CustomerListComponent } from "./customer-list/customer-list.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPaginationModule } from "ngx-pagination";
import { MatNativeDateModule, MatInputModule } from "@angular/material";
import { MaterialModule } from "../material/material.module";

@NgModule({
  declarations: [
    CustomerAddComponent,
    CustomerDeleteComponent,
    CustomerEditComponent,
    CustomerListComponent,
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatInputModule,
    MaterialModule,
  ],
  entryComponents: [
    CustomerAddComponent,
    CustomerDeleteComponent,
    CustomerEditComponent,
  ],
})
export class CustomerModule {}
