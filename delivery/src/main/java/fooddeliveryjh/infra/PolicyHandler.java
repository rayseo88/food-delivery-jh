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
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_AddDeliverylist(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener AddDeliverylist : " + orderPlaced + "\n\n");


        // Comments // 
		//주문시 delivery목록에 추가  - policy

        // Sample Logic //
        Delivery.addDeliverylist(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_UpdateStatus(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener UpdateStatus : " + cooked + "\n\n");


        // Comments // 
		//조리 완료 시 상태 update - policy

        // Sample Logic //
        Delivery.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookStarted'")
    public void wheneverCookStarted_UpdateStatus(@Payload CookStarted cookStarted){

        CookStarted event = cookStarted;
        System.out.println("\n\n##### listener UpdateStatus : " + cookStarted + "\n\n");


        // Comments // 
		//조리 완료 시 상태 update - policy

        // Sample Logic //
        Delivery.updateStatus(event);
        

        

    }

}


