package ro.mve.easydom.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class PurchaseOrder extends BaseEntity {
	private static final Logger LOG = LoggerFactory
			.getLogger(PurchaseOrder.class);

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Customer customer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private final Date createDate = new Date();

	@OneToMany(mappedBy = "order")
	private final List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public void removeOrderLine(OrderLine orderLine) {
		if (orderLine == null) {
			PurchaseOrder.LOG.error("return from: removing null orderLine");
			return;
		}
		this.orderLines.remove(orderLine);
		orderLine.setOrder(null);
	}

	public void addOrderLine(OrderLine orderLine) {
		if (orderLine == null) {
			PurchaseOrder.LOG.error("return from: adding null orderLine");
			return;
		}
		if (this.orderLines.contains(orderLine)) {
			PurchaseOrder.LOG.warn("adding already added orderLine {}",
					orderLine);
		}
		orderLine.setOrder(this);
		this.orderLines.add(orderLine);
	}

	public List<OrderLine> getOrderLines() {
		return this.orderLines;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [customer=" + this.customer + ", createDate="
				+ this.createDate + ", orderLines=" + this.orderLines
				+ ", getId()=" + this.getId() + "]";
	}

}
