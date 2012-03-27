package ro.mve.easydom;

import java.util.Date;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import ro.mve.easydom.order.dto.PurchaseOrderDto;

public class JsonMasallTest {

    @Test
    public void mapperTest() throws Exception {
        ObjectMapper om = new ObjectMapper();

        PurchaseOrderDto o = this.newOrder();
        String json = om.writeValueAsString(o);
        System.out.println(json);
    }

    private PurchaseOrderDto newOrder() {
        PurchaseOrderDto o = new PurchaseOrderDto();
        o.setCreateDate(new Date());
        o.setCustomerId(1L);
        return o;
    }
}
