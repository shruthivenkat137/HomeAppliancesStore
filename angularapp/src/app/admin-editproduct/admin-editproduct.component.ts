import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-admin-editproduct',
  templateUrl: './admin-editproduct.component.html',
  styleUrls: ['./admin-editproduct.component.css']
})
export class AdminEditproductComponent implements OnInit {

  productId: number;
  product: Product;

  constructor(private route: ActivatedRoute, private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(paramsId => {
      this.productId = paramsId['id'];
    });
    this.getProductById(this.productId);
  }

  getProductById(productId: number) {
    this.productService.getProductById(productId).subscribe(
      (data: any) => {
        //console.log(data);
        this.product = data;
      },
      (error: any) => console.error(error)
    );
  }

  onSubmit() {
    this.updateProduct(this.product, this.productId);
  }

  updateProduct(product: Product, productId: number) {
    this.productService.updateProduct(this.product, this.productId).subscribe(
      (data: any) => {
        this.router.navigate(['/admin/viewproducts']);
      },
      (error: any) => console.error(error)
    );
  }

}
