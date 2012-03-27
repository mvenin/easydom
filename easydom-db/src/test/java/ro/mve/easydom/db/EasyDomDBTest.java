package ro.mve.easydom.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.mve.easydom.db.model.Customer;
import ro.mve.easydom.order.dto.CustomerDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
public class EasyDomDBTest {
	@Autowired
	DBConverter dbConverter;

	@Test
	public void createCustomer() {
		Customer dto = new Customer();
		dto.setFirstName("marian");
		CustomerDto order = this.dbConverter.convert(dto);
		System.out.println(order);
	}
}
