package fooddelivertest.domain;

import fooddelivertest.domain.Cooked;
import fooddelivertest.domain.Rejected;
import fooddelivertest.domain.Accepted;
import fooddelivertest.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();

    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }






}
