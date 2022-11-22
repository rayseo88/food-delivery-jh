package fooddeliveryjh.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="TopFood_table")
@Data
public class TopFood {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String foodid;
        private Long count;
        private Integer score;


}