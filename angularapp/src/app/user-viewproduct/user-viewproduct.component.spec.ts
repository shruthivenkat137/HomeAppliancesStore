import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewproductComponent } from './user-viewproduct.component';

describe('UserViewproductComponent', () => {
  let component: UserViewproductComponent;
  let fixture: ComponentFixture<UserViewproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewproductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserViewproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
