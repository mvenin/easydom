package ro.mve.easydom.db.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine extends BaseEntity {

	@ManyToOne(cascade = { CascadeType.ALL })
	private PurchaseOrder order;

	private int quantity;
	private BigDecimal unitPrice;
	private String productName;
	private String productType;

	public PurchaseOrder getOrder() {
		return this.order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "OrderLine [order=" + this.order.getId() + ", quantity="
				+ this.quantity + ", unitPrice=" + this.unitPrice
				+ ", productName=" + this.productName + ", productType="
				+ this.productType + "]";
	}

}
