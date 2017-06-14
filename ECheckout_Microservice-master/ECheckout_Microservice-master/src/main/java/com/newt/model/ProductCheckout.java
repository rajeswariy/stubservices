package com.newt.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.newt.commonutils.Productstatus;

@Entity
public class ProductCheckout {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int productcheckoutId;
	
	 private int productId;
	
	 private String productName;
	
	 private long customerId;
	
	 private int checkoutOrderId;
	 
	 @Enumerated(EnumType.STRING)
	 private Productstatus productStatus;
	 
	 private int shoppingcartId;
	
	 public int getProductcheckoutId() {
	  return productcheckoutId;
	 }
	
	 public void setProductcheckoutId(int productcheckoutId) {
	  this.productcheckoutId = productcheckoutId;
	 }
	
	 public int getProductId() {
	  return productId;
	 }
	
	
	 public int getCheckoutOrderId() {
	  return checkoutOrderId;
	 }
	
	 public void setCheckoutOrderId(int checkoutOrderId) {
	  this.checkoutOrderId = checkoutOrderId;
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
	
	 public long getCustomerId() {
	  return customerId;
	 }
	
	 public void setCustomerId(long customerId) {
	  this.customerId = customerId;
	 }

	public Productstatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Productstatus productStatus) {
		this.productStatus = productStatus;
	}

	public int getShoppingcartId() {
		return shoppingcartId;
	}

	public void setShoppingcartId(int shoppingcartId) {
		this.shoppingcartId = shoppingcartId;
	}

	@Override
	public String toString() {
		return "ProductCheckout [productcheckoutId=" + productcheckoutId + ", productId=" + productId + ", productName="
				+ productName + ", customerId=" + customerId + ", checkoutOrderId=" + checkoutOrderId
				+ ", productStatus=" + productStatus + ", shoppingcartId=" + shoppingcartId + "]";
	}
 
}