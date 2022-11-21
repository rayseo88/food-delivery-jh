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

    @Autowired
    fooddeliveryjh.external.OrderService orderService;

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_Delivery목록에추가(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener Delivery목록에추가 : " + cooked + "\n\n");

        // REST Request Sample
        
        // orderService.getOrder(/** mapping value needed */);


        // Comments // 
		//delivery목록에 추가

        // Sample Logic //
        Delivery.delivery목록에추가(event);
        

        

    }

}


