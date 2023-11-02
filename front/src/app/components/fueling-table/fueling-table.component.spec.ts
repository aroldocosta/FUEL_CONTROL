import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelingTableComponent } from './fueling-table.component';

describe('FuelingTableComponent', () => {
  let component: FuelingTableComponent;
  let fixture: ComponentFixture<FuelingTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FuelingTableComponent]
    });
    fixture = TestBed.createComponent(FuelingTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
