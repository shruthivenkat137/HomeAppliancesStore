import { Component, OnInit } from '@angular/core';
import { OrderItem } from '../order-item';
import { CartService } from '../_services/cart.service';

@Component({
  selector: 'app-admin-vieworders',
  templateUrl: './admin-vieworders.component.html',
  styleUrls: ['./admin-vieworders.component.css']
})
export class AdminViewOrdersComponent implements OnInit {

  orderitems:OrderItem[];
  constructor(private cartService:CartService) { }

  ngOnInit(): void {
    this.cartService.viewAllOrders().subscribe(
      (data: any) => {
        this.orderitems = data;
        console.log(this.orderitems);
      },
      (error: any) =>console.error(error)  
    );
  }

}


