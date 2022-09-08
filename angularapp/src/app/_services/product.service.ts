import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from '../product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
 
  private apiServerUrl = environment.apiBaseUrl;
 

  constructor(private http: HttpClient) { }

  addproduct(product: Product): Observable<Object> {
    return this.http.post(`${this.apiServerUrl}/admin/addproduct`, product);
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/admin/viewproducts`);
  }

  getUserproducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/user/viewproducts`);
  }

  getProductById(productId: number) {
    return this.http.get<Product>(`${this.apiServerUrl}/admin/getProductById/${productId}`)
  }

  updateProduct(product: Product, productId: number): Observable<Object> {
    return this.http.put(`${this.apiServerUrl}/admin/editproduct/${productId}`, product);
  }

  deleteProduct(productId: number) {
    return this.http.delete(`${this.apiServerUrl}/admin/deleteproduct/${productId}`);
  }
}