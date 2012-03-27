package ro.mve.easydom.db;

import ro.mve.easydom.order.dto.PurchaseOrderDto;

public interface PersistenceService {

	long create(PurchaseOrderDto order);

}
