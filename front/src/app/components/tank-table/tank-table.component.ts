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
      //this.message = 'Função ainda não implementada neste MVP!';
      console.log('showNotImplementedAlert')
      this.showEvent.emit();
    }
}

/*
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
  @Output() clearEvent = new EventEmitter()
 

  constructor() {

  }

  clearAlertMessage() {
    this.clearEvent.emit();
  }

  showAlertMessage() {
    //this.message = 'Função ainda não implementada neste MVP!';
    console.log('showNotImplementedAlert')
    this.showEvent.emit();
  }
}


*/
