package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private String customerId;
    private String option;
    private Address address;
    private String status;

    public OrderPlaced(Order aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}
