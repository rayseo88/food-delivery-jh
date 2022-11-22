package fooddeliveryjh.domain;

import fooddeliveryjh.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="NotificationLog_table")
@Data

public class NotificationLog  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String message;


    public static NotificationLogRepository repository(){
        NotificationLogRepository notificationLogRepository = CustomerApplication.applicationContext.getBean(NotificationLogRepository.class);
        return notificationLogRepository;
    }




    public static void sendTalk(StoreAccepted storeAccepted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(storeAccepted.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void sendTalk(StoreRejected storeRejected){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(storeRejected.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void sendTalk(Paid paid){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void sendTalk(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void sendTalk(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void sendTalk(CookStarted cookStarted){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }
    public static void sendTalk(Cooked cooked){

        /** Example 1:  new item 
        NotificationLog notificationLog = new NotificationLog();
        repository().save(notificationLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(notificationLog->{
            
            notificationLog // do something
            repository().save(notificationLog);


         });
        */

        
    }


}
