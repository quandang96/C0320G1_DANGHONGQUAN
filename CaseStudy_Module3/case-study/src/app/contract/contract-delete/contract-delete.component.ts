import { Component, OnInit, Inject } from "@angular/core";
import { ContractService } from "src/app/service/contract.service";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material";

@Component({
  selector: "app-contract-delete",
  templateUrl: "./contract-delete.component.html",
  styleUrls: ["./contract-delete.component.scss"],
})
export class ContractDeleteComponent implements OnInit {
  constructor(
    private contractService: ContractService,
    private dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {}
  onDelete() {
    this.contractService.deleteContract(this.data.data1).subscribe((data) => {
      this.dialogRef.close();
    });
  }
}
