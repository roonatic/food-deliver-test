package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Payed extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer cost;

    public Payed(PayHistory aggregate){
        super(aggregate);
    }
    public Payed(){
        super();
    }
}
