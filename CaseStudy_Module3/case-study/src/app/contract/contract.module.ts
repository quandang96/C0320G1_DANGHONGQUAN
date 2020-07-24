import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { ContractRoutingModule } from "./contract-routing.module";
import { ContractListComponent } from "./contract-list/contract-list.component";
import { ContractAddComponent } from "./contract-add/contract-add.component";
import { ContractEditComponent } from "./contract-edit/contract-edit.component";
import { ContractDeleteComponent } from "./contract-delete/contract-delete.component";
import { MaterialModule } from "../material/material.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPaginationModule } from "ngx-pagination";
import { MatNativeDateModule, MatInputModule } from "@angular/material";

@NgModule({
  declarations: [
    ContractListComponent,
    ContractAddComponent,
    ContractDeleteComponent,
    ContractEditComponent,
  ],
  imports: [
    CommonModule,
    ContractRoutingModule,
    MaterialModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatInputModule,
  ],
  entryComponents: [
    ContractAddComponent,
    ContractDeleteComponent,
    ContractEditComponent,
  ],
})
export class ContractModule {}
