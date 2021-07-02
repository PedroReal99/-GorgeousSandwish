import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSandwichesComponent } from './view-sandwiches.component';

describe('ViewSandwichesComponent', () => {
  let component: ViewSandwichesComponent;
  let fixture: ComponentFixture<ViewSandwichesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewSandwichesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSandwichesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
