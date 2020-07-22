import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { ServicesRoutingModule } from "./services-routing.module";
import { ServiceListComponent } from "./service-list/service-list.component";
import { ServiceAddComponent } from "./service-add/service-add.component";
import { ServiceDeleteComponent } from "./service-delete/service-delete.component";
import { ServiceEditComponent } from "./service-edit/service-edit.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPaginationModule } from "ngx-pagination";
import { MatNativeDateModule, MatInputModule } from "@angular/material";
import { MaterialModule } from "../material/material.module";

@NgModule({
  declarations: [
    ServiceListComponent,
    ServiceAddComponent,
    ServiceDeleteComponent,
    ServiceEditComponent,
  ],
  imports: [
    CommonModule,
    ServicesRoutingModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatInputModule,
    MaterialModule,
  ],
  entryComponents: [
    ServiceAddComponent,
    ServiceDeleteComponent,
    ServiceEditComponent,
  ],
})
export class ServicesModule {}
