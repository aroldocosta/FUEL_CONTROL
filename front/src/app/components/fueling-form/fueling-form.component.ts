import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Pump } from 'src/app/model/pump.model';

@Component({
  selector: 'app-fueling-form',
  templateUrl: './fueling-form.component.html',
  styleUrls: ['./fueling-form.component.css']
})
export class FuelingFormComponent {

  @Input() fuelingPayment: string = '';

  @Input() command: string = '';
  @Input() pumpList: any = [];
  @Input() fuelingDate: string = '';
  @Input() fuelingPumpId: string = '';
  @Input() fuelingQuantity: string = '';  

  @Output() paymentEvent = new EventEmitter<string>();
  @Output() quantityEvent = new EventEmitter<string>();
  @Output() dateEvent = new EventEmitter<string>();
  @Output() pumpIdEvent = new EventEmitter<string>()

  constructor() {}

  emitFormatQuantityEvent() {
    this.quantityEvent.emit(this.fuelingQuantity);
  }

  emitFormatPaymentEvent() {
    this.paymentEvent.emit(this.fuelingPayment);
  }

  emitDateEvent() {
    this.dateEvent.emit(this.fuelingDate);
  }

  emitPumpIdEvent() {
    this.pumpIdEvent.emit(this.fuelingPumpId);
  }
}
