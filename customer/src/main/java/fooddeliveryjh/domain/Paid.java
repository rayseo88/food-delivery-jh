package fooddeliveryjh.domain;

import fooddeliveryjh.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Long orderid;
}
