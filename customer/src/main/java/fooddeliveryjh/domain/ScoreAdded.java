package fooddeliveryjh.domain;

import fooddeliveryjh.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class ScoreAdded extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String foodid;
    private Integer score;
}
