import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitticketComponent } from './submitticket.component';

describe('SubmitticketComponent', () => {
  let component: SubmitticketComponent;
  let fixture: ComponentFixture<SubmitticketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitticketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
