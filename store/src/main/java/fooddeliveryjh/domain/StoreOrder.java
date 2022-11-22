package fooddeliveryjh.domain;

import fooddeliveryjh.domain.Cooked;
import fooddeliveryjh.domain.StoreAccepted;
import fooddeliveryjh.domain.StoreRejected;
import fooddeliveryjh.domain.CookStarted;
import fooddeliveryjh.StoreApplication;
import javax.persistence.*;

import org.apache.tomcat.jni.Address;

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
    
    private Long orderId; 

    private Long customerId; 
    
    private String option;

    
    @Embedded
    
    private Address address;

    private String status;

    @PostPersist
    public void onPostPersist(){

    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }

    public void finishCook(){
        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
        setStatus("조리완료됨");
    }
    public void accept(){
        StoreAccepted storeAccepted = new StoreAccepted(this);
        storeAccepted.publishAfterCommit();
        setStatus("주문수락됨");
    }
    public void reject(){
        StoreRejected storeRejected = new StoreRejected(this);
        storeRejected.publishAfterCommit();
        setStatus("주문거부됨");
    }
    public void startCook(){
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
        setStatus("조리시작됨");
    }

    public static void addCooklist(OrderPlaced orderPlaced){

        /** Example 1:  new item */
        StoreOrder storeOrder = new StoreOrder();
        storeOrder.setCustomerId(orderPlaced.getCustomerId());
        storeOrder.setFoodId(orderPlaced.getFoodId());
        storeOrder.setOrderId(orderPlaced.getId());
        storeOrder.setStatus( "미결제");
        repository().save(storeOrder);
        
    }
    public static void cancelAlarm(OrderCanceled orderCanceled){

        repository().findById(orderCanceled.getId()).ifPresent(storeOrder->{
            
            storeOrder.setStatus("주문취소됨");
            repository().save(storeOrder);

    }
    public static void updateStatus(Paid paid){
        repository().findByOrderId(paid.getId()).ifPresent(storeOrder->{
            
            storeOrder.setStatus("결재됨");
            repository().save(storeOrder);

         });
        
    }


}
