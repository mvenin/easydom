package ro.mve.easydom.web.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.ResponseBody;

import ro.mve.easydom.order.dto.CustomerDto;

@Consumes("application/json")
@Produces("application/json")
public class ShopOrderService {

	@GET
	@Path("/orders")
	@ResponseBody
	public List<CustomerDto> getAllCustomers() {
		return Arrays.asList(new CustomerDto(), new CustomerDto());
	}
}
