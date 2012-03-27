package ro.mve.easydom.order;

import java.util.List;

import ro.mve.easydom.order.dto.PurchaseOrderDto;

public interface OrderService {
	long createOrder(PurchaseOrderDto order);

	void updateOrder(PurchaseOrderDto order);

	void deleteOrder(PurchaseOrderDto order);

	PurchaseOrderDto findOrder(long orderId);

	List<PurchaseOrderDto> findOrders(long customerID);
}
