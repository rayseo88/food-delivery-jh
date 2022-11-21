package fooddeliveryjh.domain;

import fooddeliveryjh.domain.Cooked;
import fooddeliveryjh.domain.StoreAccepted;
import fooddeliveryjh.domain.StoreRejected;
import fooddeliveryjh.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;
    
    
    
    @Embedded
    
    private Address address;

    @PostPersist
    public void onPostPersist(){


        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        StoreAccepted storeAccepted = new StoreAccepted(this);
        storeAccepted.publishAfterCommit();



        StoreRejected storeRejected = new StoreRejected(this);
        storeRejected.publishAfterCommit();

    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }



    public void finishCook(){
    }
    public void accept(){
    }
    public void reject(){
    }
    public void startCook(){
    }

    public static void 주문목록에추가(Paid paid){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }
    public static void 주문취소알림(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

        
    }


}
