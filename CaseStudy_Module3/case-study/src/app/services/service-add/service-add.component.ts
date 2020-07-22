import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { FacilityService } from "src/app/service/facility.service";
import { MatDialogRef } from "@angular/material";

@Component({
  selector: "app-service-add",
  templateUrl: "./service-add.component.html",
  styleUrls: ["./service-add.component.scss"],
})
export class ServiceAddComponent implements OnInit {
  serviceForm: FormGroup;
  constructor(
    private service: FacilityService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<ServiceAddComponent>
  ) {}

  ngOnInit() {
    this.serviceForm = this.fb.group({
      code: ["", [Validators.required, Validators.pattern(/^DV-\d{4}$/)]],
      name: [""],
      area: [""],
      floor: [""],
      maxPerson: [""],
      price: [""],
      serviceType: [""],
    });
  }

  onSubmit() {
    this.service.createService(this.serviceForm.value).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
