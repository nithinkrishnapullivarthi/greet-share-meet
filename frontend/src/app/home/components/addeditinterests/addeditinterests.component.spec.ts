import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddeditinterestsComponent } from './addeditinterests.component';

describe('AddeditinterestsComponent', () => {
  let component: AddeditinterestsComponent;
  let fixture: ComponentFixture<AddeditinterestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddeditinterestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddeditinterestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
