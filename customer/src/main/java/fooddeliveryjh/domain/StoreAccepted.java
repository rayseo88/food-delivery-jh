package fooddeliveryjh.domain;

import fooddeliveryjh.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class StoreAccepted extends AbstractEvent {

    private Long id;
    private String foodId;
    private Long orderId;
    private String option;
    private Address address;
    private String status;
}
