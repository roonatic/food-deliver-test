package fooddelivertest.domain;

import fooddelivertest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Cooked extends AbstractEvent {

    private Long id;
    private Long foodId;
    private Long orderId;
    private String status;
}
