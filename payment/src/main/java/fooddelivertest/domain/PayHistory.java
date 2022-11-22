package fooddelivertest.domain;

import fooddelivertest.domain.Payed;
import fooddelivertest.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="PayHistory_table")
@Data

public class PayHistory  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Integer cost;

    @PostPersist
    public void onPostPersist(){


        Payed payed = new Payed(this);
        payed.publishAfterCommit();

    }

    public static PayHistoryRepository repository(){
        PayHistoryRepository payHistoryRepository = PaymentApplication.applicationContext.getBean(PayHistoryRepository.class);
        return payHistoryRepository;
    }






}
