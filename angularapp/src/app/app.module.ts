import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // <== add the imports!

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { AdminAddproductComponent } from './admin-addproduct/admin-addproduct.component';
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { AdminViewproductComponent } from './admin-viewproduct/admin-viewproduct.component';
import { HttpClientModule } from '@angular/common/http';
import { UserHomeComponent } from './user-home/user-home.component';
import { AdminEditproductComponent } from './admin-editproduct/admin-editproduct.component';
import { UserViewproductComponent } from './user-viewproduct/user-viewproduct.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    LandingComponent,
    AdminAddproductComponent,
    AdminHomePageComponent,
    AdminViewproductComponent,
    UserHomeComponent,
    AdminEditproductComponent,
    UserViewproductComponent,
    UserProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
