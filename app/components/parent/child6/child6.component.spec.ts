import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Child6Component } from './child6.component';

describe('Child6Component', () => {
  let component: Child6Component;
  let fixture: ComponentFixture<Child6Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Child6Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Child6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
