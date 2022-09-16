import { Component, OnInit } from '@angular/core';
import { OrderItem } from '../order-item';
import { CartService } from '../_services/cart.service';

@Component({
  selector: 'app-user-vieworders',
  templateUrl: './user-vieworders.component.html',
  styleUrls: ['./user-vieworders.component.css']
})
export class UserViewOrdersComponent implements OnInit {

  userId: any;
  orderitems: OrderItem[];

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.userId = sessionStorage.getItem('userId');
    this.cartService.viewOrder(this.userId).subscribe(
      (data: any) => {
        this.orderitems = data;
        console.log(this.orderitems);
      },
      (error: any) => ('You have no orders yet') 
    );
  }
  logout(){
    sessionStorage.clear();
  }
}