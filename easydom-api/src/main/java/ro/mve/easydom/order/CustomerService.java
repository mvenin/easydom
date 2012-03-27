package ro.mve.easydom.order;

import ro.mve.easydom.order.dto.CustomerDto;

public interface CustomerService {
	long createCustomer(CustomerDto customer);
}
