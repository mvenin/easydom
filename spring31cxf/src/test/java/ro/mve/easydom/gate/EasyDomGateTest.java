package ro.mve.easydom.gate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.mve.easydom.web.ShopOrderService;
import ro.mve.easydom.web.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class EasyDomGateTest {

	@Autowired
	ShopOrderService shopOrderService;

	@Test
	public void createCustomer() {
		Assert.assertNotNull(shopOrderService);
	}

}
