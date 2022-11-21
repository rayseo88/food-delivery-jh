package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StoreRejected extends AbstractEvent {

    private Long id;
    private Long customerid;
    private Long orderid;

    public StoreRejected(StoreOrder aggregate){
        super(aggregate);
    }
    public StoreRejected(){
        super();
    }
}