import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { AdminAddproductComponent } from './admin-addproduct/admin-addproduct.component';
import { AdminViewproductComponent } from './admin-viewproduct/admin-viewproduct.component';
import { AdminEditproductComponent } from './admin-editproduct/admin-editproduct.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { UserViewproductComponent } from './user-viewproduct/user-viewproduct.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserCartComponent } from './user-cart/user-cart.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { UserViewOrdersComponent } from './user-vieworders/user-vieworders.component';
import { AdminViewOrdersComponent } from './admin-vieworders/admin-vieworders.component';

const routes: Routes = [
{path:'',component:LandingComponent},
{ path: 'signup', component: SignupComponent },
{ path: 'login', component: LoginComponent },
{path:'admin/home',component:AdminHomePageComponent},
{ path: 'admin/addproduct', component: AdminAddproductComponent },
{path: 'admin/viewproducts',component:AdminViewproductComponent},
{ path: 'admin/editproduct/:id', component: AdminEditproductComponent },
{ path: 'user/home', component: UserHomeComponent },
{path:'user/viewproducts/:id',component: UserViewproductComponent}, 
{path:'user/viewprosucts',component:UserProfileComponent},
{path:'user/addCustomer',component:UserProfileComponent},
{path:'user/cart',component:UserCartComponent},
{path:'user/placeOrder',component:PlaceOrderComponent},
{path:'user/profile',component:UserProfileComponent},
{path:'user/viewOrders',component:UserViewOrdersComponent},
{path:'admin/viewOrders',component:AdminViewOrdersComponent}];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
