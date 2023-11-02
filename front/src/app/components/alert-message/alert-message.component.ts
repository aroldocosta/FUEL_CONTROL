import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-alert-message',
  templateUrl: './alert-message.component.html',
  styleUrls: ['./alert-message.component.css']
})
export class AlertMessageComponent {

    @Input() message: string = '';
    @Output() showEvent = new EventEmitter();
    @Output() clearEvent = new EventEmitter();

    constructor() {}

    emitClearEvent() {
      this.clearEvent.emit();
    }
}
