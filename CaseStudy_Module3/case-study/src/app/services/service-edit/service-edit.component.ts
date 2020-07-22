import { Component, OnInit, Inject } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { FacilityService } from "src/app/service/facility.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";

@Component({
  selector: "app-service-edit",
  templateUrl: "./service-edit.component.html",
  styleUrls: ["./service-edit.component.scss"],
})
export class ServiceEditComponent implements OnInit {
  serviceForm: FormGroup;
  constructor(
    private service: FacilityService,
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<ServiceEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    this.serviceForm = this.fb.group({
      id: [Number],
      code: ["", [Validators.required, Validators.pattern(/^DV-\d{4}$/)]],
      name: [""],
      area: [""],
      floor: [""],
      maxPerson: [""],
      price: [""],
      serviceType: [""],
    });

    this.serviceForm.patchValue(this.data.dataService);
  }

  onSubmit() {
    this.service.updateService(this.serviceForm.value).subscribe(() => {
      this.dialogRef.close();
    });
  }
}
