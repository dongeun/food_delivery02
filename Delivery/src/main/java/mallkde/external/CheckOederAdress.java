package mallkde.external;

import lombok.Data;
import java.util.Date;
@Data
public class CheckOederAdress {

    private Long orderId;
    private Date orderTime;
    private Integer orderQty;
    private String orderSubject;
    private String status;
    private Long custId;
    private String storeId;
}


