import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Fueling } from 'src/app/model/fueling.model';

@Component({
  selector: 'app-fueling-table',
  templateUrl: './fueling-table.component.html',
  styleUrls: ['./fueling-table.component.css']
})
export class FuelingTableComponent {

  //@Input()  message: string = '';
  @Input()  tableData: Fueling[] = [];
  @Output() newEvent = new EventEmitter<Fueling>();
  @Output() editEvent = new EventEmitter<Fueling>();
  @Output() removeEvent = new EventEmitter<number>();

  constructor() {}


  emitNewEvent(fueling: Fueling) {
    this.newEvent.emit(fueling);
  }

  emitEditEvent(fueling: Fueling) {
    this.editEvent.emit(fueling);
  }

  emitRemoveEvent(id: number) {
    this.removeEvent.emit(id);
  }
}
