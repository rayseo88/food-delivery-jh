package fooddeliveryjh.domain;

import fooddeliveryjh.domain.*;
import fooddeliveryjh.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ScoreAdded extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String foodid;
    private Integer score;

    public ScoreAdded(Evaluation aggregate){
        super(aggregate);
    }
    public ScoreAdded(){
        super();
    }
}
