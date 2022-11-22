package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PickedUp extends AbstractEvent {

    private Long id;
    private String orderId;
}


