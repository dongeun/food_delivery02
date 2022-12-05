package mallkde.domain;

import mallkde.domain.*;
import mallkde.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderableArea extends AbstractEvent {

    private Long id;
    private Long oderId;
    private String adress;
    private Long custId;
    private String status;
    private String stroreId;
}


