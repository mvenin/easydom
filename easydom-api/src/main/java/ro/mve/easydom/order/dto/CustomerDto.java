package ro.mve.easydom.order.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String creditCard;

	private final List<PurchaseOrderDto> orders = new ArrayList<PurchaseOrderDto>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<PurchaseOrderDto> getOrders() {
		return this.orders;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName
				+ ", email=" + this.email + ", phone=" + this.phone + ", address=" + this.address + ", creditCard="
				+ this.creditCard + ", orders=" + this.orders + "]";
	}

}
