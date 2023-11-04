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

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  @Input() tankList: any;
  @Input() pumpList: any;
  report: any = 'Aguarde...';
  fueling: any;
  fuelingPump: string = '0';
  fuelingValue: string = '';
  alertMessage: string = '';
  fuelingList: Fueling[] = [];
  filteredList: Fueling[] = [];
  enabledDate: boolean = true;
  filteredDate: string = '';
  filteredTank: string = 'ALL';
  filteredPumps: Filtered[] = [
    new Filtered('BOMBA_01', true),
    new Filtered('BOMBA_02', true),
    new Filtered('BOMBA_03', true),
    new Filtered('BOMBA_04', true),
  ];

  constructor(
    private fuelingService: FuelingsService, 
    private loginService: LoginService, 
    private pumpService: PumpService
    ) {

  }

  ngOnInit(): void {
    this.list();
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
    console.log("Report: ", report);
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
            ? this.filteredPumps[index] = {pump: 'BOMBA_XX', checked: false }
            : this.filteredPumps[index] = {pump: 'BOMBA_0' + String(index + 1) , checked: true };
      this.filterFueling();
  }

  isFilteredDate(date: string) {    
    let dateValues = date.split('/');
    let dateFilter = this.filteredDate.split('-');
    let d_yea = Number(dateValues[2]);
    let d_mon = Number(dateValues[1]);
    let d_day = Number(dateValues[0]);
    let f_yea = Number(dateFilter[0]);
    let f_mon = Number(dateFilter[1]);
    let f_day = Number(dateFilter[2]);
    let same = (d_yea == f_yea && d_mon == f_mon && d_day == f_day);
 
    return same;
  }

  filterFueling() {
    this.filteredList = this.fuelingList.filter(f => 
      (f.pump == this.filteredPumps[0].pump  ||
       f.pump == this.filteredPumps[1].pump  ||
       f.pump == this.filteredPumps[2].pump  ||
       f.pump == this.filteredPumps[3].pump) &&
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

  editPump(pump: any) {
    console.log(pump.name);
  }

  showNotImplementedAlert() {
    this.alertMessage = 'Função ainda não implementada neste MVP!';
  }

  clearAlertMessage() {
    this.alertMessage = '';
  }

  openPumpModal(pump: any) {
    console.log("Open pump modal: " + pump.name)
  }

  formatValue(){
    let strValue = this.fuelingValue;
    strValue = strValue.replaceAll('.', '');
    strValue = strValue.replaceAll(',', '');
    let value = Number(strValue)/100
    this.fuelingValue = formatNumber(value, 'pt-BR', '1.2-2');
  }

  new() {

    let pump  = this.fuelingPump;
    let value = this.fuelingValue.replaceAll('.', '').replaceAll(',', '.');
    
    let fueling = {
      pump: this.fuelingPump,
      amount: value
    }
    
    this.fuelingService.create(fueling).subscribe({
      next: resp => {
        console.log(JSON.stringify(resp));
        document.getElementById("newCloseModalButton")?.click();
        this.fuelingValue = '';
        this.fuelingPump = '0';
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

  }

  remove(id: number) {
    console.log('remove(fueling: Fueling)');
    let resp = confirm('Confirma remover o abastecimento?');

    if(resp) {
      this.fuelingService.remove(id).subscribe(resp => {
        console.log(JSON.stringify(resp));
        this.list();
      })
    }
    document.getElementById("newCloseModalButton")?.click();
  }

  home() {

  }

  openModal(fueling: Fueling) {

  }
}
