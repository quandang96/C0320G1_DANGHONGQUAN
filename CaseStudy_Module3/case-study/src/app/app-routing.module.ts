import { DashboardComponent } from "./dashboard/dashboard.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule, PreloadAllModules } from "@angular/router";
import { NotFoundComponent } from "./not-found/not-found.component";

const routes: Routes = [
  {
    path: "",
    component: DashboardComponent,
    children: [
      {
        path: "customer",
        loadChildren: () =>
          import("./customer/customer.module").then((m) => m.CustomerModule),
      },
      {
        path: "employee",
        loadChildren: () =>
          import("./employee/employee.module").then((m) => m.EmployeeModule),
      },
      {
        path: "service",
        loadChildren: () =>
          import("./services/services.module").then((m) => m.ServicesModule),
      },
      {
        path: "contract",
        loadChildren: () =>
          import("./contract/contract.module").then((m) => m.ContractModule),
      },
    ],
  },

  {
    path: "**",
    component: NotFoundComponent,
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      preloadingStrategy: PreloadAllModules,
    }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
