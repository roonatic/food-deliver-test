package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryFinished extends AbstractEvent {

    private Long id;
    private String address;
    private Long orderId;
}


