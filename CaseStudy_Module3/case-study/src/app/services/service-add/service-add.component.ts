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
      name: [
        "",
        [Validators.required, Validators.minLength(2), Validators.max(20)],
      ],
      area: ["", [Validators.min(1), Validators.required]],
      floor: ["", [Validators.required, Validators.min(1)]],
      maxPerson: ["", [Validators.required, Validators.min(1)]],
      price: ["", [Validators.required, Validators.min(1)]],
      serviceType: ["", [Validators.required]],
    });
  }

  onSubmit() {
    this.service.createService(this.serviceForm.value).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
