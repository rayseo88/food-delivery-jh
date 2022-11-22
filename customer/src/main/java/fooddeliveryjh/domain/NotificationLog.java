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
        fooddeliveryjh.external.Order order = CustomerApplication.applicationContext
            .getBean(fooddeliveryjh.external.OrderService.class)
            .getOrder(storeAccepted.getId());

        NotificationLog notificationLog = new NotificationLog();
            notificationLog.setMessage("주문접수");
            notificationLog.setCustomerId(order.getCustomerId());        
        repository().save(notificationLog);
    }

    public static void sendTalk(StoreRejected storeRejected){

        NotificationLog notificationLog = new NotificationLog();

        notificationLog.setMessage("주문거부");
        repository().save(notificationLog);

    }
    public static void sendTalk(Paid paid){
        NotificationLog notificationLog = new NotificationLog();
        
        notificationLog.setMessage("결제완료");
        repository().save(notificationLog);

    }
    public static void sendTalk(OrderPlaced orderPlaced){

        NotificationLog notificationLog = new NotificationLog();
        
        notificationLog.setMessage("주문완료");
        repository().save(notificationLog);
        
    }
    public static void sendTalk(DeliveryStarted deliveryStarted){

        NotificationLog notificationLog = new NotificationLog();
        
        notificationLog.setMessage("배송시작");
        repository().save(notificationLog);
        
    }
    public static void sendTalk(CookStarted cookStarted){

        NotificationLog notificationLog = new NotificationLog();
        
        notificationLog.setMessage("조리시작");
        repository().save(notificationLog);
        
    }
    public static void sendTalk(Cooked cooked){

        NotificationLog notificationLog = new NotificationLog();
        
        notificationLog.setMessage("조리완료");
        repository().save(notificationLog);
        
    }


}
