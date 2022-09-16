package com.example.demo.Payload.response;

public class CartResponse {
    private int productId;
    private String productName;
    private String productImgUrl;
    private Double productPrice;
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartResponse(Integer productId, String productName, String productImgUrl, Double productPrice,
            int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productImgUrl = productImgUrl;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public CartResponse() {
    }

    @Override
    public String toString() {
        return "CartResponse [productId=" + productId + ", productImgUrl=" + productImgUrl + ", productPrice="
                + productPrice
                + ", productName=" + productName + ", quantity=" + quantity + "]";
    }

}
