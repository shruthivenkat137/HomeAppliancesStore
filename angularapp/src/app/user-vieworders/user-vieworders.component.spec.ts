import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewOrdersComponent } from './user-vieworders.component';

describe('UserVieworderComponent', () => {
  let component: UserViewOrdersComponent;
  let fixture: ComponentFixture<UserViewOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserViewOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
