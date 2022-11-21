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
    @Autowired StoreOrderRepository storeOrderRepository;
    @Autowired MenuRepository menuRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_주문목록에추가(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener 주문목록에추가 : " + paid + "\n\n");


        // Comments // 
		//주문목록에 추가

        // Sample Logic //
        StoreOrder.주문목록에추가(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_주문취소알림(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener 주문취소알림 : " + orderCanceled + "\n\n");


        // Comments // 
		//OrderCanceled로 인한 주문 취소를 알림
		// 

        // Sample Logic //
        StoreOrder.주문취소알림(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ScoreAdded'")
    public void wheneverScoreAdded_AddScore(@Payload ScoreAdded scoreAdded){

        ScoreAdded event = scoreAdded;
        System.out.println("\n\n##### listener AddScore : " + scoreAdded + "\n\n");


        // Comments // 
		//입력받은 점수로 평점을 계산하여 update함
		// (최종 평점=(이전평점+평점)/count)

        // Sample Logic //
        Menu.addScore(event);
        

        

    }

}


