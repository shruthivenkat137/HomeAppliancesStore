import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  products: Product[];
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.getUserProducts();
  }
  getUserProducts() {
    this.productService.getUserproducts().subscribe(
      (data: any) => {
        this.products = data;
      },
      (error: any) => console.error(error)
    );
  }
  logout(){
    sessionStorage.clear();
  }
}