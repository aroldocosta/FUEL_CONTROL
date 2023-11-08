import { ConditionalExpr } from '@angular/compiler';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Pump } from 'src/app/model/pump.model';

@Component({
  selector: 'app-pump-table',
  templateUrl: './pump-table.component.html',
  styleUrls: ['./pump-table.component.css']
})
export class PumpTableComponent {
  
  @Input() list: Pump[] = [];
  @Input() message: string = '';
  @Output() showEvent = new EventEmitter();
  @Output() clearEvent = new EventEmitter();
 

  constructor() {

  }

  clearAlertMessage() {
    this.clearEvent.emit();
  }

  showAlertMessage() {
    this.showEvent.emit();
  }
}
