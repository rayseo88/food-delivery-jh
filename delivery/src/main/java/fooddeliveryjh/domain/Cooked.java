package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String foodId;
    private Long orderId;
    private Object address;
    private String status;
}


