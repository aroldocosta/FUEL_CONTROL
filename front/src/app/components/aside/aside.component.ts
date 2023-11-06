import { Component, OnInit } from '@angular/core';
import { TitleStrategy } from '@angular/router';
import { Totals } from 'src/app/model/totals.model';
import { FuelingsService } from 'src/app/services/fuelings.service';

@Component({
  selector: 'app-aside',
  templateUrl: './aside.component.html',
  styleUrls: ['./aside.component.css']
})
export class AsideComponent implements OnInit {  

  gTodayQuantity: number = 0.0;
  gMonthQuantity: number = 0.0;
  gYearQuantity: number = 0.0;
  gTodayPayment: number = 0.0;
  gMonthPayment: number = 0.0;
  gYearPayment: number = 0.0;

  dTodayQuantity: number = 0.0;
  dMonthQuantity: number = 0.0;
  dYearQuantity: number = 0.0;
  dTodayPayment: number = 0.0;
  dMonthPayment: number = 0.0;
  dYearPayment: number = 0.0;

  tTodayQuantity: number = 0.0;
  tMonthQuantity: number = 0.0;
  tYearQuantity: number = 0.0;
  tTodayPayment: number = 0.0;
  tMonthPayment: number = 0.0;
  tYearPayment: number = 0.0;

  gUnitPrice: number = 5.85;
  dUnitPrice: number = 5.99;

  constructor(private fuelingService: FuelingsService) { 

  }

  ngOnInit(): void {
    this.requestTotals();
  }

  refresh() {
    let time = setTimeout(() => {
      this.requestTotals();
      this.refresh();
    }, 10000);
  }

  requestTotals() {
    this.fuelingService.totals().subscribe({
      next: (totals: any) => {
        //--------- Gasoline totals ----------------
        this.gTodayQuantity = totals.gTodayQuantity;
        this.gMonthQuantity = totals.gMonthQuantity;
        this.gYearQuantity  = totals.gYearQuantity;
        this.gTodayPayment   = totals.gTodayPayment;
        this.gMonthPayment   = totals.gMonthPayment;
        this.gYearPayment    =  totals.gYearPayment;

        //--------- Diesel totals -----------------
        this.dTodayQuantity = totals.dTodayQuantity;
        this.dMonthQuantity = totals.dMonthQuantity;
        this.dYearQuantity  = totals.dYearQuantity;
        this.dTodayPayment   = totals.dTodayPayment;
        this.dMonthPayment   = totals.dMonthPayment;
        this.dYearPayment    = totals.dYearPayment;

        //---------- General totals --------------- 
        this.tTodayQuantity = this.gTodayQuantity + this.dTodayQuantity;
        this.tMonthQuantity = this.gMonthQuantity + this.dMonthQuantity;
        this.tYearQuantity  = this.gYearQuantity  + this.dYearQuantity;
        this.tTodayPayment   = this.gTodayPayment   + this.dTodayPayment;
        this.tMonthPayment   = this.gMonthPayment   + this.dMonthPayment;
        this.tYearPayment    = this.gYearPayment    + this.dYearPayment;

        //---------- Unit prices ------------------
        this.gUnitPrice = totals.gUnitPrice;
        this.dUnitPrice = totals.dUnitPrice;
      }
    })
  }
}
