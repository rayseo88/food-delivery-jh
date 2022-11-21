package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String foodId;
    private Long orderId;
    private String option;
    private Address address;
    private String status;

    public CookStarted(StoreOrder aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
