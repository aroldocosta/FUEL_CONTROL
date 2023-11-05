import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelingFormComponent } from './fueling-form.component';

describe('FuelingFormComponent', () => {
  let component: FuelingFormComponent;
  let fixture: ComponentFixture<FuelingFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FuelingFormComponent]
    });
    fixture = TestBed.createComponent(FuelingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
