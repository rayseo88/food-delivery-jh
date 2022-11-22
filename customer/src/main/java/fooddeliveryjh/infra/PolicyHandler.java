package fooddeliveryjh.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddeliveryjh.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddeliveryjh.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    @Autowired EvaluationRepository evaluationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @Autowired
    fooddeliveryjh.external.OrderService orderService;

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreAccepted'")
    public void wheneverStoreAccepted_SendTalk(@Payload StoreAccepted storeAccepted){

        StoreAccepted event = storeAccepted;
        System.out.println("\n\n##### listener SendTalk : " + storeAccepted + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreRejected'")
    public void wheneverStoreRejected_SendTalk(@Payload StoreRejected storeRejected){

        StoreRejected event = storeRejected;
        System.out.println("\n\n##### listener SendTalk : " + storeRejected + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_SendTalk(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener SendTalk : " + paid + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_SendTalk(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener SendTalk : " + orderPlaced + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_SendTalk(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener SendTalk : " + deliveryStarted + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStarted'")
    public void wheneverCookStarted_SendTalk(@Payload CookStarted cookStarted){

        CookStarted event = cookStarted;
        System.out.println("\n\n##### listener SendTalk : " + cookStarted + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_SendTalk(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener SendTalk : " + cooked + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//카카오톡 알림 - policy

        // Sample Logic //
        NotificationLog.sendTalk(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_RequestScore(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener RequestScore : " + delivered + "\n\n");


        // Comments // 
		//배송 완료로 인한 스코어 등록 준비 - policy

        // Sample Logic //
        Evaluation.requestScore(event);
        

        

    }

}


