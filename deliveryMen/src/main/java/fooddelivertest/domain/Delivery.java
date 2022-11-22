package fooddelivertest.domain;

import fooddelivertest.domain.PickedUp;
import fooddelivertest.domain.DeliveryFinished;
import fooddelivertest.DeliveryMenApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Long orderId;

    @PostPersist
    public void onPostPersist(){


        PickedUp pickedUp = new PickedUp(this);
        pickedUp.publishAfterCommit();



        DeliveryFinished deliveryFinished = new DeliveryFinished(this);
        deliveryFinished.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryMenApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void alertDelievery(Cooked cooked){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        repository().findById(cooked.getOrderId()).ifPresent(order->{
            
            order.setStatus("Start delivery"); // do something
            repository().save(order);


         });
    }


}
