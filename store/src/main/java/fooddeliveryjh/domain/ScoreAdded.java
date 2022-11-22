package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ScoreAdded extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String foodid;
    private Integer score;
}


