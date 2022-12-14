package mallkde.domain;

import mallkde.domain.*;
import mallkde.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OederConfirmOrder extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Date orderTime;
    private Integer orderAmount;
    private Integer orderQty;
    private String orderSubject;
    private Long custId;
    private Date orederTime;
    private String adress;
    private Date cancelTime;
    private String stroreId;

    public OederConfirmOrder(DeliveryOrderProcessing aggregate){
        super(aggregate);
    }
    public OederConfirmOrder(){
        super();
    }
}
