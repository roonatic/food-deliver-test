package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryFinished extends AbstractEvent {

    private Long id;
    private String address;
    private Long orderId;

    public DeliveryFinished(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryFinished(){
        super();
    }
}
