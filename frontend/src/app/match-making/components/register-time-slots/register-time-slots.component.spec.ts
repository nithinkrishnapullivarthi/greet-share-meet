import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterTimeSlotsComponent } from './register-time-slots.component';

describe('RegisterTimeSlotsComponent', () => {
  let component: RegisterTimeSlotsComponent;
  let fixture: ComponentFixture<RegisterTimeSlotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterTimeSlotsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterTimeSlotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
