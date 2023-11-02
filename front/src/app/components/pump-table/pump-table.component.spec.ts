import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PumpTableComponent } from './pump-table.component';

describe('PumpTableComponent', () => {
  let component: PumpTableComponent;
  let fixture: ComponentFixture<PumpTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PumpTableComponent]
    });
    fixture = TestBed.createComponent(PumpTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
