import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TankTableComponent } from './tank-table.component';

describe('TankTableComponent', () => {
  let component: TankTableComponent;
  let fixture: ComponentFixture<TankTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TankTableComponent]
    });
    fixture = TestBed.createComponent(TankTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
