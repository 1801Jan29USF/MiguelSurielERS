import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParamParentComponent } from './param-parent.component';

describe('ParamParentComponent', () => {
  let component: ParamParentComponent;
  let fixture: ComponentFixture<ParamParentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParamParentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParamParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
