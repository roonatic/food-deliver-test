package fooddelivertest.domain;

import fooddelivertest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Rejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String options;
    private String rejectedReason;
}
