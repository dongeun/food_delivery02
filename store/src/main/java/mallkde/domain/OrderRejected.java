package mallkde.domain;

import mallkde.domain.*;
import mallkde.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private Long oderId;
    private Integer orderAmount;
    private Date orderTime;
    private Integer orderQty;
    private String orderSubject;
    private Long custId;
    private String custEmail;
    private Date approveTime;

    public OrderRejected(FoodCooking aggregate){
        super(aggregate);
    }
    public OrderRejected(){
        super();
    }
}
