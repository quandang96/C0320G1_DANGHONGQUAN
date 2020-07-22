import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder } from "@angular/forms";

@Component({
  selector: "app-attach-service",
  templateUrl: "./attach-service.component.html",
  styleUrls: ["./attach-service.component.scss"],
})
export class AttachServiceComponent implements OnInit {
  attachForm: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.attachForm = this.fb.group({
      name: [""],
      price: [""],
    });
  }
}
