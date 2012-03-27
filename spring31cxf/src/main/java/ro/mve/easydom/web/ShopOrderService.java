package ro.mve.easydom.web;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.ResponseBody;

import ro.mve.easydom.web.model.CustomerDto;

//@Path("/orders")
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
