package com.ani.
model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
  int cartdId;
	@Column
  int productId;
  String productName;
  int productprice;
  String productSuppllier;
  int productQuantity;
  int totalprice;
  
  

public int getTotalprice() {
	return totalprice;
}

public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}

public int getCartdId() {
	return cartdId;
}

public void setCartdId(int cartdId) {
	this.cartdId = cartdId;
	
}

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

public int getProductprice() {
	return productprice;
}

public void setProductprice(int productprice) {
	this.productprice = productprice;
}

public String getProductSuppllier() {
	return productSuppllier;
}

public void setProductSuppllier(String productSuppllier) {
	this.productSuppllier = productSuppllier;


}

public int getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
}
