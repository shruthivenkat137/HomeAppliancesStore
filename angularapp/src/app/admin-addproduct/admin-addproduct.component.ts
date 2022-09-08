import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../_services/product.service';
@Component({
  selector: 'app-admin-addproduct',
  templateUrl: './admin-addproduct.component.html',
  styleUrls: ['./admin-addproduct.component.css']
})
export class AdminAddproductComponent {

  product: Product = new Product();

  constructor(private productService: ProductService) { }
  

  onSubmit() {
    this.addproduct();
    console.log(this.product);
    alert('product added successfully');
  }

  addproduct() {
    this.productService.addproduct(this.product).subscribe(
      (data: any) => {
        console.log(data);
      },
      (error: any) => console.error(error)
    );
  }
}
