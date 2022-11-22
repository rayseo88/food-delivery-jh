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
    @Autowired OrderRepository orderRepository;
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreRejected'")
    public void wheneverStoreRejected_CancelPayment(@Payload StoreRejected storeRejected){

        StoreRejected event = storeRejected;
        System.out.println("\n\n##### listener CancelPayment : " + storeRejected + "\n\n");


        // Comments // 
		//oderCanceled나 StoreReject로 결제 취소 - policy

        // Sample Logic //
        Payment.cancelPayment(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_CancelPayment(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener CancelPayment : " + orderCanceled + "\n\n");


        // Comments // 
		//oderCanceled나 StoreReject로 결제 취소 - policy

        // Sample Logic //
        Payment.cancelPayment(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreRejected'")
    public void wheneverStoreRejected_Cancel(@Payload StoreRejected storeRejected){

        StoreRejected event = storeRejected;
        System.out.println("\n\n##### listener Cancel : " + storeRejected + "\n\n");


        // Comments // 
		//점주의 거절로 인한 주문 취소 - policy

        // Sample Logic //
        Order.cancel(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreAccepted'")
    public void wheneverStoreAccepted_UpdateStatus(@Payload StoreAccepted storeAccepted){

        StoreAccepted event = storeAccepted;
        System.out.println("\n\n##### listener UpdateStatus : " + storeAccepted + "\n\n");


        // Comments // 
		//주문 상태 업데이트(주문접수/취소) - policy

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StoreRejected'")
    public void wheneverStoreRejected_UpdateStatus(@Payload StoreRejected storeRejected){

        StoreRejected event = storeRejected;
        System.out.println("\n\n##### listener UpdateStatus : " + storeRejected + "\n\n");


        // Comments // 
		//주문 상태 업데이트(주문접수/취소) - policy

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_Pay(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener Pay : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Payment.pay(event);
        

        

    }

}


