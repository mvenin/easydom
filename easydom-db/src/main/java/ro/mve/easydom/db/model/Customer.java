package ro.mve.easydom.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Customer extends BaseEntity {
	private static final Logger LOG = LoggerFactory.getLogger(Customer.class);

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String creditCard;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private final List<PurchaseOrder> orders = new ArrayList<PurchaseOrder>();

	public void addOrder(PurchaseOrder order) {
		if (order == null) {
			Customer.LOG.error("return from: adding null order");
			return;
		}
		if (this.orders.contains(order)) {
			Customer.LOG.error("return from: adding already added order {}",
					order);
			return;
		}
		if ((order.getCustomer() == null) || this.equals(order.getCustomer())) {
			this.orders.add(order);
			order.setCustomer(this);
		}
	}

	public List<PurchaseOrder> getOrders() {
		return this.orders;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.address == null) ? 0 : this.address.hashCode());
		result = (prime * result)
				+ ((this.creditCard == null) ? 0 : this.creditCard.hashCode());
		result = (prime * result)
				+ ((this.email == null) ? 0 : this.email.hashCode());
		result = (prime * result)
				+ ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = (prime * result)
				+ ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = (prime * result)
				+ ((this.phone == null) ? 0 : this.phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (this.address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!this.address.equals(other.address)) {
			return false;
		}
		if (this.creditCard == null) {
			if (other.creditCard != null) {
				return false;
			}
		} else if (!this.creditCard.equals(other.creditCard)) {
			return false;
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!this.firstName.equals(other.firstName)) {
			return false;
		}
		if (this.lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!this.lastName.equals(other.lastName)) {
			return false;
		}
		if (this.phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!this.phone.equals(other.phone)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + this.firstName + ", lastName="
				+ this.lastName + ", email=" + this.email + ", phone="
				+ this.phone + ", address=" + this.address + ", creditCard="
				+ this.creditCard + ", orders=" + this.orders + ", getId()="
				+ this.getId() + "]";
	}

}
