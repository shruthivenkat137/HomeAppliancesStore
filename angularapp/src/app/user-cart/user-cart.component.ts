import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserCart } from '../user-cart';
import { CartService } from '../_services/cart.service';
import { Order } from '../order';
import {ContactService} from '../_services/contact.service';
@Component({
  selector: 'app-user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css'],
})
export class UserCartComponent implements OnInit {

  order: Order = new Order();
  quantity: number;
  subtotal: number = 0;
  shipping: number = 0;
  cartitems: UserCart[];
  userId: any;
  total: number;
  cartlength:number=0;
  constructor(private cartService: CartService, private router: Router,private contactService:ContactService) {}

   
  
    ngOnInit(): void {
      this.getUserCart();
    }
    
    minus() {
      if (this.quantity >= 2) this.quantity--;
    }
    plus() {
      if (this.quantity <= 9) this.quantity++;
    }
    
    getUserCart() {
      this.userId = sessionStorage.getItem('userId');
      this.cartService.getUserCart(this.userId).subscribe(
        (data: any) => {
          this.cartitems = data;
          console.log(this.cartitems);
          this.cartitems.forEach((element) => {
            this.subtotal += element.productPrice;
          });
  
          this.shipping = this.randomInt(30, 50);
          this.total = this.subtotal + this.shipping;
          this.cartlength=this.cartitems.length;
          if (this.cartitems.length == 0) {
            alert('Your cart is empty');
          }
        },
        (error: any) => console.error(error)
      );
    }
  
    placeorder() {
      console.log('Order');
      this.router.navigate(['/user/placeOrder']);
      this.order.amount = this.total;
      this.order.cartItem = this.cartitems;
      this.order.userId = this.userId;
      console.log(this.order);
      this.cartService.placeOrder(this.order).subscribe(
        (data: any) => {
         
          console.log(data)
          sessionStorage.setItem('orderId',data.orderId);
          sessionStorage.setItem('orderDate',data.createdDate);
          sessionStorage.setItem('noOfItems',data.cartItem.length);
          sessionStorage.setItem('totalAmount',data.amount);
          console.log(sessionStorage);
        },
        (error: any) => console.error(error)
      );
    }
    getAddress() {
      this.contactService.getAddress(this.userId).subscribe(
        (data: any) => {
          console.log(data);
       
        if(data==null)
        {
          alert('Please update your profile')
        }
        (error: any) => console.error('Please try again later','Something wrong')
    });
    }
    deleteCartItem(productId: number) {
      this.cartService.deleteCartItem(productId, this.userId).subscribe(
        (data: any) => {
          console.log(data);
          window.location.reload();
        },
        (error: any) => console.error(error)
      );
    }
    
    randomInt(min: number, max: number) {
      // min and max included
      return Math.floor(Math.random() * (max - min + 1) + min);
    }
    logout(){
      sessionStorage.clear();
    }
  }
  