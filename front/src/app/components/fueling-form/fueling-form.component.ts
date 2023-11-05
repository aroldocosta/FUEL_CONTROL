import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-fueling-form',
  templateUrl: './fueling-form.component.html',
  styleUrls: ['./fueling-form.component.css']
})
export class FuelingFormComponent {

  inputValue: string = '0.0';
  @Input() pumpId: string = '0';
  @Input() value: string = '';
  @Output() formatEvent = new EventEmitter<any>();

  constructor() {}

  
  formatInput() {
    this.formatEvent.emit(this.inputValue);
  }


}
