export class Filtered {
    pumpName: string = '';
    checked: boolean = false;

    constructor(pumpName: string, checked: boolean) {
        this.pumpName = pumpName;
        this.checked = checked;
    }
}