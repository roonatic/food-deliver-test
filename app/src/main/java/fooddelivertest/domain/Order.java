package fooddelivertest.domain;

import fooddelivertest.domain.OrderCanceled;
import fooddelivertest.domain.Ordered;
import fooddelivertest.AppApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private Integer amount;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String reason;
    
    
    
    
    
    private Double foodCost;

    @PostPersist
    public void onPostPersist(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivertest.external.PayHistory payHistory = new fooddelivertest.external.PayHistory();
        // mappings goes here
        AppApplication.applicationContext.getBean(fooddelivertest.external.PayHistoryService.class)
            .pay(payHistory);

        if(payHistory.getCost() < amount * foodCost) throw new RuntimeException("cannot order: not enough money!");
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }

    public static void alertOrderStatus(Accepted accepted){

        repository().findById(accepted.getOrderId()).ifPresent(order->{
            
            order.setStatus("ACCEPTED"); // do something
            repository().save(order);


         });
    }
    public static void alertOrderStatus(Rejected rejected){

        repository().findById(rejected.getOrderId()).ifPresent(order->{
            
            order.setStatus("REJECTED"); // do something
            order.setReason(rejected.getRejectedReason());
            repository().save(order);


         });
    }
    public static void alertOrderStatus(Cooked cooked){

        repository().findById(cooked.getOrderId()).ifPresent(order->{
            
            order.setStatus("COOKED"); // do something
            repository().save(order);


         });
    }
    public static void alertOrderStatus(PickedUp pickedUp){

        repository().findById(pickedUp.getOrderId()).ifPresent(order->{
            
            order.setStatus("PICKED UP"); // do something
            repository().save(order);


         });

    }
    public static void alertOrderStatus(DeliveryFinished deliveryFinished){

        repository().findById(deliveryFinished.getOrderId()).ifPresent(order->{
            
            order.setStatus("DELIVERY FINISHED"); // do something
            repository().save(order);


         });    
    }


}
