package fooddeliveryjh.domain;

import fooddeliveryjh.domain.ScoreAdded;
import fooddeliveryjh.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Evaluation_table")
@Data

public class Evaluation  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Integer id;
    
    
    
    
    
    private Long orderid;
    
    
    
    
    
    private Integer score;

    @PostPersist
    public void onPostPersist(){


        ScoreAdded scoreAdded = new ScoreAdded(this);
        scoreAdded.publishAfterCommit();

    }

    public static EvaluationRepository repository(){
        EvaluationRepository evaluationRepository = CustomerApplication.applicationContext.getBean(EvaluationRepository.class);
        return evaluationRepository;
    }



    public void giveScore(GiveScoreCommand giveScoreCommand){
    }

    public static void requestScore(Delivered delivered){

        /** Example 1:  new item 
        Evaluation evaluation = new Evaluation();
        repository().save(evaluation);

        */

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(evaluation->{
            
            evaluation // do something
            repository().save(evaluation);


         });
        */

        
    }


}
