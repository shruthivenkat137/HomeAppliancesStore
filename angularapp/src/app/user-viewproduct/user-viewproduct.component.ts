import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-user-viewproduct',
  templateUrl: './user-viewproduct.component.html',
  styleUrls: ['./user-viewproduct.component.css']
})
export class UserViewproductComponent implements OnInit {

  products: Product[];
  productId:number;
  product : Product = new Product();
  constructor(private route:ActivatedRoute,private productService:ProductService) { }

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

  addtocart(){
    
  }

}
