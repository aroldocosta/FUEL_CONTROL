import { TitleStrategy } from "@angular/router";

export class Fueling {
    id: number = 0;
    pumpId: string = '0'
    pumpName: string = '';
    quantity: number = 0;
    payment: number = 0;
    total: number = 0;
    fuel: string = '';
    tankName: string = '';
    unitPrice: number = 0;
    taxation: number = 0;
    date: string = '--/--/--';
    message: string = '';
    
    constructor(pumpName: string, value: number) {
        this.pumpName = pumpName;
        this.payment = value;
    }
}