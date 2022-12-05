package mallkde.domain;

import mallkde.domain.*;
import mallkde.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPleaced extends AbstractEvent {

    private Long id;
    private Long oderId;
    private Date orderTime;
    private Integer orderQty;
    private String orderSubject;
    private Long custId;
    private String custEmail;

    public OrderPleaced(Order aggregate){
        super(aggregate);
    }
    public OrderPleaced(){
        super();
    }
}
