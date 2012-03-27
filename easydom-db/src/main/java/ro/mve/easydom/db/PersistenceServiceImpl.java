package ro.mve.easydom.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import ro.mve.easydom.order.dto.PurchaseOrderDto;

@Service
public class PersistenceServiceImpl implements PersistenceService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public long create(PurchaseOrderDto order) {
		this.em.persist(order);
		return 1L;// order.getId();
	}

}
