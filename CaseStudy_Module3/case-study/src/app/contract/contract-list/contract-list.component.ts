import { Component, OnInit } from "@angular/core";
import { IContract } from "src/app/interface/contract";
import { ContractService } from "src/app/service/contract.service";
import { MatDialog } from "@angular/material";
import { ContractAddComponent } from "../contract-add/contract-add.component";
import { ContractDeleteComponent } from "../contract-delete/contract-delete.component";
import { ContractEditComponent } from "../contract-edit/contract-edit.component";

@Component({
  selector: "app-contract-list",
  templateUrl: "./contract-list.component.html",
  styleUrls: ["./contract-list.component.scss"],
})
export class ContractListComponent implements OnInit {
  contractList: IContract[] = [];
  term: string;
  p: number = 1;

  constructor(
    private contractService: ContractService,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    this.contractService.getListContract().subscribe(
      (data) => {
        this.contractList = data;
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
    const dialogRef = this.dialog.open(ContractAddComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel") this.ngOnInit();
    });
  }

  openDelete(contract) {
    const dialogRef = this.dialog.open(ContractDeleteComponent, {
      disableClose: true,
      width: "500px",

      data: { data1: contract },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result != "cancel")
        this.contractList = this.contractList.filter(
          (t) => t.id != contract.id
        );
    });
  }

  openEdit(contract: IContract) {
    const dialogRef = this.dialog.open(ContractEditComponent, {
      disableClose: true,
      width: "50%",
      height: "100%",
      autoFocus: true,
      data: { dataContract: contract },
    });
    dialogRef.afterClosed().subscribe((result) => {
      console.log("close");
      if (result != "cancel") this.ngOnInit();
    });
  }
}
