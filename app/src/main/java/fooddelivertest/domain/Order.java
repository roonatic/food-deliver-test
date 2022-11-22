package fooddelivertest.domain;

import fooddelivertest.domain.Ordered;
import fooddelivertest.domain.OrderCanceled;
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

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivertest.external.PayHistory payHistory = new fooddelivertest.external.PayHistory();
        // mappings goes here
        AppApplication.applicationContext.getBean(fooddelivertest.external.PayHistoryService.class)
            .pay(payHistory);


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
