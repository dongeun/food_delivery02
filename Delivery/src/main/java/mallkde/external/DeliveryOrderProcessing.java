package mallkde.external;

import lombok.Data;
import java.util.Date;
@Data
public class DeliveryOrderProcessing {

    private Long id;
    private Date orderTime;
    private Long orderId;
    private Integer orderAmout;
    private Integer orderQty;
    private String orderSubject;
    private String adress;
}


