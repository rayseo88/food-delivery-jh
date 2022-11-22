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
    
    private String foodid;
    
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
        setScore(giveScoreCommand.getScore());
    }

    public static void requestScore(Delivered delivered){

        Evaluation evaluation = new Evaluation();
        evaluation.setScore(0);
        repository().save(evaluation);

  

    }


}
