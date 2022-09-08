import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-admin-viewproduct',
  templateUrl: './admin-viewproduct.component.html',
  styleUrls: ['./admin-viewproduct.component.css']
})
export class AdminViewproductComponent implements OnInit {

  products: Product[];
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.getAllProducts();
  }
  getAllProducts() {
    this.productService.getProducts().subscribe(
      (data: any) => {
        this.products = data;
      },
      (error: any) => console.error(error)
    );
  }

  deleteProduct(productId:number){
    this.productService.deleteProduct(productId).subscribe(
      (data: any) => {
       console.log("deleted");
       window.location.reload();

      },
      (error: any) => console.error(error)
    );
  }
}


  

