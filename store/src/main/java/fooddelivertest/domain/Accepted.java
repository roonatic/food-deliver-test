package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Accepted extends AbstractEvent {

    private Long id;
    private Long orderId;

    public Accepted(StoreOrder aggregate){
        super(aggregate);
    }
    public Accepted(){
        super();
    }
}
