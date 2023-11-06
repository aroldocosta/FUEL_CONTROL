import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Filtered } from 'src/app/model/filtered.model';
import { Fueling } from 'src/app/model/fueling.model';
import { Pump } from 'src/app/model/pump.model';
import { Tank } from 'src/app/model/tank.modal';
import { FuelingsService } from 'src/app/services/fuelings.service';
import { LoginService } from 'src/app/services/login.service';
import { PumpService } from 'src/app/services/pump.service';
import {formatNumber} from '@angular/common';
import { ThisReceiver } from '@angular/compiler';
import { TankService } from 'src/app/services/tank.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  @Input() tankList: any;
  @Input() pumpList: any;
  report: any = 'Aguarde...';
  editingFueling = new Fueling("0", 0.0);
  fuelingPayment = '';
  fuelingPumpId = '0';
  fuelingDate = '0';
  fuelingQuantity = '0';
  alertMessage: string = '';
  fuelingList: Fueling[] = [];
  filteredList: Fueling[] = [];
  enabledDate: boolean = true;
  filteredDate: string = '';
  filteredTank: string = 'ALL';
  filteredPumps: Filtered[] = [
    new Filtered('BOMBA1', true),
    new Filtered('BOMBA2', true),
    new Filtered('BOMBA3', true),
    new Filtered('BOMBA4', true),
  ];

  constructor(
    private fuelingService: FuelingsService, 
    private loginService: LoginService, 
    private pumpService: PumpService,
    private tankService: TankService
    ) {

  }

  ngOnInit(): void {
    this.list();
    this.requestPumps();
    this.requestTanks();
    let today = new Date();
    this.filteredDate = (today.getMonth()+1) + "/" + today.getDate() + "/" + today.getFullYear();
  }

  setPumpList(list: Pump[]) {
    this.pumpList = list;
  }

  setTankList(list: Tank[]) {
    this.tankList = list;
  }

  setReportFile(report: any) {
    const file = new Blob([report], {
      type: report.type
    });

    const blob = window.URL.createObjectURL(file);

    const link = document.createElement('a');
    link.href = blob;
    link.download = 'report.pdf';
    link.click();

    window.URL.revokeObjectURL(blob);
    link.remove();
  }

  setFilteredPump(index: number) {  
      this.filteredPumps[index] = this.filteredPumps[index].checked
            ? this.filteredPumps[index] = {pumpName: 'BOMBAXX', checked: false }
            : this.filteredPumps[index] = {pumpName: 'BOMBA' + String(index + 1) , checked: true };
      this.filterFueling();
  }

  isFilteredDate(date: string) {    
    let dateValues = date.split('T')[0].split('-');
    let dateFilter = this.filteredDate.split('-');
    let d_yea = Number(dateValues[0]);
    let d_mon = Number(dateValues[1]);
    let d_day = Number(dateValues[2]);
    let f_yea = Number(dateFilter[0]);
    let f_mon = Number(dateFilter[1]);
    let f_day = Number(dateFilter[2]);
    let same = (d_yea == f_yea && d_mon == f_mon && d_day == f_day);
 
    return same;
  }

  filterFueling() {
    this.filteredList = this.fuelingList.filter(f => 
      (f.pumpName == this.filteredPumps[0].pumpName  ||
       f.pumpName == this.filteredPumps[1].pumpName  ||
       f.pumpName == this.filteredPumps[2].pumpName  ||
       f.pumpName == this.filteredPumps[3].pumpName) &&
      (this.isFilteredDate(f.date) || this.enabledDate) &&
      (f.tankName == this.filteredTank || this.filteredTank == 'ALL') 
    );
  }

  requestPumps() {
    this.pumpService.list().subscribe({
      next: list => {
        this.pumpList = list;
      }
    })
  }

  requestTanks() {
    this.tankService.list().subscribe({
      next: list => {
        this.tankList = list;
      }
    })
  }

  showNotImplementedAlert() {
    this.alertMessage = 'Função ainda não implementada neste MVP!';
  }

  clearAlertMessage() {
    this.alertMessage = '';
  }

  setFuelingPumpId(pumpId: string) {
    console.log("setFuelingPumpId: " + pumpId)
    this.fuelingPumpId = pumpId;
  }
	
  setFuelingDate(date: string) {
    console.log("setFuelingDate: " + date)
    this.fuelingDate = date;
  }

  formatInputPayment(input: string) {
    let inputValue = input;
    let value = this.appyCurrencyMask(inputValue);
    this.fuelingPayment = value;
  }

  formatInputQuantity(input: string) {
    let inputValue = input;
    let value = this.appyCurrencyMask(inputValue);
    this.fuelingQuantity = value;
  }

  appyCurrencyMask(inputValue: string) {
    inputValue = inputValue.replaceAll('.', '');
    inputValue = inputValue.replaceAll(',', '');
    let value = Number(inputValue)/100;
    return formatNumber(value, 'pt-BR', '1.2-2');
  }

  new() {
    debugger
    let pumpId  = this.fuelingPumpId;
    let value = this.fuelingPayment.toString().replaceAll('.', '').replaceAll(',', '.');
    
    let fueling = {
      pumpId: pumpId,
      payment: value
    }

    this.fuelingService.create(fueling).subscribe({
      next: resp => {
        document.getElementById("newCloseModalButton")?.click();
        this.fuelingPayment = '';
        this.fuelingPumpId = '0';
        this.list();
      }
    })
  }

  view(formData: FormData) {

  }

  list() {
    this.fuelingService.list().subscribe({
      next: list => {        
        this.fuelingList = list;
        this.filteredList = this.fuelingList;
      }
    });
  }

  edit(fueling: Fueling) {
    this.fuelingPumpId = fueling.pumpId;
    this.fuelingPayment = this.appyCurrencyMask(fueling.payment.toFixed(2));
    this.fuelingQuantity = this.appyCurrencyMask(fueling.quantity.toFixed(2));
    this.fuelingDate = fueling.date.split('T')[0];   
    this.editingFueling = fueling;
  }

  update() { 
    let payment  = this.fuelingPayment.replaceAll('.', '').replaceAll(',', '.');
    let quantity = this.fuelingQuantity.replaceAll('.', '').replaceAll(',', '.');
    let fueling = this.editingFueling;
    fueling.date     = this.fuelingDate;
    fueling.payment  = Number(payment)
    fueling.quantity = Number(quantity);
    fueling.pumpId   = this.fuelingPumpId;

    this.fuelingService.update(fueling).subscribe({
      next: resp => {
        document.getElementById("editCloseModalButton")?.click();
        this.list();
      }
    })
  }

  remove(id: number) {
    let resp = confirm('Confirma remover o abastecimento?');

    if(resp) {
      this.fuelingService.remove(id).subscribe(resp => {
        this.list();
      })
    }
    document.getElementById("newCloseModalButton")?.click();
  }

  home() {

  }
}
