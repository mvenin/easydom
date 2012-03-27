package ro.mve.easydom.order;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.mve.easydom.db.PersistenceService;
import ro.mve.easydom.order.dto.PurchaseOrderDto;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private PersistenceService persistenceService;

	@Override
	public long createOrder(PurchaseOrderDto order) {
		return this.persistenceService.create(order);
	}

	@Override
	public PurchaseOrderDto findOrder(long orderId) {
		return new PurchaseOrderDto();
	}

	@Override
	public List<PurchaseOrderDto> findOrders(long customerID) {
		return Arrays.asList(new PurchaseOrderDto());
	}

	@Override
	public void updateOrder(PurchaseOrderDto order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(PurchaseOrderDto order) {
		// TODO Auto-generated method stub

	}

}
