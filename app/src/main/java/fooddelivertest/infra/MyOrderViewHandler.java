package fooddelivertest.infra;

import fooddelivertest.domain.*;
import fooddelivertest.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyOrderViewHandler {


    @Autowired
    private MyOrderRepository myOrderRepository;



    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_1(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
                // view 객체 조회

                List<MyOrder> myOrderList = myOrderRepository.findByOrderId(accepted.getOrderId());
                for(MyOrder myOrder : myOrderList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myOrder.setStatus("accepted");
                // view 레파지 토리에 save
                myOrderRepository.save(myOrder);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPickedUp_then_UPDATE_2(@Payload PickedUp pickedUp) {
        try {
            if (!pickedUp.validate()) return;
                // view 객체 조회

                List<MyOrder> myOrderList = myOrderRepository.findByOrderId(pickedUp.getOrderId());
                for(MyOrder myOrder : myOrderList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myOrder.setStatus("pickedUp");
                // view 레파지 토리에 save
                myOrderRepository.save(myOrder);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCooked_then_UPDATE_3(@Payload Cooked cooked) {
        try {
            if (!cooked.validate()) return;
                // view 객체 조회

                List<MyOrder> myOrderList = myOrderRepository.findByOrderId(cooked.getOrderId());
                for(MyOrder myOrder : myOrderList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myOrder.setStatus("cookStarted");
                // view 레파지 토리에 save
                myOrderRepository.save(myOrder);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_DELETE_1(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            myOrderRepository.deleteByOrderId(rejected.getOrderId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

