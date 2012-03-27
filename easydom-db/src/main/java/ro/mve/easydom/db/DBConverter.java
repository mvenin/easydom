package ro.mve.easydom.db;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.mve.easydom.db.model.Customer;
import ro.mve.easydom.db.model.PurchaseOrder;
import ro.mve.easydom.order.dto.CustomerDto;
import ro.mve.easydom.order.dto.PurchaseOrderDto;

@Component
public class DBConverter {

	private final Mapper dozerMapper;

	@Autowired
	DBConverter(Mapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}

	CustomerDto convert(Customer dto) {
		CustomerDto entity = this.dozerMapper.map(dto, CustomerDto.class);
		return entity;
	}

	Customer convert(CustomerDto dto) {
		Customer entity = this.dozerMapper.map(dto, Customer.class);
		return entity;
	}

	PurchaseOrder convert(PurchaseOrderDto dto) {
		PurchaseOrder entity = this.dozerMapper.map(dto, PurchaseOrder.class);
		return entity;
	}

	PurchaseOrderDto convert(PurchaseOrder entity) {
		PurchaseOrderDto dto = this.dozerMapper.map(entity, PurchaseOrderDto.class);
		return dto;
	}
}
