package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class StoreRejected extends AbstractEvent {

    private Long id;
    private Long customerid;
    private Long orderid;
}


