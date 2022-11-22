package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private String orderId;
    private String options;
    private String rejectedReason;

    public Rejected(StoreOrder aggregate){
        super(aggregate);
    }
    public Rejected(){
        super();
    }
}
