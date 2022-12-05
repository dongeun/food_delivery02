package mallkde.domain;

import mallkde.domain.*;
import mallkde.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class UnavailableArea extends AbstractEvent {

    private Long id;
    private Long oderId;
    private String adress;
    private Long custId;
    private String status;
    private String stroreId;

    public UnavailableArea(CheckOederAdress aggregate){
        super(aggregate);
    }
    public UnavailableArea(){
        super();
    }
}
