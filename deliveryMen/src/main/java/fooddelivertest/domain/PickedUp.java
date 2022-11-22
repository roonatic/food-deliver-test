package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PickedUp extends AbstractEvent {

    private Long id;
    private String orderId;

    public PickedUp(Delivery aggregate){
        super(aggregate);
    }
    public PickedUp(){
        super();
    }
}
