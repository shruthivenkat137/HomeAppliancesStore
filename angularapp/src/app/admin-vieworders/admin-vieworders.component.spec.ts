import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewOrdersComponent } from './admin-vieworders.component';

describe('AdminVieworderComponent', () => {
  let component: AdminViewOrdersComponent;
  let fixture: ComponentFixture<AdminViewOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminViewOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminViewOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
