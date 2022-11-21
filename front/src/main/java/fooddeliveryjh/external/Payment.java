package fooddeliveryjh.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Long foodId;
    private Long customerid;
    private String preference;
    private Object address;
    private String status;
}


