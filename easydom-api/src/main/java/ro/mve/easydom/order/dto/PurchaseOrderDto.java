package ro.mve.easydom.order.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderDto {

    private long customerId;

    private Date createDate;

    private List<OrderLineDto> orderLines = new ArrayList<OrderLineDto>();

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<OrderLineDto> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDto> orderLines) {
        this.orderLines = orderLines;
    }
}
