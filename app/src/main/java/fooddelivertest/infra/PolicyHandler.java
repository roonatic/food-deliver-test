package fooddelivertest.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivertest.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivertest.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertOrderStatus(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertOrderStatus : " + accepted + "\n\n");


        

        // Sample Logic //
        Order.alertOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertOrderStatus(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertOrderStatus : " + rejected + "\n\n");


        

        // Sample Logic //
        Order.alertOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_AlertOrderStatus(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener AlertOrderStatus : " + cooked + "\n\n");


        

        // Sample Logic //
        Order.alertOrderStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PickedUp'")
    public void wheneverPickedUp_AlertOrderStatus(@Payload PickedUp pickedUp){

        PickedUp event = pickedUp;
        System.out.println("\n\n##### listener AlertOrderStatus : " + pickedUp + "\n\n");


        

        // Sample Logic //
        Order.alertOrderStatus(event);
        

        

    }

}


