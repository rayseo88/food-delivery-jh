package fooddeliveryjh.domain;

import fooddeliveryjh.domain.OrderPlaced;
import fooddeliveryjh.domain.OrderCanceled;
import fooddeliveryjh.FrontApplication;
import javax.persistence.*;


import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id;
    
    private String foodId;
    
    private String customerId;
    
    private String option;
    
    @Embedded
    private String address;
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreRemove
    public void onPreRemove(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void cancel(StoreRejected storeRejected){

        repository().findById(storeRejected.getOrderid()).ifPresent(order->{
            
            order.setStatus("주문거부됨");
            repository().save(order);

         });


        
    }
    public static void updateStatus(StoreAccepted storeAccepted){

        repository().findById(storeAccepted.getOrderId()).ifPresent(order->{
            
            order.setStatus("주문수락됨");
            repository().save(order);


         });
        
    }
    public static void updateStatus(StoreRejected storeRejected){

        repository().findById(storeRejected.getOrderid()).ifPresent(order->{
            
            order.setStatus("주문거부됨");
            repository().save(order);

         });
        
    }


}
