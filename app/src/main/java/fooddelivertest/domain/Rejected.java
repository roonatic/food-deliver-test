package fooddelivertest.domain;

import fooddelivertest.domain.*;
import fooddelivertest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String options;
    private String rejectedReason;
}


