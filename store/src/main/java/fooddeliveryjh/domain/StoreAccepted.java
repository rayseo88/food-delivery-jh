package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StoreAccepted extends AbstractEvent {

    private Long id;
    private String foodId;
    private Long orderId;
    private String option;
    private Address address;
    private String status;

    public StoreAccepted(StoreOrder aggregate){
        super(aggregate);
    }
    public StoreAccepted(){
        super();
    }
}
