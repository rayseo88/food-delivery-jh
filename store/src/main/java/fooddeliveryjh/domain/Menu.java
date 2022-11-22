package fooddeliveryjh.domain;

import fooddeliveryjh.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Menu_table")
@Data

public class Menu  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String id;
    
    
    
    
    
    private Long count;
    
    
    
    
    
    private Long totalScore;

    @PrePersist
    public void onPrePersist(){
    }

    public static MenuRepository repository(){
        MenuRepository menuRepository = StoreApplication.applicationContext.getBean(MenuRepository.class);
        return menuRepository;
    }




    public static void addScore(ScoreAdded scoreAdded){

        /** Example 1:  new item 
        Menu menu = new Menu();
        repository().save(menu);

        */

        /** Example 2:  finding and process
        
        repository().findById(scoreAdded.get???()).ifPresent(menu->{
            
            menu // do something
            repository().save(menu);


         });
        */

        
    }


}
