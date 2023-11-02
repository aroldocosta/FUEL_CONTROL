import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Tank } from 'src/app/model/tank.modal';

@Component({
  selector: 'app-tank-table',
  templateUrl: './tank-table.component.html',
  styleUrls: ['./tank-table.component.css']
})
export class TankTableComponent {
    
    @Input() list: Tank[] = [];
    @Input() message: string = '';
    @Output() showEvent = new EventEmitter();
    @Output() clearEvent = new EventEmitter()

    constructor() {}

    clearAlertMessage() {
      this.clearEvent.emit();
    }
  
    showAlertMessage() {
      this.showEvent.emit();
    }
}