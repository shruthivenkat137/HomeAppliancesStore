import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  orderId: any;
  orderDate: any;
  items: any;
  amount: any;

  constructor() {}

  ngOnInit(): void {
  
    console.log(this.orderId)
  }
getOrderId():any{
return sessionStorage.getItem('orderId');
}
  
getOrderDate():any{
  return sessionStorage.getItem('orderDate');
  }

  getItems():any{
    return sessionStorage.getItem('noOfItems');
    }
    getAmount():any{
      return sessionStorage.getItem('totalAmount');
      }




    }
