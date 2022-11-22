package fooddelivertest.domain;

import fooddelivertest.결제Application;
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

    @PostPersist
    public void onPostPersist(){
    }

    public static PayHistoryRepository repository(){
        PayHistoryRepository payHistoryRepository = 결제Application.applicationContext.getBean(PayHistoryRepository.class);
        return payHistoryRepository;
    }






}
