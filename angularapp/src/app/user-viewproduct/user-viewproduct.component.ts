import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../_services/product.service';
import { CartItem } from '../cartitem';
import { CartService } from '../_services/cart.service';
import { Order } from '../order';
import { Router } from '@angular/router';
import { UserCart } from '../user-cart';
@Component({
  selector: 'app-user-viewproduct',
  templateUrl: './user-viewproduct.component.html',
  styleUrls: ['./user-viewproduct.component.css']
})
export class UserViewproductComponent implements OnInit {


  order: Order = new Order();

  
  cartitems: UserCart[];
  userId: any;
  total: number;
  cartlength:number=0;
  products: Product[];
  productId:number;
  product : Product = new Product();
  quantity: number=1;
  cart: CartItem = new CartItem();
  constructor(private route:ActivatedRoute,
    private productService:ProductService, 
    private cartService: CartService,
    private router: Router
    )  { }

  ngOnInit(): void {
    this.route.params.subscribe(paramsId => {
      this.productId = paramsId['id'];
      console.log(this.productId);
      this.getProductById(this.productId);
    });
  }

  getProductById(productId: number) {
    this.productService.getProductById(productId).subscribe(
      (data: any) => {
        console.log(data);
        this.product = data;
      },
      (error: any) => console.error(error)
    );
  }
  minus() {
    if (this.quantity >= 2) this.quantity--;
  }
  plus() {
    if (this.quantity <= 9) this.quantity++;
  }
   addtocart() {
    this.cart.productId = this.productId;
    
    this.cart.userId = sessionStorage.getItem('userId');
    console.log(this.cart.userId);
    this.cart.quantity = this.quantity;


    if (this.cart.userId == null) {
     
    } else {
      this.cartService.addItemToCart(this.cart).subscribe(
        (data: any) => {
          console.log(data);
          alert('Item added to cart');
        },
        (error: any) => console.error(error)
      );
    }
    
  }


  logout(){
    sessionStorage.clear();
  }
  
}
function sleep(ms: number) {
  return new Promise( resolve => setTimeout(resolve, ms) );
}




 
  

