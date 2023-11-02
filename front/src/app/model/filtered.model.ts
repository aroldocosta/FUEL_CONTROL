export class Filtered {
    pump: string = '';
    checked: boolean = false;

    constructor(pump: string, checked: boolean) {
        this.pump = pump;
        this.checked = checked;
    }
}