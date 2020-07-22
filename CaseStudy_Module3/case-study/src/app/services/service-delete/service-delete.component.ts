import { FacilityService } from "./../../service/facility.service";
import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";

@Component({
  selector: "app-service-delete",
  templateUrl: "./service-delete.component.html",
  styleUrls: ["./service-delete.component.scss"],
})
export class ServiceDeleteComponent implements OnInit {
  name: String;
  constructor(
    private facilityService: FacilityService,
    public dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    this.name = this.data.data1.name;
  }
  onDelete() {
    this.facilityService.deleteService(this.data.data1).subscribe((data) => {
      this.dialogRef.close();
    });
  }
}
