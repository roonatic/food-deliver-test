package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String foodId;
    private String orderId;
    private String status;

    public Cooked(StoreOrder aggregate){
        super(aggregate);
    }
    public Cooked(){
        super();
    }
}
