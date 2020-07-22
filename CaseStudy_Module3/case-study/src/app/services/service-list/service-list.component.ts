import { FacilityService } from "./../../service/facility.service";
import { Component, OnInit } from "@angular/core";
import { IService } from "src/app/interface/service";
import { MatDialog } from "@angular/material";
import { ServiceAddComponent } from "../service-add/service-add.component";
import { ServiceDeleteComponent } from "../service-delete/service-delete.component";
import { ServiceEditComponent } from "../service-edit/service-edit.component";

@Component({
  selector: "app-service-list",
  templateUrl: "./service-list.component.html",
  styleUrls: ["./service-list.component.scss"],
})
export class ServiceListComponent implements OnInit {
  serviceList: IService[] = [];
  term: string;
  p: number = 1;

  constructor(
    private facilityService: FacilityService,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    this.facilityService.getListService().subscribe(
      (data) => {
        this.serviceList = data;
      },
      (error) => {
        console.log(error);
      },
      () => {
        console.log("complete");
      }
    );
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(ServiceAddComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }

  openDelete(service) {
    const dialogRef = this.dialog.open(ServiceDeleteComponent, {
      disableClose: true,
      width: "500px",

      data: { data1: service },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel")
        this.serviceList = this.serviceList.filter((t) => t.id != service.id);
    });
  }

  openEdit(service) {
    const dialogRef = this.dialog.open(ServiceEditComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
      data: { dataService: service },
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }
}
