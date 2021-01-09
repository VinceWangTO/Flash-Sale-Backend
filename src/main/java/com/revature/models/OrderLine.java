package com.revature.models;

import java.math.BigDecimal;

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
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lineId;

	@ManyToOne
	@JoinColumn(referencedColumnName = "orderId")
	@JsonBackReference // the other half gets the json info, I don't
	private Order order;

	@ManyToOne
	@JoinColumn(referencedColumnName = "productId")
	private Product product;

	private int quantity;

	private BigDecimal costPrice;

	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public OrderLine(int lineId, Order order, Product product, int quantity, BigDecimal costPrice) {
		super();
		this.lineId = lineId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.costPrice = costPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costPrice == null) ? 0 : costPrice.hashCode());
		result = prime * result + lineId;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (costPrice == null) {
			if (other.costPrice != null)
				return false;
		} else if (!costPrice.equals(other.costPrice))
			return false;
		if (lineId != other.lineId)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderLine [lineId=" + lineId + ", order=" + order + ", product=" + product + ", quantity=" + quantity
				+ ", costPrice=" + costPrice + "]";
	}

}
