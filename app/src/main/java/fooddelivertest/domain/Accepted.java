package fooddelivertest.domain;

import fooddelivertest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Accepted extends AbstractEvent {

    private Long id;
    private Long orderId;
}
