import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewproductComponent } from './admin-viewproduct.component';

describe('AdminViewproductComponent', () => {
  let component: AdminViewproductComponent;
  let fixture: ComponentFixture<AdminViewproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminViewproductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminViewproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
