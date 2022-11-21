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

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreAccepted'")
    public void wheneverStoreAccepted_카카오톡알림(@Payload StoreAccepted storeAccepted){

        StoreAccepted event = storeAccepted;
        System.out.println("\n\n##### listener 카카오톡알림 : " + storeAccepted + "\n\n");


        // Comments // 
		//카카오톡 알림

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreRejected'")
    public void wheneverStoreRejected_카카오톡알림(@Payload StoreRejected storeRejected){

        StoreRejected event = storeRejected;
        System.out.println("\n\n##### listener 카카오톡알림 : " + storeRejected + "\n\n");


        // Comments // 
		//카카오톡 알림

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_카카오톡알림(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener 카카오톡알림 : " + cooked + "\n\n");


        // Comments // 
		//카카오톡 알림

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_카카오톡알림(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener 카카오톡알림 : " + paid + "\n\n");


        // Comments // 
		//카카오톡 알림

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_카카오톡알림(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener 카카오톡알림 : " + orderPlaced + "\n\n");


        // Comments // 
		//카카오톡 알림

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_카카오톡알림(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener 카카오톡알림 : " + deliveryStarted + "\n\n");


        // Comments // 
		//카카오톡 알림

        // Sample Logic //
        NotificationLog.카카오톡알림(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_RequestScore(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener RequestScore : " + delivered + "\n\n");


        // Comments // 
		//배송 완료로 인한 스코어 등록 준비

        // Sample Logic //
        Evaluation.requestScore(event);
        

        

    }

}


