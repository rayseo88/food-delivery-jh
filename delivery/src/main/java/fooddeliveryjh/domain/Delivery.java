package fooddeliveryjh.domain;

import fooddeliveryjh.domain.Delivered;
import fooddeliveryjh.domain.DeliveryStarted;
import fooddeliveryjh.DeliveryApplication;
import javax.persistence.*;

import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id; 
    
    private String address;
    
    private Long orderId;
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }

    public void acceptPick(){
    }
    public void deliveryConfirm(){
    }

    public static void addDeliverylist(OrderPlaced orderPlaced){

        Delivery delivery = new Delivery();

        // set attributes
        Delivery deliver = new Delivery();
        deliver.setAddress(orderPlaced.getAddress());
        deliver.setOrderId(orderPlaced.getId());
        deliver.setStatus( "미결제");

        repository().save(deliver);
        
    }
    public static void updateStatus(Cooked cooked){

        repository().findById(cooked.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("조리완료");
            repository().save(delivery);
    
         });


        
    }
    public static void updateStatus(CookStarted cookStarted){

        repository().findById(cookStarted.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("조리시작");
            repository().save(delivery);

        
    }


}
