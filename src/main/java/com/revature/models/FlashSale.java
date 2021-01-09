package com.revature.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FlashSale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flashSaleId;
	private String flashSaleDescription;
	private BigDecimal salePrice;
	private int inventory;
	private Timestamp startTime;

	@ManyToOne
	@JoinColumn(referencedColumnName = "productId")
	@JsonBackReference
	private Product product;

	public int getFlashSaleId() {
		return flashSaleId;
	}

	public void setFlashSaleId(int flashSaleId) {
		this.flashSaleId = flashSaleId;
	}

	public String getFlashSaleDescription() {
		return flashSaleDescription;
	}

	public void setFlashSaleDescription(String flashSaleDescription) {
		this.flashSaleDescription = flashSaleDescription;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public FlashSale(int flashSaleId, String flashSaleDescription, BigDecimal salePrice, int inventory,
			Timestamp startTime, Product product) {
		super();
		this.flashSaleId = flashSaleId;
		this.flashSaleDescription = flashSaleDescription;
		this.salePrice = salePrice;
		this.inventory = inventory;
		this.startTime = startTime;
		this.product = product;
	}

	public FlashSale() {
		super();
		// TODO Auto-generated constructor stub
	}

}
